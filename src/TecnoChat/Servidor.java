package TecnoChat;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Aarón Alfonseca
 */
public class Servidor {

    ArrayList<Conexion> conexiones;
    ArrayList<String> usersOnline = new ArrayList<String>();
    ServerSocket ss;
    String[][] usuarios = {
        {"hugo", "123"},
        {"paco", "345"},
        {"luis", "890"},
        {"donald", "678"}};

    private static final String MESSAGE_SERVER = "message_server";
    private static final String MESSAGE_LOGIN = "message_login";
    private static final String MESSAGE = "message";
    private static final String USERS_ONLINE = "users_online";

    ;
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new Servidor()).start();
            }
        });
    }

    private void start() {
        this.conexiones = new ArrayList<>();
        Socket socket;
        Conexion cnx;
        try {
            ss = new ServerSocket(4444);
            System.out.println("Servidor iniciado, en espera de conexiones");

            while (true) {
                socket = ss.accept();
                cnx = new Conexion(this, socket, conexiones.size());
                conexiones.add(cnx);
                cnx.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Broadcasting
    private void difundir(String id, String mensaje, String type, String user, Boolean all) {
        Conexion hilo;
        JSONObject message = new JSONObject();
        message.put("type", type);
        message.put("message", mensaje);
        message.put("sender", user);
        if (all) {
            for (int i = 0; i < this.conexiones.size(); i++) {
                hilo = this.conexiones.get(i);
                if (hilo.cnx.isConnected() && hilo.estado == hilo.CHAT) {
                    hilo.send(message.toString());
                }
            }
        } else {
            for (int i = 0; i < this.conexiones.size(); i++) {
                hilo = this.conexiones.get(i);
                if (hilo.cnx.isConnected() && hilo.estado == hilo.CHAT && !id.equals(hilo.id)) {
                    hilo.send(message.toString());
                }
            }
        }
    }

    private void usuariosonline(String id) {
        Conexion hilo;
        JSONObject message = new JSONObject();
        message.put("type", USERS_ONLINE);
        JSONArray a = new JSONArray(usersOnline);
        message.put("users_online", a);
        for (int i = 0; i < this.conexiones.size(); i++) {
            hilo = this.conexiones.get(i);
            if (hilo.cnx.isConnected() && hilo.estado == hilo.CHAT) {
                hilo.send(message.toString());
            }   
        }//To change body of generated methods, choose Tools | Templates.
    }

    class Conexion extends Thread {

        public final int SIN_USER = 0;
        public final int USER_IDENT = 1;
        public final int PASS_PDTE = 2;
        public final int PASS_OK = 3;
        public final int CHAT = 4;

        BufferedReader in;
        PrintWriter out;
        Socket cnx;
        Servidor padre;
        int numCnx = -1;
        String id = "";
        int estado = SIN_USER;

        public Conexion(Servidor padre, Socket socket, int num) {
            this.cnx = socket;
            this.padre = padre;
            this.numCnx = num;
            this.id = socket.getInetAddress().getHostAddress() + num;
        }

        @Override
        public void run() {
            String linea = "", username = "", pass = "";
            JSONObject user, message;
            int usr = -1;
            try {
                in = new BufferedReader(new InputStreamReader(cnx.getInputStream()));
                out = new PrintWriter(cnx.getOutputStream(), true);
                System.out.printf("Aceptando la conexión de %s\n", cnx.getInetAddress().getHostAddress());
                while (estado != CHAT) {
                    switch (estado) {
                        case SIN_USER:
                            status("Hola, inicia sesión.", false);
                            estado = USER_IDENT;
                            break;
                        case USER_IDENT:
                            linea = in.readLine();
                            user = new JSONObject(linea);
                            if (user.has("username") && user.has("password")) {
                                username = user.getString("username");
                                pass = user.getString("password");
                                boolean found = false;
                                for (int i = 0; i < usuarios.length; i++) {
                                    if (username.equals(usuarios[i][0]) && pass.equals(usuarios[i][1])) {
                                        found = true;
                                        usr = i;
                                    }
                                }
                                if (!found) {
                                    status("Verifica tu usuario y tu contraseña", false);
                                } else {
                                    estado = CHAT;
                                    status("Hola bienvenido", true);
                                }
                            }
                            break;
                    }
                }

                this.padre.difundir(id, username + " ha entrado en el chat.", MESSAGE_SERVER, username, true);
                usersOnline.add(username);
                this.padre.usuariosonline(id);
                System.out.printf("[%s] %s se ha conectado al servidor.\n", cnx.getInetAddress().getHostAddress(), username);
                while ((linea = in.readLine()) != null) {
                    message = new JSONObject(linea);
                    String type = message.getString("type");
                    if (type.equals(MESSAGE)) {
                        if (!message.getString("message").equals("/salir")) {
                            System.out.printf("[%s] %s: %s\n", cnx.getInetAddress().getHostAddress(), username, linea);
                            this.padre.difundir(this.id, message.getString("message"), MESSAGE, username, false);
                        } else {
                            this.padre.difundir(id, username + " ha abandonado chat.", MESSAGE_SERVER, username, true);
                            System.out.printf("[%s] %s ha abandonado el servidor.\n", cnx.getInetAddress().getHostAddress(), username);
                            estado = SIN_USER;
                            usersOnline.remove(username);
                            this.padre.usuariosonline(id);
                            break;
                        }
                    }
                }

            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private void send(String mensaje) {
            this.out.println(mensaje); //To change body of generated methods, choose Tools | Templates.
        }

        private void status(String mensaje, boolean online) {
            JSONObject message = new JSONObject();
            message.put("type", MESSAGE_LOGIN);
            message.put("online", online);
            message.put("message", mensaje);
            send(message.toString()); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
