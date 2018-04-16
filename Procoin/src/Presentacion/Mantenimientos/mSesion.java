package Presentacion.Mantenimientos;

import Negocio.clsSesion;
import Presentacion.Utilidades.Utilidades;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *@author Anthony Sánchez S.
 *@author José Cedeño
 *@author Mariana Bermudez
 *@author María Fernanda Niño
 */

public class mSesion extends javax.swing.JFrame {

    //Declaración de variables
    private String str_Usuario = null, str_Password = null, str_Estado = null, str_TipoUsuario = null;
    ResultSet rs;
    clsSesion cls_sesion = new clsSesion();
    
    //Instancia de la clase utilidades
    Utilidades tools = new Utilidades();
    
    public mSesion() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setText("Inicio de Sesión");

        lblUsuario.setText("Usuario:");

        lblPassword.setText("Contraseña");

        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        btnIngresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnIngresarKeyPressed(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnIngresar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblPassword)
                        .addGap(18, 18, 18)
                        .addComponent(txtPassword))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblUsuario)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar)
                    .addComponent(btnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.txtPassword.requestFocus();
        }
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.btnIngresar.requestFocus();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        //Validar el ingreso al programa
        if(this.txtUsuario.getText().length() > 0)
        {
            if(this.txtPassword.getPassword().length > 0)
            {
                Ingresar();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Debe digitar una contraseña", "Error de validación", JOptionPane.ERROR_MESSAGE);                
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe digitar un usuario", "Error de validación", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // Salir del programa
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnIngresarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnIngresarKeyPressed
        // Acciona el botón ingresar
        this.btnIngresarActionPerformed(null);
    }//GEN-LAST:event_btnIngresarKeyPressed

    //Método para ingresar al programa
    public void Ingresar()
    {
        try {
            str_Usuario = this.txtUsuario.getText();
            str_Password = Arrays.toString(this.txtPassword.getPassword());
            str_Estado = "Activo";
            rs = cls_sesion.Login(str_Usuario);
            if(rs.next())
            {
                str_TipoUsuario = rs.getString("user_type");
                if(str_Password.equals(rs.getString("user_password")))
                {
                    if(str_Estado.equals(rs.getString("user_status")))
                    {
                        //Instancia la clase del menu principal
                        mPrincipal m_Principal = new mPrincipal();
                        m_Principal.setVisible(true);
                        m_Principal.lblLoginUsuario.setText("Usuario: " + str_Usuario);
                        m_Principal.str_Usuario = str_Usuario;
                        m_Principal.str_TipoUsuario = str_TipoUsuario;
                        dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "El usuario se encuentra inactivo", "Inactivo", JOptionPane.ERROR_MESSAGE);
                        tools.limpiar_Componentes(rootPane);
                        this.txtUsuario.requestFocus();
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña invalida", "Error", JOptionPane.ERROR_MESSAGE);
                    tools.limpiar_Componentes(rootPane);
                    this.txtUsuario.requestFocus();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña invalida", "Error", JOptionPane.ERROR_MESSAGE);
                tools.limpiar_Componentes(rootPane);
                this.txtUsuario.requestFocus();
            }
            
        } catch (Exception e) {
        }
        
    }
    
    
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
            java.util.logging.Logger.getLogger(mSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
