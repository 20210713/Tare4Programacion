//Jorge Miguel Paulino Luciano, 2021-0713
package com.mycompany.tarea4;

import java.sql.*;


public class Login extends javax.swing.JFrame {
    
    private static final String driver = "com.mysql.jc.jdbc.Driver";
    private static final String bbdd = "jdbc:mysql://localhost:3306/tarea4?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String user = "root";
    private static final String clave = "n.9NZ5w@c";
    
    public Login() {        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonACCEDER = new javax.swing.JToggleButton();
        botonREGISTRARSE = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        contraseña = new javax.swing.JPasswordField();
        usuario = new javax.swing.JTextField();
        mensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonACCEDER.setText("INICIAR SESION");
        botonACCEDER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonACCEDERActionPerformed(evt);
            }
        });

        botonREGISTRARSE.setText("REGISTRARSE");
        botonREGISTRARSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonREGISTRARSEActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuario:");

        jLabel2.setText("Contraseña:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonACCEDER)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addComponent(botonREGISTRARSE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(contraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                    .addComponent(usuario)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mensaje)))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonACCEDER)
                    .addComponent(botonREGISTRARSE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mensaje)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonREGISTRARSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonREGISTRARSEActionPerformed
        new Registra().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_botonREGISTRARSEActionPerformed

    private void botonACCEDERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonACCEDERActionPerformed
      String userName = usuario.getText();
      String password = contraseña.getText();
      
      if (password.trim().equals("") || userName.trim().equals("")) {
         mensaje.setText("Debe ingresar su usuario y contraseña, si no está registrado debe registrarse");
      }
      else{
      try{
        Class.forName(driver);
        Connection con = DriverManager.getConnection(bbdd,user,clave);
        
        Statement st = con.createStatement();
        
        String sql = "select Usuario, Contraseña from usuarios";
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){   
            String Usuario = rs.getString("Usuario");
            String Contraseña = rs.getString("Contraseña");
            
            if (((userName.trim().equals("admin") && password.trim().equals("admin"))) || ((userName.trim().equals(Usuario) && password.trim().equals(Contraseña)))) {
            mensaje.setText(" Hola, " + userName + ".");
            new Pantalla().setVisible(true);
            }
        }
        con.close();
      }catch (Exception e){
        System.out.println("Error " + e.getMessage());
    } 
      }
    }//GEN-LAST:event_botonACCEDERActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botonACCEDER;
    private javax.swing.JToggleButton botonREGISTRARSE;
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel mensaje;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
