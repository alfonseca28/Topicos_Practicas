package TecnoChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;

/**
 *
 * @author Aarón Alfonseca
 */
public class Cliente_Interfaz extends javax.swing.JFrame {

    private static final String MESSAGE_SERVER = "message_server";
    private static final String MESSAGE_LOGIN = "message_login";
    private static final String MESSAGE = "message";
    private static final String USERS_ONLINE = "users_online";
    ;
    
    BufferedReader in;
    SimpleDateFormat sdf;
    String nombreUsuario;
    PrintWriter out;
    Socket cnx;
    Conexion hilo;
    Boolean online = false;

    public Cliente_Interfaz() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        jDialog1.setSize(730, 450);
        jDialog1.setLocationRelativeTo(null);

        sdf = new SimpleDateFormat("dd MMMM HH:mm");
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jDialog1 = new javax.swing.JDialog();
        usersOnline = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        textUsersOnline = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        pantalla = new javax.swing.JTextPane();
        btnSendMessage = new javax.swing.JButton();
        txtmsg = new javax.swing.JTextField();
        lbEscribe = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        lbTecnoChat = new javax.swing.JLabel();
        lbFondoChat = new javax.swing.JLabel();
        lbIconLogin = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        textUserName = new javax.swing.JTextField();
        lbContrasena = new javax.swing.JLabel();
        textPass = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lbFondoLogin = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        jDialog1.setBackground(new java.awt.Color(0, 0, 0));
        jDialog1.setUndecorated(true);
        jDialog1.setPreferredSize(new java.awt.Dimension(800, 400));
        jDialog1.setResizable(false);
        jDialog1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usersOnline.setBackground(new java.awt.Color(255, 255, 255));
        usersOnline.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Usuarios");

