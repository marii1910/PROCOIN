package Presentacion.Mantenimientos;

import Datos.Conectar;
import Negocio.clsProducto;
import static Presentacion.Mantenimientos.mPrincipal.str_TipoUsuario;
import Presentacion.Utilidades.Utilidades;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *@author Anthony Sánchez S.
 *@author José Cedeño
 *@author Mariana Bermudez
 *@author María Fernanda Niño
 */

public class mProducto extends javax.swing.JFrame {
    //Declaracion de variables
    Conectar con;
    PreparedStatement ps;
    ResultSet rs;
    String str_Boton = "Aceptar", str_Codigo = null, str_Nombre = null, str_Descripcion = null, str_Familia = null, str_Marca = null, 
            str_UnidadMedida = null, str_Usuario = null, str_LoginTipo = null;
    Integer int_Familia = 0, int_Marca = 0, int_Res = 0, int_Modo = 1;
    Date date_FechaCrear = null , date_FechaModificar = null;
    ArrayList<String> arr_ListaFamilia = new ArrayList<String>();
    ArrayList<String> arr_ListaMarca = new ArrayList<String>();
    
    //Instancias de las clases
    Utilidades tools = new Utilidades();
    clsProducto cls_Product = new clsProducto();
    mSesion m_sesion = new mSesion();
    
    //Constructor del formulario
    public mProducto() {
        initComponents();
        cargar_datos();
        this.setLocationRelativeTo(null);
        this.setSize(800, 560);
        String [] str_cmbUnidadMedida = {"Gramos","Litros","Metros", "Unidades"};
        tools.limpiar_Componentes(rootPane);
        cmbFamilia.removeAllItems();
        cmbMarca.removeAllItems();
        arr_ListaFamilia = cls_Product.Llenar_familia();
        for(int i = 0; i < arr_ListaFamilia.size(); i++)
        {
            cmbFamilia.addItem(arr_ListaFamilia.get(i));
        }
        arr_ListaMarca = cls_Product.Llenar_marca();
        for(int i = 0; i < arr_ListaMarca.size(); i++)
        {
            cmbMarca.addItem(arr_ListaMarca.get(i));
        }
        DefaultComboBoxModel cmbPlazo = new DefaultComboBoxModel(str_cmbUnidadMedida);
        this.cmbUnidadMedida.setModel(cmbPlazo);
        this.cmbUnidadMedida.setSelectedItem(0);
        this.txtDescripcion.setLineWrap(true);
        this.btngroupEstado.clearSelection();
        this.txtCodigo.requestFocus();
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngroupEstado = new javax.swing.ButtonGroup();
        lblTitulo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblFamilia = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        cmbFamilia = new javax.swing.JComboBox<>();
        lblDescripcion = new javax.swing.JLabel();
        cmbMarca = new javax.swing.JComboBox<>();
        lblMarca = new javax.swing.JLabel();
        lblUnidadMedida = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblLoginUsuario = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblCedula1 = new javax.swing.JLabel();
        cmbUnidadMedida = new javax.swing.JComboBox<>();
        btnMarca = new javax.swing.JButton();
        btnFamilia = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(799, 470));

        lblTitulo.setText("Mantenimiento Artículo");

        lblNombre.setText("Nombre:");

        lblFamilia.setText("Familia:");
        lblFamilia.setToolTipText("");

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

