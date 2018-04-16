package Presentacion.Mantenimientos;

import Datos.Conectar;
import Negocio.clsProducto;
import Presentacion.Utilidades.Utilidades;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *@author Anthony Sánchez S.
 *@author José Cedeño
 *@author Mariana Bermudez
 *@author María Fernanda Niño
 */

public class mFamilia_Producto extends javax.swing.JFrame {
    //Declaracion de variables
    Conectar con;
    PreparedStatement ps;
    ResultSet rs;
    String str_Boton = "Aceptar", str_Nombre = null, str_Descripcion = null, str_Usuario = null, str_LoginTipo = null, str_LoginUsuario;
    Integer int_Codigo = 0, int_Res = 0, int_Modo = 1;
    Date date_FechaCrear = null , date_FechaModificar = null;
    //Instancias de las clases
    clsProducto cls_Product = new clsProducto();
    Utilidades tools = new Utilidades();
    
    //Constructor del formulario
    public mFamilia_Producto() {
        initComponents();
        cargar_datos();
        this.setLocationRelativeTo(null);
        tools.limpiar_Componentes(rootPane);
        this.txtDescripcion.setLineWrap(true);
        this.txtNombre.requestFocus();
    } 
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblLoginUsuario = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setText("Mantenimiento Familia");

        lblDescripcion.setText("Descripción:");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        Tabla = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false;
            }

        };
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabla.setFocusable(false);
        jScrollPane1.setViewportView(Tabla);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        btnAceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAceptarKeyPressed(evt);
            }
        });

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblLoginUsuario.setText("---");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });

        lblNombre.setText("Nombre:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane3.setViewportView(txtDescripcion);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(lblDescripcion))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(txtNombre))
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(btnAceptar)
                                .addGap(40, 40, 40)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(118, 118, 118))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(354, 354, 354)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLoginUsuario)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(325, 325, 325))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcion)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevo)
                        .addComponent(btnConsultar)
                        .addComponent(btnModificar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnAceptar)
                    .addComponent(lblLoginUsuario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // Crear un nuevo registro
        int opcion = JOptionPane.showConfirmDialog(null,"¿Desea agregar un nuevo registro?", "Nuevo", JOptionPane.YES_NO_OPTION);
        if(opcion == 0)
        {
            //Esta variable nos indica si vamos a ingresar o modificar un registro 
            int_Modo = 1;
            //Este método se invoca de la clase Utilidades
            tools.limpiar_Componentes(rootPane);

            //Este método se invoca de la clase Utilidades
            tools.habilitar_Boton(rootPane, str_Boton);
            //Este método se invoca de la clase Utilidades
            tools.habilitar_Componentes(rootPane);
            this.txtNombre.requestFocus();
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        //Inicia el metodo para abrir el menú principal
        mProducto m_Producto = new mProducto();
        m_Producto.setVisible(true);
        m_Producto.lblLoginUsuario.setText(this.lblLoginUsuario.getText());
        //Cierra el formulario
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // Valida los campos y envía mensajes
        try {
            if(this.txtNombre.getText().length() > 0)
            {
                if(this.txtDescripcion.getText().length() > 0)
                {
                    if(int_Modo == 1)
                    {
                        //Realiza la buscqueda para evitar ingresar datos duplicados a la Base de Datos
                        con = new Conectar();  
                        ps = con.getConnection().prepareStatement("SELECT prod_fam_name FROM product_family WHERE prod_fam_name = ?");
                        ps.setString(1, this.txtNombre.getText());
                        rs = ps.executeQuery();
                        con.Desconectar();
                        if(rs.next() == true)
                        {
                            JOptionPane.showMessageDialog(null, "La familia del producto fue registrado anteriormente", "Familia del producto registrada", JOptionPane.ERROR_MESSAGE);
                        }else
                        {    
                            //Invoca el método para realizar un registro
                            Agregar();
                            this.txtNombre.requestFocus();
                        }
                    }
                    else
                    {
                        if(int_Modo == 2)
                        {
                            //Invoca el método para modificar un registro
                            Modificar();
                            this.txtNombre.setEditable(true);
                            this.txtNombre.requestFocus();
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Debe digitar la descripción de la familia del producto", "Error en validación", JOptionPane.ERROR_MESSAGE);
                }   
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Debe digitar el el nombre de ka familia del producto", "Error en validación", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("" + e);
        }    
        //Invoca el método cargar datos
        cargar_datos();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        //Procedimiento para validar que debe seleccionar una fila
        int FilaSelect = Tabla.getSelectedRow();
        if(FilaSelect >= 0)
        {
            int_Codigo = (Integer) Tabla.getValueAt(FilaSelect, 0);
            //Invoca el método consultar
            Consultar(int_Codigo);
            //Este método se invoca de la clase Utilidades
            tools.inhabilitar_Boton(rootPane, str_Boton);
            //Este método se invoca de la clase Utilidades
            tools.inhabilitar_Componentes(rootPane);
        } else
        {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        //Procedimiento para validar que debe seleccionar una fila
        int opcion = JOptionPane.showConfirmDialog(null,"¿Desea modificar el registro?", "Modificar", JOptionPane.YES_NO_OPTION);
        if(opcion == 0)
        {
            int FilaSelect = Tabla.getSelectedRow();
            if(FilaSelect >= 0)
            {
                if(str_LoginTipo.equals("Administrador"))
                {
                    int_Codigo = (Integer) Tabla.getValueAt(FilaSelect, 0);
                    //Invoca el método consultar
                    Consultar(int_Codigo);
                    int_Modo = 2;
                    //Este método se invoca de la clase Utilidades
                    tools.habilitar_Boton(rootPane, str_Boton);
                    //Este método se invoca de la clase Utilidades
                    tools.habilitar_Componentes(rootPane);
                    this.txtDescripcion.requestFocus();
                    this.txtNombre.setEditable(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No tiene permiso para modificar", "Sin permiso", JOptionPane.ERROR_MESSAGE);
                }
                

            } else
            {   
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //Procedimiento para validar que debe seleccionar una fila
        int opcion = JOptionPane.showConfirmDialog(null,"¿Desea eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION);
        if(opcion == 0)
        {
            int FilaSelect = Tabla.getSelectedRow();
            if(FilaSelect >= 0)
            {
                if(str_LoginTipo.equals("Administrador"))
                {
                    int_Codigo = (Integer) Tabla.getValueAt(FilaSelect, 0);
                    Consultar(int_Codigo);
                    Eliminar();
                    cargar_datos();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No tiene permiso para eliminar", "Sin permiso", JOptionPane.ERROR_MESSAGE);
                }
                
            } else
            {   
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAceptarKeyPressed
        // Evento para presionar el boton Aceptar con la tecla Enter
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.btnAceptarActionPerformed(null);
        }

    }//GEN-LAST:event_btnAceptarKeyPressed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.txtDescripcion.requestFocus();
        }
    }//GEN-LAST:event_txtNombreKeyPressed
    
    //Método para cargar la lista de registros
    void cargar_datos()
    {
        try {
            con = new Conectar();
            ps = con.getConnection().prepareStatement("SELECT * FROM product_family");
            rs = ps.executeQuery();
            String[] columnas = {"ID", "Familia", "Usuario", "Creado", "Modificado"};
            String date_FechaCreate, date_FechaModify;
            SimpleDateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.setColumnIdentifiers(columnas);
            Tabla.setModel(modelo);
            while(rs.next())
            {
                int_Codigo = rs.getInt("prod_fam_id");
                str_Nombre = rs.getString("prod_fam_name");
                str_Usuario = rs.getString("user_name");
                date_FechaCreate = Formato.format(rs.getDate("prod_fam_create_date"));
                date_FechaModify = Formato.format(rs.getDate("prod_fam_modify_date"));
                modelo.addRow(new Object[]{int_Codigo, str_Nombre, str_Usuario, date_FechaCreate, date_FechaModify});
            }
            
        } catch (Exception e) {
        }
    }
    
    //Método para insertar un registro
    private void Agregar()
    {
        try {
                str_Nombre = this.txtNombre.getText();
                str_Descripcion = this.txtDescripcion.getText();
                str_Usuario = this.lblLoginUsuario.getText().substring(9);
                date_FechaCrear = new Date();
                date_FechaModificar = new Date();
                DateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
                int_Res = cls_Product.Insertar_Familia(str_Nombre, str_Descripcion ,str_Usuario, formato.format(date_FechaCrear), formato.format(date_FechaModificar));
                if(int_Res > 0)
                {
                    JOptionPane.showMessageDialog(null, "Familia de producto registrada con éxito");
                    tools.limpiar_Componentes(rootPane);
                } else {
                    JOptionPane.showMessageDialog(null, "Familia de producto NO registrada");
                }
            } 
        catch (Exception e) {
                JOptionPane.showConfirmDialog(null, "" + e);
            }
    }
    
    //Método para consultar proveedor
    private void Consultar(Integer int_Code)
    {
        try {
            rs = cls_Product.Buscar_Familia(int_Code);
            if(rs.next())
            {
                str_Nombre = rs.getString("prod_fam_name");
                str_Descripcion = rs.getString("prod_fam_desc");
                str_Usuario = rs.getString("user_name");
                date_FechaCrear = rs.getDate("prod_fam_create_date");
                date_FechaModificar = rs.getDate("prod_fam_create_date");
                
                this.txtNombre.setText(str_Nombre);
                this.txtDescripcion.setText(str_Descripcion);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
    
    //Método para eliminar un registro
    private void Eliminar()
    {
         try {
             int_Res = cls_Product.Borrar_Familia(int_Codigo);
             if(int_Res > 0)
             {
                JOptionPane.showMessageDialog(null, "Familia de producto eliminada con éxito");
                tools.limpiar_Componentes(rootPane);
             } else {
                JOptionPane.showMessageDialog(null, "Familia de producto NO eliminada");
             }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
    
    //Método para modificar un registro
    private void Modificar()
    {
         try {
                str_Nombre = this.txtNombre.getText();
                str_Descripcion = this.txtDescripcion.getText();
                str_Usuario = this.lblLoginUsuario.getText().substring(9);
                date_FechaModificar = new Date();
                DateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
                int_Res = cls_Product.Editar_Familia(str_Nombre, str_Descripcion ,str_Usuario, formato.format(date_FechaCrear), formato.format(date_FechaModificar), int_Codigo);
                if(int_Res > 0)
                {
                    JOptionPane.showMessageDialog(null, "Familia de producto modificada con éxito");
                    tools.limpiar_Componentes(rootPane);
                } else {
                    JOptionPane.showMessageDialog(null, "Familia de producto NO modificada");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDescripcion;
    public static javax.swing.JLabel lblLoginUsuario;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}