package Presentacion.Mantenimientos;

import Datos.Conectar;
import Negocio.clsTipoCambio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *@author Anthony Sánchez S.
 *@author José Cedeño
 *@author Mariana Bermudez
 *@author María Fernanda Niño
 */

public class mPrincipal extends javax.swing.JFrame {
    
    //Declaración de variables
    Conectar con;
    PreparedStatement ps;
    ResultSet rs;
    public static String str_Usuario, str_TipoUsuario, str_Fecha;
    double dbl_TipoCambio = 0.00;
    int int_Res = 0;
    Date date_Fecha = null;
    
    //Instancia de clases
    clsTipoCambio cls_Exchange_Rate = new clsTipoCambio();

    //Constructor de la clase
    public mPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("PROCOIN");
        Guardar_TipoCambio();
    }
   
    
    public double TipoCambio()
    {
        date_Fecha = new Date();
        SimpleDateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");
        return Double.parseDouble(cls_Exchange_Rate.TipoCambio(Formato.format(date_Fecha)));      
    }
    
    void Guardar_TipoCambio()
    {
        try {
            rs = cls_Exchange_Rate.Obtener_id_TipoCambio();
            while(rs.next())
            {
                str_Fecha = rs.getString("exchange_rate_date");
            }
            date_Fecha = new Date();
            DateFormat Formato = new SimpleDateFormat("YYYY-MM-dd");
            if(!str_Fecha.equals(Formato.format(date_Fecha)))
            {
                dbl_TipoCambio = TipoCambio();
                int_Res = cls_Exchange_Rate.Insertar_TipoCambio(dbl_TipoCambio, Formato.format(date_Fecha));
                if(int_Res > 0)
                {
                    System.out.println("Tipo de cambio registrado con éxito");
                } else {
                    System.out.println("Tipo de cambio NO registrado");
                }
            }
        } catch (Exception e) {
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLoginUsuario = new javax.swing.JLabel();
        menu_principal = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenuMantenimiento = new javax.swing.JMenu();
        jMenuItemProducto = new javax.swing.JMenuItem();
        jMenuItemCliente = new javax.swing.JMenuItem();
        jMenuItemProveedor = new javax.swing.JMenuItem();
        jMenuItemUsuario = new javax.swing.JMenuItem();
        jMenuInventario = new javax.swing.JMenu();
        jMenuItemEntrada = new javax.swing.JMenuItem();
        jMenuItemSalida = new javax.swing.JMenuItem();
        jMenuReporte = new javax.swing.JMenu();
        jMenuItemReporte = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLoginUsuario.setText("---");

        jMenuArchivo.setText("Archivo");

        jMenuItemSalir.setText("Salir");
        jMenuArchivo.add(jMenuItemSalir);

        menu_principal.add(jMenuArchivo);

        jMenuMantenimiento.setText("Mantenimiento");

        jMenuItemProducto.setText("Artículo");
        jMenuItemProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProductoActionPerformed(evt);
            }
        });
        jMenuMantenimiento.add(jMenuItemProducto);

        jMenuItemCliente.setText("Cliente");
        jMenuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClienteActionPerformed(evt);
            }
        });
        jMenuMantenimiento.add(jMenuItemCliente);

        jMenuItemProveedor.setText("Proveedor");
        jMenuItemProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProveedorActionPerformed(evt);
            }
        });
        jMenuMantenimiento.add(jMenuItemProveedor);

        jMenuItemUsuario.setText("Usuario");
        jMenuItemUsuario.setToolTipText("");
        jMenuItemUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuarioActionPerformed(evt);
            }
        });
        jMenuMantenimiento.add(jMenuItemUsuario);

        menu_principal.add(jMenuMantenimiento);

        jMenuInventario.setText("Movimientos de inventario");

        jMenuItemEntrada.setText("Entradas");
        jMenuItemEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEntradaActionPerformed(evt);
            }
        });
        jMenuInventario.add(jMenuItemEntrada);

        jMenuItemSalida.setText("Salidas");
        jMenuInventario.add(jMenuItemSalida);

        menu_principal.add(jMenuInventario);

        jMenuReporte.setText("Reportes");

        jMenuItemReporte.setText("Generar reporte de inventario");
        jMenuReporte.add(jMenuItemReporte);

        menu_principal.add(jMenuReporte);

        setJMenuBar(menu_principal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(378, Short.MAX_VALUE)
                .addComponent(lblLoginUsuario)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(254, Short.MAX_VALUE)
                .addComponent(lblLoginUsuario)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuarioActionPerformed
        //Convocar al formulario mUsuario
        mUsuario m_User = new mUsuario();
        m_User.setVisible(true);
        m_User.lblLoginUsuario.setText("Usuario: " + str_Usuario);
        m_User.str_LoginTipo = str_TipoUsuario;
        dispose();
    }//GEN-LAST:event_jMenuItemUsuarioActionPerformed

    private void jMenuItemProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProveedorActionPerformed
        //Invocar al formulario mProveedor
        mProveedor m_Supplier = new mProveedor();
        m_Supplier.setVisible(true);
        m_Supplier.lblLoginUsuario.setText("Usuario: " + str_Usuario);
        m_Supplier.str_LoginTipo = str_TipoUsuario;
        dispose();
    }//GEN-LAST:event_jMenuItemProveedorActionPerformed

    private void jMenuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClienteActionPerformed
        //Invocar al formulario mCliente
        mCliente m_Customer = new mCliente();
        m_Customer.setVisible(true);
        m_Customer.lblLoginUsuario.setText("Usuario: " + str_Usuario);
        m_Customer.str_LoginTipo = str_TipoUsuario;
        dispose();
    }//GEN-LAST:event_jMenuItemClienteActionPerformed

    private void jMenuItemProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProductoActionPerformed
        //Invocar al formulario mProducto
        mProducto m_Product = new mProducto();
        m_Product.setVisible(true);
        m_Product.lblLoginUsuario.setText("Usuario: " + str_Usuario);
        m_Product.str_LoginTipo = str_TipoUsuario;
        dispose();
    }//GEN-LAST:event_jMenuItemProductoActionPerformed

    private void jMenuItemEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEntradaActionPerformed
        //Invocar al formulario mProducto
        mEntrada m_Entrada = new mEntrada();
        m_Entrada.setVisible(true);
        //m_Producto.lblLoginUsuario.setText("Usuario: " + str_Usuario);
        //m_Producto.str_LoginTipo = str_TipoUsuario;
        //dispose();
    }//GEN-LAST:event_jMenuItemEntradaActionPerformed

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
            java.util.logging.Logger.getLogger(mPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenu jMenuInventario;
    private javax.swing.JMenuItem jMenuItemCliente;
    private javax.swing.JMenuItem jMenuItemEntrada;
    private javax.swing.JMenuItem jMenuItemProducto;
    private javax.swing.JMenuItem jMenuItemProveedor;
    private javax.swing.JMenuItem jMenuItemReporte;
    private javax.swing.JMenuItem jMenuItemSalida;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenuItem jMenuItemUsuario;
    private javax.swing.JMenu jMenuMantenimiento;
    private javax.swing.JMenu jMenuReporte;
    public static javax.swing.JLabel lblLoginUsuario;
    private javax.swing.JMenuBar menu_principal;
    // End of variables declaration//GEN-END:variables
}
