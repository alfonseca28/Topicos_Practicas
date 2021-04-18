package Prácticas;

import java.io.FileWriter;
import java.io.IOException;

import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aarón Alfonseca
 */
public class Práctica07_Miniencuesta extends javax.swing.JFrame {

    Connection conn = null;

    /**
     * Creates new form Práctica07_Miniencuesta
     */
    public Práctica07_Miniencuesta() {
	   initComponents();
	   setLocationRelativeTo(null);
	   setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        opwin = new javax.swing.JRadioButton();
        oplin = new javax.swing.JRadioButton();
        opmac = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        programacion = new javax.swing.JCheckBox();
        diseño = new javax.swing.JCheckBox();
        admin = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        slider = new javax.swing.JSlider();
        generar = new javax.swing.JButton();
        num = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Selecciona un Sistema Operativo");

        grupo.add(opwin);
        opwin.setText("Windows");

        grupo.add(oplin);
        oplin.setText("Linux");

        grupo.add(opmac);
        opmac.setText("Mac");

        jLabel2.setText("Selecciona tu Especialidad");

        programacion.setText("Programación");

        diseño.setText("Diseño Gráfico");

        admin.setText("Administración");

        jLabel3.setText("Horas que dedicas al ordenador");

        slider.setMaximum(24);
        slider.setValue(0);
        slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderStateChanged(evt);
            }
        });

        generar.setText("Generar encuesta");
        generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarActionPerformed(evt);
            }
        });

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Mostrar resultados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(56, 56, 56))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(opwin)
                            .addComponent(opmac)
                            .addComponent(oplin)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(programacion)
                            .addComponent(diseño)
                            .addComponent(admin)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(generar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opwin)
                .addGap(18, 18, 18)
                .addComponent(oplin)
                .addGap(18, 18, 18)
                .addComponent(opmac)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(programacion)
                .addGap(18, 18, 18)
                .addComponent(diseño)
                .addGap(18, 18, 18)
                .addComponent(admin)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(generar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarActionPerformed
	   String sSistemOper = "";
	   String sProg = "N";
	   String sDis = "N";
	   String sAdm = "N";
	   String sHor = "";
	   String sResultado = " ";
	   if (programacion.isSelected()) {
		  sProg = "S";
	   }
	   if (this.diseño.isSelected()) {
		  sDis = "S";
	   }
	   if (this.admin.isSelected()) {
		  sAdm = "S";
	   }
	   if (this.opwin.isSelected()) {
		  sSistemOper = "Windows";
	   }
	   if (this.oplin.isSelected()) {
		  sSistemOper = "Linux";
	   }
	   if (this.opmac.isSelected()) {
		  sSistemOper = "Mac";
	   }
	   sHor = num.getText();
	   sResultado = sSistemOper + "," + sProg + "," + sDis + "," + sAdm + "," + sHor;
	   sResultado = String.format("%s,%s,%s,%s,%s", sSistemOper, sProg, sDis, sAdm, sHor);
	   guardarResultadoDB(sSistemOper, sProg, sDis, sAdm, Integer.parseInt(sHor));
    }//GEN-LAST:event_generarActionPerformed

    private void sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderStateChanged
	   num.setText(Integer.toString(slider.getValue()));
    }//GEN-LAST:event_sliderStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	   System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    //Este boton redirecciona a la tabla para mostrar los resultados de la miniencuesta
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
	   this.setVisible(false);
	   Práctica08 resul = new Práctica08();
	   resul.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
    private void guardarResultadoDB(String sSisOper, String sProgra, String sDiseno, String sAdmon, int horas) {
	   Statement stmt;
	   String sInsertStmt;

	   sInsertStmt = String.format("INSERT INTO respuestas (sisoper,prog,diseno,admon,horas) VALUES ('%s','%s','%s','%s',%d)", sSisOper, sProgra, sDiseno, sAdmon, horas);

	   System.out.println(sInsertStmt);

	   try {
		  if (conn == null) {
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/encuesta?"
				    + "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=encuesta&password=encuesta");
		  }
		  stmt = conn.createStatement();
		  stmt.execute(sInsertStmt);

	   } catch (SQLException ex) {
		  Logger.getLogger(Práctica07_Miniencuesta.class.getName()).log(Level.SEVERE, null, ex);
	   }
    }

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
		  java.util.logging.Logger.getLogger(Práctica07_Miniencuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	   } catch (InstantiationException ex) {
		  java.util.logging.Logger.getLogger(Práctica07_Miniencuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	   } catch (IllegalAccessException ex) {
		  java.util.logging.Logger.getLogger(Práctica07_Miniencuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	   } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		  java.util.logging.Logger.getLogger(Práctica07_Miniencuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	   }
	   //</editor-fold>

	   //Cargar la clase del driver  de la libreria del driver de MySQL
	   try {
		  Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
	   } catch (Exception ex) {
		  // handle the error
		  System.out.println(ex.getMessage());
	   }
	   /* Create and display the form */
	   java.awt.EventQueue.invokeLater(new Runnable() {
		  public void run() {
			 new Práctica07_Miniencuesta().setVisible(true);
		  }
	   });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox admin;
    private javax.swing.JCheckBox diseño;
    private javax.swing.JButton generar;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel num;
    private javax.swing.JRadioButton oplin;
    private javax.swing.JRadioButton opmac;
    private javax.swing.JRadioButton opwin;
    private javax.swing.JCheckBox programacion;
    private javax.swing.JSlider slider;
    // End of variables declaration//GEN-END:variables
}
