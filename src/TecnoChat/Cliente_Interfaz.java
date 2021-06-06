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
        jDialog1.setSize(800, 415);
        sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");

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
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        textUserName = new javax.swing.JTextField();
        textPass = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lbIconLogin = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        jDialog1.setPreferredSize(new java.awt.Dimension(800, 400));

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

        pantalla.setEditable(false);
        pantalla.setBackground(new java.awt.Color(255, 255, 255));
        pantalla.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 12)); // NOI18N
        pantalla.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(pantalla);

        btnSendMessage.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnSendMessage.setForeground(new java.awt.Color(0, 0, 0));
        btnSendMessage.setText("Enviar");
        btnSendMessage.setEnabled(false);
        btnSendMessage.setMaximumSize(new java.awt.Dimension(46, 26));
        btnSendMessage.setMinimumSize(new java.awt.Dimension(46, 26));
        btnSendMessage.setPreferredSize(new java.awt.Dimension(46, 26));
        btnSendMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMessageActionPerformed(evt);
            }
        });

        txtmsg.setBackground(new java.awt.Color(255, 255, 255));
        txtmsg.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        txtmsg.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel5.setText("Escribe un mensaje");

        jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jButton1.setText("Salir");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialog1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(usersOnline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addComponent(txtmsg, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSendMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
            .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(264, Short.MAX_VALUE)))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usersOnline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSendMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(24, 24, 24))
            .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(80, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textUserName.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        textUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUserNameActionPerformed(evt);
            }
        });

        textPass.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N

        btnLogin.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(0, 0, 0));
        btnLogin.setText("Ingresar");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lbIconLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TecnoChat/tecnochat_logo.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Introduce tu usuario:");

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Introduce tu contraseña:");

        btnSalir.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(lbIconLogin))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textPass, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbIconLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        hilo = new Conexion(in, textUserName.getText(), new String(textPass.getPassword()));
        hilo.start();
        jDialog1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSendMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMessageActionPerformed
        hilo.sendMessage(txtmsg.getText());
        pantalla.setText(pantalla.getText() + "[" + sdf.format(new Date()) + "] " + nombreUsuario + ": " + txtmsg.getText() + "\n");
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
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSendMessage;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbIconLogin;
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
