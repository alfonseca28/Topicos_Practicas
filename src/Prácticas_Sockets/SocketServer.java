/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prácticas_Sockets;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketServer {

    int portNumber = 4444; //Integer.parseInt(args[0]);
    ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        SocketServer srv = new SocketServer();
        srv.run();
    }

    void run() {
        try {
            serverSocket = new ServerSocket(portNumber);

            while (true) {
                Socket cliente = serverSocket.accept();
                System.out.println("Recibiendo conexion nueva");
                new TareaConexion(cliente).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    class TareaConexion extends Thread {

        Socket clientSocket;
        PrintWriter out;
        BufferedReader in;

        public TareaConexion(Socket cliente) {
            this.clientSocket = cliente;
        }

        @Override
        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                System.out.printf("Conectado desde %s\n", clientSocket.getInetAddress().toString());

                String inputLine, outputLine;

                // Initiate conversation with client
                KnockKnockProtocol kkp = new KnockKnockProtocol();
                outputLine = kkp.processInput(null);
                out.println(outputLine);

                while ((inputLine = in.readLine()) != null) {
                    outputLine = kkp.processInput(inputLine);
                    out.println(outputLine);
                    if (outputLine.equals("Bye.")) {
                        break;
                    }
                }
            } catch (IOException ioe) {
                System.out.println("Exception caught when trying to listen on port "
                        + portNumber + " or listening for a connection");
                System.out.println(ioe.getMessage());
            }
        }
    }
}
