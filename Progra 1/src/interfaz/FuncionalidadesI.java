/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import logica.Counter;
/**
 *
 * @author erick
 */
public class FuncionalidadesI extends javax.swing.JFrame {

    /**
     * Creates new form FuncionalidadesI
     */
    public FuncionalidadesI() {
        initComponents();
    }
    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        administrarCliente = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        recepcion = new javax.swing.JButton();
        retiro = new javax.swing.JButton();
        AdminEntregables = new javax.swing.JButton();
        listaClientes = new javax.swing.JButton();
        reporte = new javax.swing.JButton();
        cambiarRango = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Funcionalidades del Counter");

        administrarCliente.setBackground(new java.awt.Color(51, 51, 51));
        administrarCliente.setText("Administración de Clientes");
        administrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrarClienteActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setText("consultar tipo de Cambio");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        recepcion.setBackground(new java.awt.Color(51, 51, 51));
        recepcion.setText("Recepción de Artículos");
        recepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recepcionActionPerformed(evt);
            }
        });

        retiro.setBackground(new java.awt.Color(51, 51, 51));
        retiro.setText("Retiro de Artículos");
        retiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retiroActionPerformed(evt);
            }
        });

        AdminEntregables.setBackground(new java.awt.Color(51, 51, 51));
        AdminEntregables.setText("Administración de Entregables");
        AdminEntregables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminEntregablesActionPerformed(evt);
            }
        });

        listaClientes.setBackground(new java.awt.Color(51, 51, 51));
        listaClientes.setText("Listado de Clientes con paquetes pendientes");
        listaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaClientesActionPerformed(evt);
            }
        });

        reporte.setBackground(new java.awt.Color(51, 51, 51));
        reporte.setText("Reporte de Resumen Contable");
        reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteActionPerformed(evt);
            }
        });

        cambiarRango.setBackground(new java.awt.Color(51, 51, 51));
        cambiarRango.setText("Cambiar rango de Ascenso");
        cambiarRango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarRangoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(administrarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(recepcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(retiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AdminEntregables, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(listaClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cambiarRango, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(77, 77, 77)
                .addComponent(administrarCliente)
                .addGap(18, 18, 18)
                .addComponent(recepcion)
                .addGap(18, 18, 18)
                .addComponent(retiro)
                .addGap(18, 18, 18)
                .addComponent(AdminEntregables)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(listaClientes)
                .addGap(18, 18, 18)
                .addComponent(reporte)
                .addGap(18, 18, 18)
                .addComponent(cambiarRango)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void administrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrarClienteActionPerformed
        close();
        AdministrarCliente admin = new AdministrarCliente();
        admin.setVisible(true);
    }//GEN-LAST:event_administrarClienteActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        close();
        TipoDeCambio cambio = new TipoDeCambio();
        cambio.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void listaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaClientesActionPerformed
        close();
        listaClientesConPendientes lista = new listaClientesConPendientes();
        lista.setVisible(true);
    }//GEN-LAST:event_listaClientesActionPerformed

    private void recepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recepcionActionPerformed
        close();
        RecepcionArticulo recep = new RecepcionArticulo();
        recep.setVisible(true);
    }//GEN-LAST:event_recepcionActionPerformed

    private void retiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retiroActionPerformed
        close();
        retiroArticulo retirar = new retiroArticulo();
        retirar.setVisible(true);
    }//GEN-LAST:event_retiroActionPerformed

    private void AdminEntregablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminEntregablesActionPerformed
        close();
        administracionEntregable admin = new administracionEntregable();
        admin.setVisible(true);
    }//GEN-LAST:event_AdminEntregablesActionPerformed

    private void reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteActionPerformed
        close();
        reporteContable rep = new reporteContable();
        rep.setVisible(true);
    }//GEN-LAST:event_reporteActionPerformed

    private void cambiarRangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarRangoActionPerformed
        close();
        cambiarRango cam = new cambiarRango();
        cam.setVisible(true);
        
    }//GEN-LAST:event_cambiarRangoActionPerformed

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
            java.util.logging.Logger.getLogger(FuncionalidadesI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncionalidadesI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncionalidadesI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionalidadesI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new FuncionalidadesI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdminEntregables;
    private javax.swing.JButton administrarCliente;
    private javax.swing.JButton cambiarRango;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton listaClientes;
    private javax.swing.JButton recepcion;
    private javax.swing.JButton reporte;
    private javax.swing.JButton retiro;
    // End of variables declaration//GEN-END:variables
}