        cmbFamilia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFamiliaActionPerformed(evt);
            }
        });
        cmbFamilia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbFamiliaKeyPressed(evt);
            }
        });

        lblDescripcion.setText("Descripción:");

        cmbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMarcaActionPerformed(evt);
            }
        });
        cmbMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbMarcaKeyPressed(evt);
            }
        });

        lblMarca.setText("Marca:");
        lblMarca.setToolTipText("");

        lblUnidadMedida.setText("Unidad de medida:");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });

        lblLoginUsuario.setText("---");

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });

        lblCedula1.setText("Código:");

        cmbUnidadMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbUnidadMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUnidadMedidaActionPerformed(evt);
            }
        });
        cmbUnidadMedida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbUnidadMedidaKeyPressed(evt);
            }
        });

        btnMarca.setText("Marca de producto");
        btnMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcaActionPerformed(evt);
            }
        });

        btnFamilia.setText("Familia de producto");
        btnFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFamiliaActionPerformed(evt);
            }
        });

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblDescripcion)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNombre)
                                        .addComponent(lblCedula1))
                                    .addGap(44, 44, 44)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                        .addComponent(txtNombre))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblFamilia)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblUnidadMedida)
                                        .addComponent(lblMarca))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbUnidadMedida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(383, 383, 383)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAceptar)
                                .addGap(33, 33, 33)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(192, 192, 192)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnFamilia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLoginUsuario)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(313, 313, 313))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCedula1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDescripcion)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFamilia)
                            .addComponent(cmbFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblMarca)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUnidadMedida))
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFamilia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMarca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLoginUsuario)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevo)
                            .addComponent(btnConsultar)
                            .addComponent(btnModificar)
                            .addComponent(btnEliminar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalir)
                            .addComponent(btnAceptar))
                        .addContainerGap(32, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
            this.btngroupEstado.clearSelection();
            //Este método se invoca de la clase Utilidades
            tools.habilitar_Boton(rootPane, str_Boton);
            //Este método se invoca de la clase Utilidades
            tools.habilitar_Componentes(rootPane);
            this.txtCodigo.requestFocus();
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        //Inicia el metodo para abrir el menú principal
        mPrincipal frm_principal = new mPrincipal();
        frm_principal.setVisible(true);
        frm_principal.lblLoginUsuario.setText(this.lblLoginUsuario.getText());
        //Cierra el formulario
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // Valida los campos y envía mensajes
        try {
            if(this.txtCodigo.getText().length() > 0)
            {
                if(this.txtNombre.getText().length() > 0)
                {
                    if(this.txtDescripcion.getText().length() > 0)
                    {
                        if(this.cmbFamilia.getSelectedIndex() > -1)
                        {
                            if(this.cmbMarca.getSelectedIndex() > -1)
                            {
                                if(this.cmbUnidadMedida.getSelectedIndex() > -1)
                                {
                                    if(int_Modo == 1)
                                    {
                                        //Invoca el método para realizar un registro
                                        Agregar();
                                        this.txtCodigo.requestFocus();
                                    }
                                    else
                                    {
                                        if(int_Modo == 2)
                                        {
                                            //Invoca el método para modificar un registro
                                            Modificar();
                                            this.txtCodigo.setEditable(true);
                                            this.txtCodigo.requestFocus();
                                        }
                                    }              
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, "Debe seleccionar la unidad de medida del producto", "Error en validación", JOptionPane.ERROR_MESSAGE);
                                }
                                }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Debe seleccionar la marca del producto", "Error en validación", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Debe seleccionar la familia del producto", "Error en validación", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Debe digitar la descripción del producto", "Error en validación", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Debe digitar el nombre del producto", "Error en validación", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Debe digitar el código del producto", "Error en validación", JOptionPane.ERROR_MESSAGE);
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
            str_Codigo = String.valueOf(Tabla.getValueAt(FilaSelect, 0));
            //Invoca el método consultar
            Consultar(str_Codigo);
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
                    str_Codigo = String.valueOf(Tabla.getValueAt(FilaSelect, 0));
                    //Invoca el método consultar
                    Consultar(str_Codigo);
                    int_Modo = 2;
                    //Este método se invoca de la clase Utilidades
                    tools.habilitar_Boton(rootPane, str_Boton);
                    //Este método se invoca de la clase Utilidades
                    tools.habilitar_Componentes(rootPane);
                    this.txtNombre.requestFocus();
                    this.txtCodigo.setEditable(false);
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
                    str_Codigo = String.valueOf(Tabla.getValueAt(FilaSelect, 0));
                    Consultar(str_Codigo);
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

    private void cmbFamiliaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbFamiliaKeyPressed
        //Evento para pasar de un JComboBox a un RadioButton con la tecla Enter
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.cmbUnidadMedida.requestFocus();
        }
    }//GEN-LAST:event_cmbFamiliaKeyPressed

    private void btnAceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAceptarKeyPressed
        // Evento para presionar el boton Aceptar con la tecla Enter
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.btnAceptarActionPerformed(null);
        }

    }//GEN-LAST:event_btnAceptarKeyPressed

    private void cmbMarcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbMarcaKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.cmbUnidadMedida.requestFocus();
        }
    }//GEN-LAST:event_cmbMarcaKeyPressed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.txtDescripcion.requestFocus();
        }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.txtNombre.requestFocus();
        }
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void cmbUnidadMedidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbUnidadMedidaKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.btnAceptar.requestFocus();
        }
    }//GEN-LAST:event_cmbUnidadMedidaKeyPressed

    private void btnMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcaActionPerformed
        //Pasar al mantenimiento de familia del producto
        mMarca_Producto m_Marca = new mMarca_Producto();
        m_Marca.setVisible(true);
        str_Usuario = this.lblLoginUsuario.getText().substring(9);
        m_Marca.lblLoginUsuario.setText("Usuario: " + str_Usuario);
        m_Marca.str_LoginTipo = str_TipoUsuario;
        dispose();
    }//GEN-LAST:event_btnMarcaActionPerformed

    private void btnFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFamiliaActionPerformed
        //Pasar al mantenimiento de familia del producto
        mFamilia_Producto m_Familia = new mFamilia_Producto();
        m_Familia.setVisible(true);
        str_Usuario = this.lblLoginUsuario.getText().substring(9);
        m_Familia.lblLoginUsuario.setText("Usuario: " + str_Usuario);
        m_Familia.str_LoginTipo = str_TipoUsuario;
        dispose();
    }//GEN-LAST:event_btnFamiliaActionPerformed

    private void cmbFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFamiliaActionPerformed
        // El valor selecionado se almacena en la variable
        str_Familia = (String) this.cmbFamilia.getSelectedItem();
        if (str_Familia != null)
        {
            int_Familia = cls_Product.Buscar_Nombre_Familia(str_Familia);
        }
    }//GEN-LAST:event_cmbFamiliaActionPerformed

    private void cmbMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMarcaActionPerformed
        // El valor selecionado se almacena en la variable
        str_Marca = (String) this.cmbMarca.getSelectedItem();
        if (str_Marca != null)
        {
            int_Marca = cls_Product.Buscar_Nombre_Marca(str_Marca);
        }
    }//GEN-LAST:event_cmbMarcaActionPerformed

    private void cmbUnidadMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUnidadMedidaActionPerformed
        // El valor selecionado se almacena en la variable
        str_UnidadMedida = (String) this.cmbUnidadMedida.getSelectedItem();
        if (str_UnidadMedida == null)
        {
            str_UnidadMedida = "Gramos";
        }
    }//GEN-LAST:event_cmbUnidadMedidaActionPerformed
    
    //Método para cargar la lista de registros
    void cargar_datos()
    {
        try {
            con = new Conectar();
            ps = con.getConnection().prepareStatement("SELECT * FROM product");
            rs = ps.executeQuery();
            String[] columnas = {"ID", "Producto", "Usuario", "Creado", "Modificado"};
            String date_FechaCreate, date_FechaModify;
            SimpleDateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.setColumnIdentifiers(columnas);
            Tabla.setModel(modelo);
            while(rs.next())
            {
                str_Codigo = rs.getString("product_id");
                str_Nombre = rs.getString("product_name");
                str_Usuario = rs.getString("user_name");
                date_FechaCreate = Formato.format(rs.getDate("product_create_date"));
                date_FechaModify = Formato.format(rs.getDate("product_modify_date"));
                modelo.addRow(new Object[]{str_Codigo, str_Nombre,str_Usuario, date_FechaCreate, date_FechaModify});
            }
            
        } catch (Exception e) {
        }
    }
    
    //Método para insertar un registro
    private void Agregar()
    {
        try {
                str_Codigo = this.txtCodigo.getText();
                str_Nombre = this.txtNombre.getText();
                str_Descripcion = this.txtDescripcion.getText();
                str_Usuario = this.lblLoginUsuario.getText().substring(9);
                date_FechaCrear = new Date();
                date_FechaModificar = new Date();
                DateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
                int_Res = cls_Product.Insertar_Producto(str_Codigo, str_Nombre, str_Descripcion, int_Familia, int_Marca, str_UnidadMedida,
                        str_Usuario, formato.format(date_FechaCrear), formato.format(date_FechaModificar));
                if(int_Res > 0)
                {
                    JOptionPane.showMessageDialog(null, "Producto registrado con éxito");
                    tools.limpiar_Componentes(rootPane);
                    this.btngroupEstado.clearSelection();
                } else {
                    JOptionPane.showMessageDialog(null, "Producto NO registrado");
                }
            } 
        catch (Exception e) {
                JOptionPane.showConfirmDialog(null, "" + e);
            }
    }
    
    //Método para consultar proveedor
    private void Consultar(String str_Code)
    {
        try {
                rs = cls_Product.Buscar_Producto(str_Code);
                if(rs.next())
                {
                    str_Codigo = rs.getString("product_id");
                    str_Nombre = rs.getString("product_name");
                    str_Descripcion = rs.getString("product_desc");
                    int_Familia = rs.getInt("prod_fam_id");
                    int_Marca = rs.getInt("prod_brand_id");
                    str_UnidadMedida = rs.getString("product_measurement_unit");
                    str_Usuario = rs.getString("user_name");
                    date_FechaCrear = rs.getDate("product_create_date");
                    date_FechaModificar = rs.getDate("product_modify_date");

                    this.txtCodigo.setText(str_Codigo);
                    this.txtNombre.setText(str_Nombre);
                    this.txtDescripcion.setText(str_Descripcion);
                    this.cmbUnidadMedida.setSelectedItem(str_UnidadMedida);
                }
            
                rs = cls_Product.Buscar_Familia(int_Familia);
                if(rs.next())
                {
                    str_Familia = rs.getString("prod_fam_name");
                    this.cmbFamilia.setSelectedItem(str_Familia);
                }
                
                rs = cls_Product.Buscar_Marca(int_Marca);
                if(rs.next())
                {
                    str_Marca = rs.getString("prod_brand_name");
                    this.cmbMarca.setSelectedItem(str_Marca);
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
    
    //Método para eliminar un registro
    private void Eliminar()
    {
         try {
             str_Codigo = this.txtCodigo.getText();
             int_Res = cls_Product.Borrar_Producto(str_Codigo);
             if(int_Res > 0)
             {
                JOptionPane.showMessageDialog(null, "Producto eliminado con éxito");
                tools.limpiar_Componentes(rootPane);
                this.btngroupEstado.clearSelection();
             } else {
                JOptionPane.showMessageDialog(null, "Producto NO eliminado");
             }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
    
    //Método para modificar un registro
    private void Modificar()
    {
         try {
                str_Codigo = this.txtCodigo.getText();
                str_Nombre = this.txtNombre.getText();
                str_Descripcion = this.txtDescripcion.getText();
                str_Usuario = this.lblLoginUsuario.getText().substring(9);
                date_FechaModificar = new Date();
                DateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
                int_Res = cls_Product.Editar_Producto(str_Nombre, str_Descripcion, int_Familia, int_Marca, str_UnidadMedida, 
                        str_Usuario, formato.format(date_FechaCrear), formato.format(date_FechaModificar), str_Codigo);
                if(int_Res > 0)
                {
                    JOptionPane.showMessageDialog(null, "Producto modificado con éxito");
                    tools.limpiar_Componentes(rootPane);
                    this.btngroupEstado.clearSelection();
                } else {
                    JOptionPane.showMessageDialog(null, "Producto NO modificado");
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
    private javax.swing.JButton btnFamilia;
    private javax.swing.JButton btnMarca;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup btngroupEstado;
    private javax.swing.JComboBox<String> cmbFamilia;
    private javax.swing.JComboBox<String> cmbMarca;
    private javax.swing.JComboBox<String> cmbUnidadMedida;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCedula1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblFamilia;
    public static javax.swing.JLabel lblLoginUsuario;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUnidadMedida;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}