package Presentacion.Mantenimientos;

import Datos.Conectar;
import Presentacion.Utilidades.Utilidades;
import Negocio.clsUsuario;
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
 * @author Anthony Sánchez
 * @author José Cedeño
 * @author Mariana Bermúdez
 * @author María Fernanda Niño
 */

public final class mUsuario extends javax.swing.JFrame {
    //Declaracion de variables para conexión a la BD
    Conectar con;
    PreparedStatement ps;
    ResultSet rs;
    //Declaración de variables
    String str_Boton = "Aceptar", str_Usuario = null, str_Password = null, str_TipoUsuario = null, str_Estado = null, str_LoginTipo = null;
    Date date_FechaCrear = null , date_FechaModificar = null;
    Integer int_Res = 0, int_Modo = 1;
    boolean bol_Validar;
    
    //Instancia de clases
    Utilidades tools = new Utilidades();
    clsUsuario cls_User = new clsUsuario();
    
    //Constructor del formulario
    public mUsuario() {
        initComponents();
        cargar_datos();
        String [] str_Lista = {"Administrador","Estandar"};
        this.setLocationRelativeTo(null);
        tools.limpiar_Componentes(rootPane);
        this.btngroupEstado.clearSelection();
        DefaultComboBoxModel cmb = new DefaultComboBoxModel(str_Lista);
        this.cmbTipoUsuario.setModel(cmb);
        this.cmbTipoUsuario.setSelectedItem(null);
        this.txtUsuario.requestFocus();
    } 
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngroupEstado = new javax.swing.ButtonGroup();
        lblTitulo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblTipoUsuario = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        rdbtnActivo = new javax.swing.JRadioButton();
        rdbtnInactivo = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        cmbTipoUsuario = new javax.swing.JComboBox<>();
        lblEstado = new javax.swing.JLabel();
        lblLoginUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setText("Mantenimiento Usuario");

        lblUsuario.setText("Usuario:");

        lblPassword.setText("Contraseña:");

        lblTipoUsuario.setText("Tipo de usuario:");
        lblTipoUsuario.setToolTipText("");

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

