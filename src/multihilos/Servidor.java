/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multihilos;

import java.net.*;
import java.io.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

// Se agregan las librerias para conectar con la BD
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import practicas.sockets.SocketServer;

/**
 *
 * @author Aarón Alfonseca
 */
public class Servidor {

    ArrayList<Conexion> conexiones;
    ServerSocket ss;
    Connection conn;

    /*
    String [][] usuarios = {{"hugo",  "123"},
                            {"paco",  "345"},
                            {"luis",  "890"},
                            {"donald","678"}};
     */
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
            // Se realiza una sola conexion
            if (conn == null) {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/encuesta?"
                        + "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=encuesta&password=encuesta");
            }

            ss = new ServerSocket(4444);
            System.out.println("Servidor iniciado, en espera de conexiones");

            while (true) {
                socket = ss.accept();
                cnx = new Conexion(this, socket, conexiones.size(), this.conn);
                conexiones.add(cnx);
                cnx.start();
            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Broadcasting
    private void difundir(String id, String mensaje) {
        Conexion hilo;
        for (int i = 0; i < this.conexiones.size(); i++) {
            hilo = this.conexiones.get(i);
            if (hilo.cnx.isConnected()) {
                if (!id.equals(hilo.id)) {
                    hilo.enviar(mensaje);
                }
            }
        }//To change body of generated methods, choose Tools | Templates.
    }

    class Conexion extends Thread {

        BufferedReader in;
        PrintWriter out;
        Connection conn;
        Socket cnx;
        Servidor padre;
        int numCnx = -1;
        String id = "";

        public final int SIN_USER = 0;
        public final int USER_IDENT = 1;
        public final int PASS_PDTE = 2;
        public final int PASS_OK = 3;
        public final int CHAT = 4;

        public Conexion(Servidor padre, Socket socket, int num, Connection _conn) {
            this.conn = _conn;
            this.cnx = socket;
            this.padre = padre;
            this.numCnx = num;
            this.id = socket.getInetAddress().getHostAddress() + "-" + num;
        }

        @Override
        public void run() {
            String linea = "", user = "", pass = "", mensaje = "";
            String passValido = "";
            int estado = SIN_USER;
            int usr = -1;
            int intentos = 3;

            Statement stmt;
            ResultSet rset;

            String sQuery = "";

            try {
                in = new BufferedReader(new InputStreamReader(cnx.getInputStream()));
                out = new PrintWriter(cnx.getOutputStream(), true);

                System.out.printf("Aceptando conexion desde %s\n",
                        cnx.getInetAddress().getHostAddress());

                while (!mensaje.toLowerCase().equals("salir") && intentos > 0) {
                    switch (estado) {
                        case SIN_USER:
                            out.println("Bienvenido, proporcione su usuario");
                            estado = USER_IDENT;
                            break;
                        case USER_IDENT:
                            user = in.readLine();
                            boolean found = false;
                            sQuery = "SELECT usuario,password FROM usuarios WHERE usuario = '" + user + "'";

                            try {
                                stmt = conn.createStatement();
                                rset = stmt.executeQuery(sQuery);

                                if (rset.next()) {
                                    passValido = rset.getString("password");
                                    found = true;   //Esto era lo que habia que agregar xd
                                }

                            } catch (SQLException sqle) {

                            }

                            if (!found) {
                                estado = SIN_USER;
                                out.println("Usuario incorrecto o no encontrado en la base de datos\n Intente con otro usuario");
                            } else {
                                estado = PASS_PDTE;
                            }
                            break;
                        case PASS_PDTE:
                            out.println("Escriba el password");
                            pass = in.readLine();
                            if (pass.equals(passValido)) {
                                estado = PASS_OK;
                            } else {
                                out.println("La contraseña es incorrecta, vuelve a intentar de nuevo\n");
                            }
                            --intentos;
                            break;
                        case PASS_OK:
                            out.println("Autenticado!");
                            estado = CHAT;
                            break;
                        case CHAT:
                            mensaje = in.readLine();
                            System.out.printf("%s - %s\n",
                                    cnx.getInetAddress().getHostAddress(),
                                    user + ":" + mensaje);

                            this.padre.difundir(this.id, this.id + " | " + user + " : " + mensaje);
                            break;
                    }
                }
                this.cnx.close();
                System.out.println("Cerrando conexion: " + this.id);
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private void enviar(String mensaje) {
            this.out.println(mensaje); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
