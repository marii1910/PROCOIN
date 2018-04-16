package Presentacion.Mantenimientos;

import Datos.Conectar;
import Negocio.clsCliente;
import Presentacion.Utilidades.Utilidades;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
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

public class mCliente extends javax.swing.JFrame {
    //Declaracion de variables
    Conectar con;
    PreparedStatement ps;
    ResultSet rs;
    String str_Boton = "Aceptar", str_Codigo = null, str_Cedula = null, str_Nombre = null, str_Pais = null, str_Ciudad = null,
            str_Calle = null, str_CodigoPostal = null, str_Telefono = null, str_Contacto = null, str_Correo = null,
            str_Cargo = null, str_SitioWeb = null, str_TipoMoneda = null, str_TipoPago = null, str_Estado = null, str_Usuario = null, str_LoginTipo = null;
    Integer int_Direccion = 0, int_Plazo = 0, int_Res = 0, int_Modo = 1;
    double dbl_Credito = 0.00;
    Date date_FechaCrear = null , date_FechaModificar = null;
    
    //Variable para hacer cambio de moneda
    String str_Moneda = null;
    //Instancias de las clases
    Utilidades tools = new Utilidades();
    clsCliente cls_Customer = new clsCliente();
    mSesion m_sesion = new mSesion();
    
    //Constructor del formulario
    public mCliente() {
        initComponents();
        cargar_datos();
        String [] str_cmbTipoMoneda = {"Colones","Dólares"};
        String [] str_cmbTipoPago = {"Contado","Crédito"};
        Integer [] int_cmbPlazoCredito = {0,15,30,45,60,90};
        this.setLocationRelativeTo(null);
        tools.limpiar_Componentes(rootPane);
        this.btngroupEstado.clearSelection();
        DefaultComboBoxModel cmbMoneda = new DefaultComboBoxModel(str_cmbTipoMoneda);
        this.cmbTipoMoneda.setModel(cmbMoneda);
        this.cmbTipoMoneda.setSelectedItem(null);
        DefaultComboBoxModel cmbPago = new DefaultComboBoxModel(str_cmbTipoPago);
        this.cmbTipoPago.setModel(cmbPago);
        this.cmbTipoPago.setSelectedItem(null);
        DefaultComboBoxModel cmbPlazo = new DefaultComboBoxModel(int_cmbPlazoCredito);
        this.cmbTipoPlazo.setModel(cmbPlazo);
        this.cmbTipoPlazo.setSelectedItem(null);
        this.txtCredito.setEditable(false);
        this.txtCodigo.requestFocus();
    } 
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngroupEstado = new javax.swing.ButtonGroup();
        lblTitulo = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblTipoMoneda = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtCedula = new javax.swing.JTextField();
        rdbtnActivo = new javax.swing.JRadioButton();
        rdbtnInactivo = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        cmbTipoMoneda = new javax.swing.JComboBox<>();
        lblEstado = new javax.swing.JLabel();
        lblPais = new javax.swing.JLabel();
        lblCiudad = new javax.swing.JLabel();
        lblCalle = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblContacto = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblSitioWeb = new javax.swing.JLabel();
        cmbTipoPago = new javax.swing.JComboBox<>();
        lblTipoPago = new javax.swing.JLabel();
        cmbTipoPlazo = new javax.swing.JComboBox<>();
        lblPlazo = new javax.swing.JLabel();
        lblCredito = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtPais = new javax.swing.JTextField();
        txtCalle = new javax.swing.JTextField();
        txtContacto = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCargo = new javax.swing.JTextField();
        txtSitioWeb = new javax.swing.JTextField();
        txtCredito = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        lblTelefono1 = new javax.swing.JLabel();
        txtCodigoPostal = new javax.swing.JTextField();
        lblDias = new javax.swing.JLabel();
        lblLoginUsuario = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblCedula1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setText("Mantenimiento Cliente");

        lblCedula.setText("Cédula:");

        lblNombre.setText("Nombre:");

        lblTipoMoneda.setText("Tipo de moneda:");
        lblTipoMoneda.setToolTipText("");

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

        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedulaKeyPressed(evt);
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
        rdbtnActivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rdbtnActivoKeyPressed(evt);
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
        rdbtnInactivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rdbtnInactivoKeyPressed(evt);
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

