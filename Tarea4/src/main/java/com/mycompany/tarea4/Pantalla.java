//Jorge Miguel Paulino Luciano, 2021-0713
package com.mycompany.tarea4;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Pantalla extends javax.swing.JFrame {
    
    private static final String driver = "com.mysql.jc.jdbc.Driver";
    private static final String bbdd = "jdbc:mysql://localhost:3306/tarea4?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String user = "root";
    private static final String clave = "n.9NZ5w@c";
    
    
    public Pantalla() {
        initComponents();
        LLENAR();
    }
public void LLENAR(){
    
    try{
        Class.forName(driver);
        Connection con = DriverManager.getConnection(bbdd,user,clave);
        
        Statement st = con.createStatement();
        
        String sql = "select * from usuarios";
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            String Nombre = rs.getString("Nombre");
            String Apellido = rs.getString("Apellido");
            String Usuario = rs.getString("Usuario");
            String Telefono = rs.getString("Telefono");
            String Email = rs.getString("Email");
            
            String datos[] = {Nombre,Apellido,Usuario,Email,Telefono};
            
            DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
            modelo.addRow(datos);
        }
        
        con.close();
    }catch (Exception e){
        System.out.println(e.getMessage());
    }
    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        botonNUEVO = new javax.swing.JToggleButton();
        botonACTUALIZAR = new javax.swing.JToggleButton();
        botonELIMINAR = new javax.swing.JToggleButton();
        botonCERRAR = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        botonNUEVO.setText("NUEVO");

        botonACTUALIZAR.setText("ACTUALIZAR");

        botonELIMINAR.setText("ELIMINAR");

        botonCERRAR.setText("CERRAR SESION");
        botonCERRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCERRARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonNUEVO)
                        .addGap(18, 18, 18)
                        .addComponent(botonACTUALIZAR)
                        .addGap(18, 18, 18)
                        .addComponent(botonELIMINAR)
                        .addGap(18, 18, 18)
                        .addComponent(botonCERRAR))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonNUEVO)
                    .addComponent(botonACTUALIZAR)
                    .addComponent(botonELIMINAR)
                    .addComponent(botonCERRAR))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCERRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCERRARActionPerformed
        new Login().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_botonCERRARActionPerformed

 
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
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botonACTUALIZAR;
    private javax.swing.JToggleButton botonCERRAR;
    private javax.swing.JToggleButton botonELIMINAR;
    private javax.swing.JToggleButton botonNUEVO;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
