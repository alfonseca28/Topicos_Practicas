/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prácticas;

import javax.swing.JOptionPane;

/**
 *
 * @author Aarón Alfonseca
 */
public class Práctica01 extends javax.swing.JFrame {

    /**
     * Creates new form Práctica01
     */
    public Práctica01() {
	  initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonAceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotonAceptar.setText("Aceptar");
        BotonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAceptarActionPerformed(evt);
            }
        });

        jLabel1.setText("Introduce un nombre...");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(BotonAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(159, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Salir)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotonAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(Salir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAceptarActionPerformed
	  String nombre = jTextField1.getText();
	  JOptionPane.showMessageDialog(null, "Hola " + nombre);
    }//GEN-LAST:event_BotonAceptarActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
	  System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

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
		java.util.logging.Logger.getLogger(Práctica01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	  } catch (InstantiationException ex) {
		java.util.logging.Logger.getLogger(Práctica01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	  } catch (IllegalAccessException ex) {
		java.util.logging.Logger.getLogger(Práctica01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		java.util.logging.Logger.getLogger(Práctica01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	  }
	  //</editor-fold>
	  //</editor-fold>

	  /* Create and display the form */
	  java.awt.EventQueue.invokeLater(new Runnable() {
		public void run() {
		    new Práctica01().setVisible(true);
		}
	  });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAceptar;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