        cmbTipoMoneda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoMoneda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoMonedaActionPerformed(evt);
            }
        });
        cmbTipoMoneda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbTipoMonedaKeyPressed(evt);
            }
        });

        lblEstado.setText("Estado:");

        lblPais.setText("País:");

        lblCiudad.setText("Ciudad:");

        lblCalle.setText("Calle:");

        lblTelefono.setText("Teléfono:");

        lblContacto.setText("Contacto:");

        lblCargo.setText("Cargo:");

        lblCorreo.setText("Correo:");

        lblSitioWeb.setText("Sitio Web:");

        cmbTipoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoPagoActionPerformed(evt);
            }
        });
        cmbTipoPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbTipoPagoKeyPressed(evt);
            }
        });

        lblTipoPago.setText("Tipo de pago:");
        lblTipoPago.setToolTipText("");

        cmbTipoPlazo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoPlazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoPlazoActionPerformed(evt);
            }
        });
        cmbTipoPlazo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbTipoPlazoKeyPressed(evt);
            }
        });

        lblPlazo.setText("Plazo Crédito:");
        lblPlazo.setToolTipText("");

        lblCredito.setText("Limite de Crédito:");

        txtCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCiudadKeyPressed(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });

        txtPais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPaisKeyPressed(evt);
            }
        });

        txtCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCalleKeyPressed(evt);
            }
        });

        txtContacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContactoKeyPressed(evt);
            }
        });

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyPressed(evt);
            }
        });

        txtCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCargoKeyPressed(evt);
            }
        });

        txtSitioWeb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSitioWebKeyPressed(evt);
            }
        });

        txtCredito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCreditoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCreditoKeyTyped(evt);
            }
        });

        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCorreoKeyPressed(evt);
            }
        });

        lblTelefono1.setText("Código Postal:");

        txtCodigoPostal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoPostalKeyPressed(evt);
            }
        });

        lblDias.setText("días");
        lblDias.setToolTipText("");

        lblLoginUsuario.setText("---");

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });

        lblCedula1.setText("Código:");

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAceptar)
                        .addGap(40, 40, 40)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(315, 315, 315)
                        .addComponent(lblLoginUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblPais)
                                                    .addComponent(lblCiudad)
                                                    .addComponent(lblCalle))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtCalle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtCiudad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtPais, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(lblTelefono1)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblTipoMoneda)
                                                .addGap(18, 18, 18)
                                                .addComponent(cmbTipoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(lblEstado)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdbtnActivo)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdbtnInactivo))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblTipoPago)
                                                    .addComponent(lblPlazo))
                                                .addGap(31, 31, 31)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(cmbTipoPago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(cmbTipoPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblDias)))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(278, 278, 278)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lblTitulo)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblContacto)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(lblCargo)
                                                                    .addComponent(lblCorreo))
                                                                .addGap(29, 29, 29)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addComponent(txtCredito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(21, 21, 21))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblSitioWeb)
                                                    .addComponent(lblTelefono)
                                                    .addComponent(lblCedula1)
                                                    .addComponent(lblCedula)
                                                    .addComponent(lblNombre))
                                                .addGap(38, 38, 38)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtSitioWeb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtCedula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(42, 42, 42)
                                                .addComponent(lblCredito)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)))
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
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblContacto)
                                    .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCargo))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCorreo))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTipoMoneda)
                                    .addComponent(cmbTipoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCredito))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTipoPago)
                                    .addComponent(cmbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblDias)
                                            .addComponent(cmbTipoPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(lblPlazo)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblEstado)
                                    .addComponent(rdbtnActivo)
                                    .addComponent(rdbtnInactivo)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCedula1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCedula))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNombre))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTelefono))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSitioWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSitioWeb))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPais))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCiudad))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCalle))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTelefono1))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevo)
                            .addComponent(btnConsultar)
                            .addComponent(btnModificar)
                            .addComponent(btnEliminar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnAceptar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLoginUsuario)
                .addContainerGap())
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
        // Valida los campos y envía mensajes
        try {
            if(this.txtCodigo.getText().length() > 0)
            {
                if(this.txtCedula.getText().length() > 0)
                {
                   if(this.txtNombre.getText().length() > 0)
                    {
                       if(this.txtTelefono.getText().length() > 0)
                        {
                            if(this.txtCredito.getText().length() > 0)
                            {
                                if(this.txtPais.getText().length() > 0)
                                {
                                    if(this.txtCiudad.getText().length() > 0)
                                    {
                                        if(this.txtCalle.getText().length() > 0)
                                        {
                                            if(this.txtContacto.getText().length() > 0)
                                            {
                                                if(this.txtCargo.getText().length() > 0)
                                                {
                                                    if(this.txtCorreo.getText().length() > 0)
                                                    {
                                                        if(this.cmbTipoMoneda.getSelectedIndex() > -1)
                                                        {
                                                            if(this.cmbTipoPago.getSelectedIndex() > -1)
                                                            {
                                                                if(this.cmbTipoPlazo.getSelectedIndex() > -1)
                                                                {
                                                                    if(this.btngroupEstado.getSelection() != null)
                                                                    {
                                                                        if(int_Modo == 1)
                                                                        {
                                                                            {
                                                                               //Invoca el método para realizar un registro
                                                                              Agregar();
                                                                              this.txtCodigo.requestFocus();
                                                                            }
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
                                                                        JOptionPane.showMessageDialog(null, "Debe seleccionar el estado del cliente", "Error en validación", JOptionPane.ERROR_MESSAGE);
                                                                    }
                                                                }
                                                                else
                                                                {
                                                                    JOptionPane.showMessageDialog(null, "Debe digitar el plazo del cliente", "Error en validación", JOptionPane.ERROR_MESSAGE);
                                                                }
                                                            }
                                                            else
                                                            {
                                                                JOptionPane.showMessageDialog(null, "Debe seleccionar el tipo de pago del cliente", "Error en validación", JOptionPane.ERROR_MESSAGE);
                                                            }
                                                        }
                                                        else
                                                        {
                                                            JOptionPane.showMessageDialog(null, "Debe seleccionar el tipo de moneda del cliente", "Error en validación", JOptionPane.ERROR_MESSAGE);
                                                        }
                                                    }
                                                    else
                                                    {
                                                        JOptionPane.showMessageDialog(null, "Debe digitar el correo del contacto del cliente", "Error en validación", JOptionPane.ERROR_MESSAGE);
                                                    }
                                                }
                                                else
                                                {
                                                    JOptionPane.showMessageDialog(null, "Debe digitar el cargo del contacto del cliente", "Error en validación", JOptionPane.ERROR_MESSAGE);
                                                }
                                            }
                                            else
                                            {
                                                JOptionPane.showMessageDialog(null, "Debe digitar el contacto del cliente", "Error en validación", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                        else
                                        {
                                            JOptionPane.showMessageDialog(null, "Debe digitar la calle del cliente", "Error en validación", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(null, "Debe digitar la ciudad del cliente", "Error en validación", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, "Debe digitar el país del cliente", "Error en validación", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Debe digitar el limite de crédito del cliente", "Error en validación", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Debe digitar el télefono del cliente", "Error en validación", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Debe digitar el nombre del cliente", "Error en validación", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Debe digitar la cédula del cliente", "Error en validación", JOptionPane.ERROR_MESSAGE);
                }   
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Debe digitar el código de cliente", "Error en validación", JOptionPane.ERROR_MESSAGE);
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
                    this.txtCedula.requestFocus();
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

    private void cmbTipoMonedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoMonedaActionPerformed
        // El valor selecionado se almacena en la variable
        str_TipoMoneda = (String) this.cmbTipoMoneda.getSelectedItem();
        this.txtCredito.setEditable(true);
        this.txtCredito.setText("");
        
    }//GEN-LAST:event_cmbTipoMonedaActionPerformed

    private void txtCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.txtNombre.requestFocus();
        }
    }//GEN-LAST:event_txtCedulaKeyPressed

    private void cmbTipoMonedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbTipoMonedaKeyPressed
        //Evento para pasar de un JComboBox a un RadioButton con la tecla Enter
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.txtCredito.requestFocus();
        }
    }//GEN-LAST:event_cmbTipoMonedaKeyPressed

    private void rdbtnActivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rdbtnActivoKeyPressed
        //Evento para pasar de un JRadioButton al botón Aceptar con la tecla Enter
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.btnAceptar.requestFocus();
        }
    }//GEN-LAST:event_rdbtnActivoKeyPressed

    private void rdbtnInactivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rdbtnInactivoKeyPressed
        //Evento para pasar de un JRadioButton al botón Aceptar con la tecla Enter
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.btnAceptar.requestFocus();
        }
    }//GEN-LAST:event_rdbtnInactivoKeyPressed

    private void btnAceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAceptarKeyPressed
        // Evento para presionar el boton Aceptar con la tecla Enter
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.btnAceptarActionPerformed(null);
        }

    }//GEN-LAST:event_btnAceptarKeyPressed

    private void cmbTipoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoPagoActionPerformed
        // El valor selecionado se almacena en la variable
        str_TipoPago = (String) this.cmbTipoPago.getSelectedItem();
        if(str_TipoPago != null)
        {
            if(str_TipoPago.equals("Contado"))
            {
                this.cmbTipoPlazo.setSelectedIndex(0);
                int_Plazo = (Integer) this.cmbTipoPlazo.getSelectedItem();
                this.cmbTipoPlazo.setEnabled(false);
            }else
            {
                this.cmbTipoPlazo.setEnabled(true);
                
            }
        }
    }//GEN-LAST:event_cmbTipoPagoActionPerformed

    private void cmbTipoPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbTipoPagoKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.cmbTipoPlazo.requestFocus();
        }
    }//GEN-LAST:event_cmbTipoPagoKeyPressed

    private void cmbTipoPlazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoPlazoActionPerformed
        // El valor selecionado se almacena en la variable
        int_Plazo = (Integer) this.cmbTipoPlazo.getSelectedItem();
    }//GEN-LAST:event_cmbTipoPlazoActionPerformed

    private void cmbTipoPlazoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbTipoPlazoKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.btnAceptar.requestFocus();
        }
    }//GEN-LAST:event_cmbTipoPlazoKeyPressed

    private void txtCiudadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiudadKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.txtCalle.requestFocus();
        }
    }//GEN-LAST:event_txtCiudadKeyPressed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.txtTelefono.requestFocus();
        }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtPaisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaisKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.txtCiudad.requestFocus();
        }
    }//GEN-LAST:event_txtPaisKeyPressed

    private void txtCalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCalleKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.txtCodigoPostal.requestFocus();
        }
    }//GEN-LAST:event_txtCalleKeyPressed

    private void txtContactoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactoKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.txtCargo.requestFocus();
        }
    }//GEN-LAST:event_txtContactoKeyPressed

    private void txtTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.txtSitioWeb.requestFocus();
        }
    }//GEN-LAST:event_txtTelefonoKeyPressed

    private void txtCargoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCargoKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.txtCorreo.requestFocus();
        }
    }//GEN-LAST:event_txtCargoKeyPressed

    private void txtSitioWebKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSitioWebKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.txtPais.requestFocus();
        }
    }//GEN-LAST:event_txtSitioWebKeyPressed

    private void txtCorreoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.cmbTipoMoneda.requestFocus();
        }
    }//GEN-LAST:event_txtCorreoKeyPressed

    private void txtCodigoPostalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoPostalKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.txtContacto.requestFocus();
        }
    }//GEN-LAST:event_txtCodigoPostalKeyPressed

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.txtCedula.requestFocus();
        }
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void txtCreditoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCreditoKeyTyped
        // Valida que solo se ingresen números
        char chr_validarNum = evt.getKeyChar();

        if(Character.isLetter(chr_validarNum))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solo números", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }//GEN-LAST:event_txtCreditoKeyTyped

    private void txtCreditoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCreditoKeyPressed
        // Evento para pasar de un Jtextfield a otro

        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.cmbTipoPago.requestFocus();
        }
        
        if(str_TipoMoneda != null)
        {
            if(str_TipoMoneda.equals("Dólares"))
            {
                if(this.txtCredito.getText().length() <= 1)
                {
                    this.txtCredito.setText("$");
                }
            }
            else
            {
                if(this.txtCredito.getText().length() <= 1)
                {
                    this.txtCredito.setText("C");
                }
            }
        }
        else
        {
            if(this.txtCredito.getText().length() <= 1)
            {
                    this.txtCredito.setText("C");
            }
        }     
    }//GEN-LAST:event_txtCreditoKeyPressed
    
    //Método para cargar la lista de registros
    void cargar_datos()
    {
        try {
            con = new Conectar();
            ps = con.getConnection().prepareStatement("select * from customer");
            rs = ps.executeQuery();
            String[] columnas = {"ID", "Proveedor", "Estado", "Usuario", "Creado", "Modificado"};
            String date_FechaCreate, date_FechaModify;
            SimpleDateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.setColumnIdentifiers(columnas);
            Tabla.setModel(modelo);
            while(rs.next())
            {
                str_Codigo = rs.getString("customer_id");
                str_Nombre = rs.getString("customer_name");
                str_Estado = rs.getString("customer_status");
                str_Usuario = rs.getString("user_name");
                date_FechaCreate = Formato.format(rs.getDate("customer_create_date"));
                date_FechaModify = Formato.format(rs.getDate("customer_modify_date"));
                modelo.addRow(new Object[]{str_Codigo, str_Nombre, str_Estado,str_Usuario, date_FechaCreate, date_FechaModify});
            }
            
        } catch (Exception e) {
        }
    }
    
    //Método para insertar un registro
    private void Agregar()
    {
        try {
                str_Codigo = this.txtCodigo.getText();
                str_Cedula = this.txtCedula.getText();
                str_Nombre = this.txtNombre.getText();
                str_Pais = this.txtPais.getText();
                str_Ciudad = this.txtCiudad.getText();
                str_Calle = this.txtCalle.getText();
                str_CodigoPostal = this.txtCodigoPostal.getText();
                str_Telefono = this.txtTelefono.getText();
                str_Contacto = this.txtContacto.getText();
                str_Correo = this.txtCorreo.getText();
                str_Cargo = this.txtCargo.getText();
                str_SitioWeb = this.txtSitioWeb.getText();
                dbl_Credito = Double.parseDouble(this.txtCredito.getText().substring(1));
                str_Usuario = this.lblLoginUsuario.getText().substring(9);
                date_FechaCrear = new Date();
                date_FechaModificar = new Date();
                DateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
                int_Res = cls_Customer.Insertar_Direccion(str_Pais ,str_Ciudad, str_Calle, str_CodigoPostal);
                if(int_Res > 0)
                {
                    System.out.println("Dirección registrada con éxito");
                } else {
                    System.out.println("Dirección NO registrada");
                }
                rs = cls_Customer.Obtener_id_Direccion();
                while(rs.next())
                {
                    int_Direccion = rs.getInt("address_id");
                }
                int_Res = cls_Customer.Insertar_Cliente(str_Codigo, int_Direccion,str_Cedula, str_Nombre, str_Telefono, str_Contacto, 
                        str_Cargo, str_Correo, str_SitioWeb, str_TipoMoneda, str_TipoPago, (double) dbl_Credito, int_Plazo, str_Estado,
                        str_Usuario, formato.format(date_FechaCrear), formato.format(date_FechaModificar));
                if(int_Res > 0)
                {
                    JOptionPane.showMessageDialog(null, "Cliente registrado con éxito");
                    tools.limpiar_Componentes(rootPane);
                    this.btngroupEstado.clearSelection();
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente NO registrado");
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
            this.rdbtnActivo.setForeground(Color.black);
            this.rdbtnInactivo.setForeground(Color.black);
                                
            rs = cls_Customer.Buscar_Cliente(str_Code);
            if(rs.next())
            {
                str_Codigo = rs.getString("customer_id");
                str_Cedula = rs.getString("customer_cod");
                str_Nombre = rs.getString("customer_name");
                str_Telefono = rs.getString("customer_phone");
                str_Contacto = rs.getString("customer_contact");
                str_Correo = rs.getString("customer_email_contact");
                str_Cargo = rs.getString("customer_position_contact");
                str_SitioWeb = rs.getString("customer_web");
                str_TipoMoneda = rs.getString("customer_money_type");
                str_TipoPago = rs.getString("customer_payment_type");
                int_Plazo = rs.getInt("customer_credit_term");
                dbl_Credito = rs.getDouble("customer_limit_credit");
                str_Estado = rs.getString("customer_status");
                date_FechaCrear = rs.getDate("customer_create_date");
                date_FechaModificar = rs.getDate("customer_modify_date");
                
                this.txtCodigo.setText(str_Codigo);
                this.txtCedula.setText(str_Cedula);
                this.txtNombre.setText(str_Nombre);
                this.txtTelefono.setText(str_Telefono);
                this.txtContacto.setText(str_Contacto);
                this.txtCargo.setText(str_Cargo);
                this.txtCorreo.setText(str_Correo);
                this.txtSitioWeb.setText(str_SitioWeb);
                this.cmbTipoMoneda.setSelectedItem(str_TipoMoneda);
                this.cmbTipoPago.setSelectedItem(str_TipoPago);
                this.cmbTipoPlazo.setSelectedItem(int_Plazo);
                
                if(str_TipoMoneda.equals("Colones"))
                {
                    this.txtCredito.setText(NumberFormat.getCurrencyInstance().format(dbl_Credito));
                }
                else
                {
                    this.txtCredito.setText(NumberFormat.getCurrencyInstance(Locale.US).format(dbl_Credito));
                }
                
                if(str_Estado.equals("Activo"))
                {
                    this.rdbtnActivo.setSelected(true);
                }else
                {
                    this.rdbtnInactivo.setSelected(true);
                }
            }
            rs = cls_Customer.Obtener_id_Direccion();
                while(rs.next())
                {
                    int_Direccion = rs.getInt("address_id");
                }
            rs = cls_Customer.Buscar_Direccion(int_Direccion);
            if(rs.next())
            {
                str_Pais = rs.getString("address_country");
                str_Ciudad = rs.getString("address_city");
                str_Calle = rs.getString("address_street");
                str_CodigoPostal = rs.getString("address_ZIP");
                
                this.txtPais.setText(str_Pais);
                this.txtCiudad.setText(str_Ciudad);
                this.txtCalle.setText(str_Calle);
                this.txtCodigoPostal.setText(str_CodigoPostal);
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
             int_Res = cls_Customer.Borrar_Cliente(str_Codigo);
             if(int_Res > 0)
             {
                JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito");
                tools.limpiar_Componentes(rootPane);
                this.btngroupEstado.clearSelection();
             } else {
                JOptionPane.showMessageDialog(null, "Cliente NO eliminado");
             }
             int_Res = cls_Customer.Borrar_Direccion(int_Direccion);
             if(int_Res > 0)
             {
                 System.out.println("Dirección eliminada con éxito");
             } else {
                 System.out.println("Dirección NO eliminada");
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
                str_Cedula = this.txtCedula.getText();
                str_Nombre = this.txtNombre.getText();
                str_Pais = this.txtPais.getText();
                str_Ciudad = this.txtCiudad.getText();
                str_Calle = this.txtCalle.getText();
                str_CodigoPostal = this.txtCodigoPostal.getText();
                str_Telefono = this.txtTelefono.getText();
                str_Contacto = this.txtContacto.getText();
                str_Correo = this.txtCorreo.getText();
                str_Cargo = this.txtCargo.getText();
                str_SitioWeb = this.txtSitioWeb.getText();
                dbl_Credito = Double.parseDouble(tools.validar_moneda(this.txtCredito.getText().substring(1)));
                str_Usuario = this.lblLoginUsuario.getText().substring(9);
                date_FechaModificar = new Date();
                DateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
                int_Res = cls_Customer.Editar_Direccion(str_Pais ,str_Ciudad, str_Calle, str_CodigoPostal, int_Direccion);
                if(int_Res > 0)
                {
                    System.out.println("Dirección modificada");
                } else {
                    System.out.println("Dirección NO modificada");
                }
                rs = cls_Customer.Obtener_id_Direccion();
                while(rs.next())
                {
                    int_Direccion = rs.getInt("address_id");
                }
                int_Res = cls_Customer.Editar_Cliente(int_Direccion, str_Cedula, str_Nombre, str_Telefono, str_Contacto, str_Cargo, 
                        str_Correo, str_SitioWeb, str_TipoMoneda, str_TipoPago, (double) dbl_Credito, int_Plazo, str_Estado, 
                        str_Usuario, formato.format(date_FechaCrear), formato.format(date_FechaModificar), str_Codigo);
                if(int_Res > 0)
                {
                    JOptionPane.showMessageDialog(null, "Cliente modificado con éxito");
                    tools.limpiar_Componentes(rootPane);
                    this.btngroupEstado.clearSelection();
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente NO modificado");
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
    private javax.swing.JComboBox<String> cmbTipoMoneda;
    private javax.swing.JComboBox<String> cmbTipoPago;
    private javax.swing.JComboBox<String> cmbTipoPlazo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCalle;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCedula1;
    private javax.swing.JLabel lblCiudad;
    private javax.swing.JLabel lblContacto;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblCredito;
    private javax.swing.JLabel lblDias;
    private javax.swing.JLabel lblEstado;
    public static javax.swing.JLabel lblLoginUsuario;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPais;
    private javax.swing.JLabel lblPlazo;
    private javax.swing.JLabel lblSitioWeb;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefono1;
    private javax.swing.JLabel lblTipoMoneda;
    private javax.swing.JLabel lblTipoPago;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JRadioButton rdbtnActivo;
    private javax.swing.JRadioButton rdbtnInactivo;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoPostal;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCredito;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtSitioWeb;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