        textUsersOnline.setBackground(new java.awt.Color(255, 255, 255));
        textUsersOnline.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 12)); // NOI18N
        textUsersOnline.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(textUsersOnline);

        javax.swing.GroupLayout usersOnlineLayout = new javax.swing.GroupLayout(usersOnline);
        usersOnline.setLayout(usersOnlineLayout);
        usersOnlineLayout.setHorizontalGroup(
            usersOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(usersOnlineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(usersOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(usersOnlineLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 112, Short.MAX_VALUE)))
                .addContainerGap())
        );
        usersOnlineLayout.setVerticalGroup(
            usersOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usersOnlineLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDialog1.getContentPane().add(usersOnline, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, -1, -1));

        pantalla.setEditable(false);
        pantalla.setBackground(new java.awt.Color(255, 255, 255));
        pantalla.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 12)); // NOI18N
        pantalla.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(pantalla);

        jDialog1.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 465, 340));

        btnSendMessage.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnSendMessage.setForeground(new java.awt.Color(0, 0, 0));
        btnSendMessage.setText("Enviar");
        btnSendMessage.setEnabled(false);
        btnSendMessage.setMaximumSize(new java.awt.Dimension(46, 25));
        btnSendMessage.setMinimumSize(new java.awt.Dimension(46, 25));
        btnSendMessage.setPreferredSize(new java.awt.Dimension(46, 26));
        btnSendMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMessageActionPerformed(evt);
            }
        });
        jDialog1.getContentPane().add(btnSendMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 71, 27));

        txtmsg.setBackground(new java.awt.Color(255, 255, 255));
        txtmsg.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        txtmsg.setForeground(new java.awt.Color(0, 0, 0));
        jDialog1.getContentPane().add(txtmsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 378, -1));

        lbEscribe.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        lbEscribe.setText("Escribe un mensaje");
        jDialog1.getContentPane().add(lbEscribe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        btnRegresar.setBackground(new java.awt.Color(51, 204, 0));
        btnRegresar.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jDialog1.getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 410, 100, -1));

        lbTecnoChat.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        lbTecnoChat.setText("TecnoChat");
        jDialog1.getContentPane().add(lbTecnoChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lbFondoChat.setBackground(new java.awt.Color(0, 0, 0));
        lbFondoChat.setForeground(new java.awt.Color(0, 0, 0));
        jDialog1.getContentPane().add(lbFondoChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 450));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbIconLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TecnoChat/Imagenes/tecnochat_logo.png"))); // NOI18N
        getContentPane().add(lbIconLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 25, -1, 180));

        lbUsuario.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        lbUsuario.setForeground(new java.awt.Color(0, 0, 0));
        lbUsuario.setText("Introduce tu usuario:");
        getContentPane().add(lbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        textUserName.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        textUserName.setForeground(new java.awt.Color(0, 0, 0));
        textUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUserNameActionPerformed(evt);
            }
        });
        getContentPane().add(textUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 200, -1));

        lbContrasena.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        lbContrasena.setForeground(new java.awt.Color(0, 0, 0));
        lbContrasena.setText("Introduce tu contraseña:");
        getContentPane().add(lbContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        textPass.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        textPass.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(textPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 200, -1));

        btnLogin.setBackground(new java.awt.Color(51, 204, 0));
        btnLogin.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(0, 0, 0));
        btnLogin.setText("Ingresar");
        btnLogin.setBorder(null);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 386, 149, 30));

        btnSalir.setBackground(new java.awt.Color(255, 0, 0));
        btnSalir.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.setBorder(null);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 465, 64, 25));

        lbFondoLogin.setBackground(new java.awt.Color(0, 0, 0));
        lbFondoLogin.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lbFondoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMessageActionPerformed
        hilo.sendMessage(txtmsg.getText());
        pantalla.setText(pantalla.getText() + sdf.format(new Date()) + " - " + nombreUsuario + ": " + txtmsg.getText() + "\n");
        if (txtmsg.getText().equals("/salir")) {
            online = false;
            btnLogin.setEnabled(true);
            btnSendMessage.setEnabled(false);
        }
    }//GEN-LAST:event_btnSendMessageActionPerformed

    private void textUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textUserNameActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Cliente_Interfaz cli = new Cliente_Interfaz();
        cli.show();
        jDialog1.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        hilo = new Conexion(in, textUserName.getText(), new String(textPass.getPassword()));
        hilo.start();
        jDialog1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cliente_Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente_Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente_Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente_Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cliente_Interfaz main = new Cliente_Interfaz();
                main.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSendMessage;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbContrasena;
    private javax.swing.JLabel lbEscribe;
    private javax.swing.JLabel lbFondoChat;
    private javax.swing.JLabel lbFondoLogin;
    private javax.swing.JLabel lbIconLogin;
    private javax.swing.JLabel lbTecnoChat;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JTextPane pantalla;
    private javax.swing.JPasswordField textPass;
    private javax.swing.JTextField textUserName;
    private javax.swing.JTextPane textUsersOnline;
    private javax.swing.JTextField txtmsg;
    private javax.swing.JPanel usersOnline;
    // End of variables declaration//GEN-END:variables

    class Conexion extends Thread {

        public boolean ejecutar = true;
        BufferedReader in;
        private String contrasena;

        public Conexion(BufferedReader in, String user, String pass) {
            this.in = in;
            nombreUsuario = user;
            this.contrasena = pass;
        }

        @Override
        public void run() {
            try {
                cnx = new Socket("192.168.100.21", 4444);
                in = new BufferedReader(new InputStreamReader(cnx.getInputStream()));
                out = new PrintWriter(cnx.getOutputStream(), true);
                login(nombreUsuario, contrasena);
                String response = "";
                while (ejecutar) {
                    response = in.readLine();
                    if (response != null) {
                        receiveMessage(response);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private void login(String username, String pass) {
            JSONObject request = new JSONObject();
            request.put("type", MESSAGE_SERVER);
            request.put("username", username);
            request.put("password", pass);
            out.println(request.toString());
        }

        private void sendMessage(String msg) {
            JSONObject message = new JSONObject();
            message.put("type", MESSAGE);
            message.put("message", msg);
            out.println(message.toString());
        }

        private void finish() {
            try {
                ejecutar = false;
                this.sleep(2000);
                cnx.close();
                online = false;
            } catch (IOException ex) {
                Logger.getLogger(Cliente_Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente_Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private void receiveMessage(String response) {
            JSONObject message = new JSONObject(response);
            String type = message.getString("type");
            switch (type) {
                case MESSAGE_SERVER:
                    pantalla.setText(pantalla.getText() + message.getString("message") + "\n");
                    break;
                case MESSAGE:
                    pantalla.setText(pantalla.getText() + "[" + sdf.format(new Date()) + "] " + message.getString("sender") + ": " + message.getString("message") + "\n");
                    break;
                case USERS_ONLINE:
                    JSONArray a = message.getJSONArray("users_online");
                    textUsersOnline.setText("");
                    for (int i = 0; i < a.length(); i++) {
                        textUsersOnline.setText(textUsersOnline.getText() + a.getString(i) + "\n");
                    }
                    break;
                case MESSAGE_LOGIN:
                    System.out.println("mensaje login: " + message.getString("message") + " - online : " + message.getBoolean("online"));
                    pantalla.setText(pantalla.getText() + message.getString("message") + "\n");
                    online = message.getBoolean("online");
                    if (online) {
                        btnSendMessage.setEnabled(true);
                        btnLogin.setEnabled(false);
                    }
                    break;
            }
        }
    }
}
