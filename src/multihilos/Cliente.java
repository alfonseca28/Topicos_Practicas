package multihilos;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 *
 * @author Aarón Alfonseca
 */
public class Cliente {

    BufferedReader in;
    PrintWriter out;

    Socket cnx;

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new Cliente()).start();
            }
        });
    }

    void start() {
        String respuesta = "", comando = "";
        Conexion hilo;
        Scanner consola = new Scanner(System.in);
        try {
            this.cnx = new Socket("192.168.100.26", 4444);     //direccionIP(original): 25.0.144.56

            in = new BufferedReader(new InputStreamReader(cnx.getInputStream()));
            out = new PrintWriter(cnx.getOutputStream(), true);

            hilo = new Conexion(in);
            hilo.start(); //Hilo encargado de lecturas del servidor

            while (!comando.toLowerCase().contains("salir")) {
                comando = consola.nextLine();
                out.println(comando);
            }

            hilo.ejecutar = false;
            Thread.sleep(2000);

            this.cnx.close();

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    class Conexion extends Thread {

        public boolean ejecutar = true;
        BufferedReader in;

        public Conexion(BufferedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            String respuesta = "";
            while (ejecutar) {
                try {
                    respuesta = in.readLine();
                    if (respuesta != null) {
                        System.out.println(respuesta);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