        btngroupEstado.add(rdbtnActivo);
        rdbtnActivo.setText("Activo");
        rdbtnActivo.setFocusable(false);
        rdbtnActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnActivoActionPerformed(evt);
            }
        });

        btngroupEstado.add(rdbtnInactivo);
        rdbtnInactivo.setText("Inactivo");
        rdbtnInactivo.setFocusable(false);
        rdbtnInactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnInactivoActionPerformed(evt);
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

        cmbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoUsuarioActionPerformed(evt);
            }
        });
        cmbTipoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbTipoUsuarioKeyPressed(evt);
            }
        });

        lblEstado.setText("Estado:");

        lblLoginUsuario.setText("---");

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
                .addGap(358, 358, 358)
                .addComponent(btnAceptar)
                .addGap(40, 40, 40)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 338, Short.MAX_VALUE)
                .addComponent(lblLoginUsuario)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(402, 402, 402))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblPassword)
                                    .addGap(35, 35, 35))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblUsuario)
                                    .addGap(55, 55, 55)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPassword)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblTipoUsuario)
                                .addComponent(lblEstado))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rdbtnActivo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rdbtnInactivo))
                                .addComponent(cmbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsuario))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPassword)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipoUsuario)
                            .addComponent(cmbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEstado)
                            .addComponent(rdbtnActivo)
                            .addComponent(rdbtnInactivo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnConsultar)
                            .addComponent(btnNuevo)
                            .addComponent(btnModificar)
                            .addComponent(btnEliminar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnAceptar)
                    .addComponent(lblLoginUsuario))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // Crear un nuevo registro
        int opcion = JOptionPane.showConfirmDialog(null,"¿Desea agregar un nuevo registro?", "Modificar", JOptionPane.YES_NO_OPTION);
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
            this.txtUsuario.requestFocus();
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void rdbtnActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnActivoActionPerformed
        //Si el estado es seleccionado lo pone como activo
        str_Estado = "Activo";
        
    }//GEN-LAST:event_rdbtnActivoActionPerformed

    private void rdbtnInactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnInactivoActionPerformed
        //Si el estado es seleccionado lo pone como inactivo
        str_Estado = "Inactivo";
    }//GEN-LAST:event_rdbtnInactivoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        //Inicia el metodo para abrir el menú principal
        mPrincipal frm_principal = new mPrincipal();
        frm_principal.setVisible(true);
        frm_principal.lblLoginUsuario.setText(this.lblLoginUsuario.getText());
        //Cierra el formulario
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // Valida los comapos y envía mensajes
        try {
            if(this.txtUsuario.getText().length() > 0)
            {
                if(this.txtPassword.getPassword().length > 0)
                {
                    if(this.cmbTipoUsuario.getSelectedIndex() > -1)
                    {
                        if(this.btngroupEstado.getSelection() != null)
                        {
                            if(int_Modo == 1)
                            {
                                //Realiza la buscqueda para evitar ingresar datos duplicados a la Base de Datos
                                con = new Conectar();  
                                ps = con.getConnection().prepareStatement("SELECT user_name FROM user WHERE user_name = ?");
                                ps.setString(1, this.txtUsuario.getText());
                                rs = ps.executeQuery();
                                con.Desconectar();
                                if(rs.next() == true)
                                {
                                    JOptionPane.showMessageDialog(null, "El usuario fue registrado anteriormente", "Usuario registrado", JOptionPane.ERROR_MESSAGE);
                                }else
                                {
                                    //Invoca el método para realizar un registro
                                    Agregar();
                                    this.txtUsuario.requestFocus();
                                }
                            }
                            else
                            {
                                if(int_Modo == 2)
                                {
                                    //Invoca el método para modificar un registro
                                    Modificar();
                                    this.txtUsuario.setEditable(true);
                                    this.txtUsuario.requestFocus();
                                }
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Debe seleccionar el estado del usuario", "Error en validación", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Debe seleccionar el tipo de usuario", "Error en validación", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Debe digitar una contraseña", "Error en validación", JOptionPane.ERROR_MESSAGE);
                }   
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Debe digitar un usuario", "Error en validación", JOptionPane.ERROR_MESSAGE);
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
            str_Usuario = String.valueOf(Tabla.getValueAt(FilaSelect, 0));
            //Invoca el método consultar
            Consultar(str_Usuario);
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
                    str_Usuario = String.valueOf(Tabla.getValueAt(FilaSelect, 0));
                    //Invoca el método consultar
                    Consultar(str_Usuario);
                    int_Modo = 2;
                    //Este método se invoca de la clase Utilidades
                    tools.habilitar_Boton(rootPane, str_Boton);
                    //Este método se invoca de la clase Utilidades
                    tools.habilitar_Componentes(rootPane);
                    this.txtUsuario.setEditable(false);
                    this.txtPassword.setText("");
                    
                }else
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
                   str_Usuario = String.valueOf(Tabla.getValueAt(FilaSelect, 0));
                    Consultar(str_Usuario);
                    Eliminar();
                    cargar_datos(); 
                }else
                {
                    JOptionPane.showMessageDialog(null, "No tiene permiso para eliminar", "Sin permiso", JOptionPane.ERROR_MESSAGE);
                }
                
                
            } else
            {   
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cmbTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoUsuarioActionPerformed
        // El valor selecionado se almacena en la variable
        str_TipoUsuario = (String) this.cmbTipoUsuario.getSelectedItem();
        
    }//GEN-LAST:event_cmbTipoUsuarioActionPerformed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.txtPassword.requestFocus();
        }
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        // Evento para pasar de un Jtextfield a otro con la tecla Enter
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.cmbTipoUsuario.requestFocus();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void cmbTipoUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbTipoUsuarioKeyPressed
        //Evento para pasar de un JComboBox a un RadioButton con la tecla Enter
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.btnAceptar.requestFocus();
        }
    }//GEN-LAST:event_cmbTipoUsuarioKeyPressed

    private void btnAceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAceptarKeyPressed
        // Evento para presionar el boton Aceptar con la tecla Enter
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.btnAceptarActionPerformed(null);
        }

    }//GEN-LAST:event_btnAceptarKeyPressed
    
    //Método para cargar la lista de registros
    void cargar_datos()
    {
        try {
            con = new Conectar();
            ps = con.getConnection().prepareStatement("select * from user");
            rs = ps.executeQuery();
            String Usuario, TipoUsuario, Estado, Fecha_Crear, Fecha_Modificar;
            Date Fecha_Create, Fecha_Modify;
            SimpleDateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");
            String[] columnas = {"Usuario","Tipo Usuario", "Estado","Creado", "Modificado"};
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.setColumnIdentifiers(columnas);
            Tabla.setModel(modelo);
            while(rs.next())
            {
                Usuario = rs.getString("user_name");
                TipoUsuario = rs.getString("user_type");
                Estado = rs.getString("user_status");
                Fecha_Create = rs.getDate("user_create_date");
                Fecha_Crear = Formato.format(Fecha_Create);
                Fecha_Modify = rs.getDate("user_modify_date");
                Fecha_Modificar = Formato.format(Fecha_Modify);
                modelo.addRow(new Object[]{Usuario, TipoUsuario, Estado, Fecha_Crear, Fecha_Modificar});
            }
        } catch (Exception e) {
        }
    }
    
    //Método para insertar un registro
    private void Agregar()
    {
        try {
                str_Usuario = this.txtUsuario.getText();
                str_Password = Arrays.toString(this.txtPassword.getPassword());
                date_FechaCrear = new Date();
                date_FechaModificar = new Date();
                DateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
                int_Res = cls_User.Insertar(str_Usuario, str_Password, str_TipoUsuario, str_Estado, formato.format(this.date_FechaCrear), formato.format(this.date_FechaModificar));
                if(int_Res > 0)
                {
                    JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");
                    tools.limpiar_Componentes(rootPane);
                    this.btngroupEstado.clearSelection();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario NO registrado");
                }
            } 
        catch (Exception e) {
                JOptionPane.showConfirmDialog(null, "" + e);
            }
    }
    
    //Método para consultar un registro
    private void Consultar(String User)
    {
        try {
            rs = cls_User.Buscar(User);
            if(rs.next())
            {
                str_Usuario = rs.getString("user_name");
                str_Password = rs.getString("user_password");
                str_TipoUsuario = rs.getString("user_type");
                str_Estado = rs.getString("user_status");
                date_FechaCrear = rs.getDate("user_create_date");
                date_FechaModificar = rs.getDate("user_modify_date");
                
                this.txtUsuario.setText(str_Usuario);
                this.txtPassword.setText(str_Password);
                this.cmbTipoUsuario.setSelectedItem(str_TipoUsuario);
                
                if(str_Estado.equals("Activo"))
                {
                    this.rdbtnActivo.setSelected(true);
                }else
                {
                    this.rdbtnInactivo.setSelected(true);
                }
               
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
    
    //Método para eliminar un registro
    private void Eliminar()
    {
         try {
             str_Usuario = this.txtUsuario.getText();
             int_Res = cls_User.Borrar(str_Usuario);
             if(int_Res > 0)
             {
                JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito");
                tools.limpiar_Componentes(rootPane);
                this.btngroupEstado.clearSelection();
             } else {
                JOptionPane.showMessageDialog(null, "Usuario NO eliminado");
             }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
    
    //Método para modificar un registro
    private void Modificar()
    {
         try {
                str_Usuario = this.txtUsuario.getText();
                str_Password = Arrays.toString(this.txtPassword.getPassword());
                date_FechaModificar = new Date();
                DateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
                int_Res = cls_User.Editar(str_Password, str_TipoUsuario, str_Estado, formato.format(this.date_FechaCrear), formato.format(this.date_FechaModificar), str_Usuario);
                if(int_Res > 0)
                {
                    JOptionPane.showMessageDialog(null, "Usuario modificado con éxito");
                    tools.limpiar_Componentes(rootPane);
                    this.btngroupEstado.clearSelection();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario NO modificado");
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
    private javax.swing.ButtonGroup btngroupEstado;
    private javax.swing.JComboBox<String> cmbTipoUsuario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEstado;
    public static javax.swing.JLabel lblLoginUsuario;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JRadioButton rdbtnActivo;
    private javax.swing.JRadioButton rdbtnInactivo;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
