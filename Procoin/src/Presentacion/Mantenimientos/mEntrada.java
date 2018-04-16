package Presentacion.Mantenimientos;

import Datos.Conectar;
import Negocio.clsDetalle;
import Negocio.clsEntrada;
import Negocio.clsTipoCambio;
import Presentacion.Consultas.mConsultar;
import static Presentacion.Mantenimientos.mPrincipal.str_Fecha;
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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *@author Anthony Sánchez S.
 *@author José Cedeño
 *@author Mariana Bermudez
 *@author María Fernanda Niño
 */

public class mEntrada extends javax.swing.JFrame {
    //Declaracion de variables
    Conectar con;
    PreparedStatement ps;
    ResultSet rs;
    String str_CedulaProveedor = null, str_Proveedor = null, str_Fecha = null, str_Documento = null, str_Comprobante =null,str_TipoMoneda = null, 
            str_BuscarProducto = null, str_CodigoProducto = null, str_Producto = null, str_UnidadMedida = null, str_TipoOperacion = null;
    Integer int_Consecutivo = 0, int_Cantidad = 0, int_fila = 0, int_Columna = 0;
    double dbl_TipoCambio = 0.00, dbl_Impuesto = 0.00, dbl_ValorUnitario = 0.00, dbl_ImpuestoUnitario = 0.00, dbl_PrecioUnitario = 0.00,
            dbl_ValorVenta = 0.00, dbl_ImpuestoVenta = 0.00, dbl_PrecioVenta = 0.00, dbl_Total = 0.00;
    Date date_Fecha = new Date();
    ArrayList <clsDetalle> arr_Detalle = new ArrayList<clsDetalle>();
    
    //Instancias de las clases
    Utilidades tools = new Utilidades();
    mConsultar m_Consulta = new mConsultar();
    clsTipoCambio cls_exchange_rate = new clsTipoCambio();
    clsEntrada cls_inventory = new clsEntrada();
    
    //Constructor del formulario
    public mEntrada() {
        initComponents();
        SimpleDateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");
        String [] str_cmbTipoMoneda = {"Colones","Dólares"};
        String [] str_cmbUnidadMedida = {"Gramos","Litros","Metros", "Unidades"};
        String [] str_cmbTipoOperacion = {"Compras","Devolución","Nota Crédito", "Nota Debito", "Ventas"};
        String[] columnas = {"Código", "Producto", "Cantidad", "Unidad Medida", "Valor venta", "Impuesto venta", "Precio Venta"};
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(columnas);
        TablaDetalle.setModel(modelo);
        this.setLocationRelativeTo(null);
        this.str_BuscarProducto = "%";
        this.dbl_Impuesto = 0.13;
        tools.limpiar_Componentes(rootPane);
        tools.inhabilitar_Componentes(this.txtConsecutivo);
        tools.inhabilitar_Componentes(this.txtCedula);
        tools.inhabilitar_Componentes(this.txtProveedor);
        tools.inhabilitar_Componentes(this.txtTipoCambio);
        tools.inhabilitar_Componentes(this.txtFecha);
        tools.inhabilitar_Componentes(this.txtCodigo);
        tools.inhabilitar_Componentes(this.txtProducto);
        tools.inhabilitar_Componentes(this.txtImpuesto);
        tools.inhabilitar_Componentes(this.txtImpuestoUnitario);
        tools.inhabilitar_Componentes(this.txtPrecioUnitario);
        tools.inhabilitar_Componentes(this.txtValorVenta);
        tools.inhabilitar_Componentes(this.txtImpuestoVenta);
        tools.inhabilitar_Componentes(this.txtPrecioVenta);
        tools.inhabilitar_Componentes(this.txtTotal);
        
        Cargar_Producto(str_BuscarProducto);
        Traer_Consecutivo();
        Traer_TipoCambio();
        DefaultComboBoxModel cmbTipoMoneda = new DefaultComboBoxModel(str_cmbTipoMoneda);
        DefaultComboBoxModel cmbUnidadMedida = new DefaultComboBoxModel(str_cmbUnidadMedida);
        DefaultComboBoxModel cmbTipoOperacion = new DefaultComboBoxModel(str_cmbTipoOperacion);
        this.cmbTipoMoneda.setModel(cmbTipoMoneda);
        this.cmbUnidadMedida.setModel(cmbUnidadMedida);
        this.cmbTipoOperacion.setModel(cmbTipoOperacion);
        this.cmbTipoMoneda.setSelectedItem(0);
        this.cmbUnidadMedida.setSelectedItem(0);
        this.cmbTipoOperacion.setSelectedItem(0);
        this.txtFecha.setText(Formato.format(date_Fecha));
        this.txtImpuesto.setText("13%");
        this.txtValorUnitario.setText("C");
        this.txtDocumento.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblLoginUsuario = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaDetalle = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        lblCancelar = new javax.swing.JButton();
        lblDocumento = new javax.swing.JLabel();
        lblConsecutivo = new javax.swing.JLabel();
        txtConsecutivo = new javax.swing.JTextField();
        txtDocumento = new javax.swing.JTextField();
        btnBuscarProveedor = new javax.swing.JButton();
        lblComporbante = new javax.swing.JLabel();
        txtComprobante = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblMoneda = new javax.swing.JLabel();
        cmbTipoMoneda = new javax.swing.JComboBox<>();
        txtProveedor = new javax.swing.JTextField();
        lblTipoCambio = new javax.swing.JLabel();
        txtTipoCambio = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        lblProveedor = new javax.swing.JLabel();
        lblBProducto = new javax.swing.JLabel();
        txtBuscarProducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtProducto = new javax.swing.JTextField();
        lblProducto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblImpuesto = new javax.swing.JLabel();
        txtImpuesto = new javax.swing.JTextField();
        txtPrecioUnitario = new javax.swing.JTextField();
        lblPrecioUnitario = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        lblPrecioVenta = new javax.swing.JLabel();
        txtImpuestoUnitario = new javax.swing.JTextField();
        txtImpuestoVenta = new javax.swing.JTextField();
        lblImpuestoVenta = new javax.swing.JLabel();
        lblImpuestoUnitario = new javax.swing.JLabel();
        txtValorUnitario = new javax.swing.JTextField();
        txtValorVenta = new javax.swing.JTextField();
        cmbTipoOperacion = new javax.swing.JComboBox<>();
        cmbUnidadMedida = new javax.swing.JComboBox<>();
        lblValorUnitario = new javax.swing.JLabel();
        lblValorVEnta = new javax.swing.JLabel();
        lblTipoOperación = new javax.swing.JLabel();
        lblUnidadMedida = new javax.swing.JLabel();
        btnIngresarDetalle = new javax.swing.JButton();
        btnEliminarDetalle = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setText("Entrada de inventario");

        lblLoginUsuario.setText("---");

        Tabla = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false;
            }

        };
        TablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaDetalle.setFocusable(false);
        jScrollPane2.setViewportView(TablaDetalle);

        btnGuardar.setText("Guardar");

        lblCancelar.setText("Cancelar");

        lblDocumento.setText("Tipo de documento:");

        lblConsecutivo.setText("Número:");

        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyPressed(evt);
            }
        });

        btnBuscarProveedor.setText("Buscar proveedor");
        btnBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedorActionPerformed(evt);
            }
        });

        lblComporbante.setText("Comprobante:");

        txtComprobante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtComprobanteKeyPressed(evt);
            }
        });

        lblCedula.setText("Cédula:");

        lblMoneda.setText("Moneda:");

        cmbTipoMoneda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoMoneda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoMonedaActionPerformed(evt);
            }
        });

        lblTipoCambio.setText("Tipo de cambio:");

        lblFecha.setText("Fecha:");

        lblProveedor.setText("Proveedor:");

        lblBProducto.setText("Buscar producto:");

        txtBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProductoKeyReleased(evt);
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
        Tabla.getTableHeader().setReorderingAllowed(false);
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);
        Tabla.getAccessibleContext().setAccessibleDescription("");

        jLabel2.setText("Código:");

        lblProducto.setText("Producto:");

        jLabel1.setText("Cantidad:");

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
        });

        lblImpuesto.setText("I.V.");

        lblPrecioUnitario.setText("Precio unitario:");

        lblPrecioVenta.setText("Precio venta:");

        lblImpuestoVenta.setText("I.V.Venta:");

        lblImpuestoUnitario.setText("I.V. Unitario:");

        txtValorUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValorUnitarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValorUnitarioKeyReleased(evt);
            }
        });

        cmbTipoOperacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoOperacionActionPerformed(evt);
            }
        });
        cmbTipoOperacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbTipoOperacionKeyPressed(evt);
            }
        });

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

        lblValorUnitario.setText("Valor Unitario:");

        lblValorVEnta.setText("Valor venta:");

        lblTipoOperación.setText("Tipo de operación:");

        lblUnidadMedida.setText("Unidad de medida:");

        btnIngresarDetalle.setText("Ingresar detalle");
        btnIngresarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarDetalleActionPerformed(evt);
            }
        });

        btnEliminarDetalle.setText("Eliminar detalle");
        btnEliminarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDetalleActionPerformed(evt);
            }
        });

        lblTotal.setText("Total:");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(557, 557, 557)
                        .addComponent(lblTitulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblDocumento)
                                .addGap(18, 18, 18)
                                .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblComporbante)
                                .addGap(18, 18, 18)
                                .addComponent(txtComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblMoneda)
                                .addGap(18, 18, 18)
                                .addComponent(cmbTipoMoneda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(624, 624, 624))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblConsecutivo)
                                .addGap(18, 18, 18)
                                .addComponent(txtConsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCedula)
                                .addGap(18, 18, 18)
                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblProveedor)
                                .addGap(18, 18, 18)
                                .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTipoCambio)
                                .addGap(18, 18, 18)
                                .addComponent(txtTipoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblFecha)
                                .addGap(18, 18, 18)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblBProducto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblUnidadMedida)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(cmbUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(lblValorUnitario)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtValorUnitario))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblTipoOperación)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(cmbTipoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(27, 27, 27)
                                                        .addComponent(lblValorVEnta)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtValorVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(96, 96, 96)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblImpuestoVenta)
                                                    .addComponent(lblImpuestoUnitario)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(lblProducto)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel1)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCantidad)
                                            .addComponent(txtImpuestoUnitario)
                                            .addComponent(txtImpuestoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(67, 67, 67)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblImpuesto)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblPrecioVenta)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblPrecioUnitario)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                                .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(302, 302, 302)
                                        .addComponent(btnIngresarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEliminarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(40, 40, 40))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblLoginUsuario)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(559, 559, 559)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(lblCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotal)
                .addGap(18, 18, 18)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCedula)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblProveedor))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTipoCambio)
                        .addComponent(txtTipoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblConsecutivo)
                        .addComponent(txtConsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFecha)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarProveedor)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMoneda)
                        .addComponent(cmbTipoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDocumento)
                        .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblComporbante)
                        .addComponent(txtComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBProducto)
                            .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(lblProducto)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblUnidadMedida)
                                    .addComponent(cmbUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblValorUnitario)
                                    .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblImpuestoUnitario)
                                    .addComponent(txtImpuestoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtValorVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtImpuestoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblImpuestoVenta)
                                    .addComponent(lblValorVEnta)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTipoOperación)
                                .addComponent(cmbTipoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIngresarDetalle)
                            .addComponent(btnEliminarDetalle)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblImpuesto)
                            .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecioUnitario)
                            .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecioVenta)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(lblCancelar)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLoginUsuario)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedorActionPerformed
        // Llamar al formulario consultar
        m_Consulta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBuscarProveedorActionPerformed

    private void txtBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoKeyReleased
        //Buscar el proveedor
        str_BuscarProducto = this.txtBuscarProducto.getText();
        Cargar_Producto(str_BuscarProducto);
    }//GEN-LAST:event_txtBuscarProductoKeyReleased

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        //Pasar valores a JTextfield
        int fila =  this.Tabla.getSelectedRow();
        if (fila >= 0)
        {
            this.txtCodigo.setText(Tabla.getValueAt(fila, 0).toString());
            this.txtProducto.setText(Tabla.getValueAt(fila, 1).toString());
        } 
    }//GEN-LAST:event_TablaMouseClicked

    private void txtValorUnitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorUnitarioKeyReleased
        // Realizar los calculos
        if(this.txtValorUnitario.getText().length() > 0)
        {
            if(this.txtCantidad.getText().length() > 0)
            {
                int_Cantidad = Integer.parseInt(this.txtCantidad.getText());
            }
            else
            {
                int_Cantidad = 0;
            }
            
            dbl_ValorUnitario = Double.parseDouble(this.txtValorUnitario.getText().substring(1));
            dbl_ImpuestoUnitario = (dbl_ValorUnitario * dbl_Impuesto);
            dbl_PrecioUnitario = (dbl_ValorUnitario + dbl_ImpuestoUnitario);
            dbl_ValorVenta = (dbl_ValorUnitario * int_Cantidad);
            dbl_ImpuestoVenta = (dbl_ValorVenta * dbl_Impuesto);
            dbl_PrecioVenta = (dbl_ValorVenta + dbl_ImpuestoVenta);
        }
        else
        {
            if(str_TipoMoneda.equals("Colones"))
            {
                this.txtValorUnitario.setText("C");
            }
            else
            {
                this.txtValorUnitario.setText("$");
            }
        }
        
        //Muestra los valores en los Jtextfield
        if(str_TipoMoneda.equals("Colones"))
        {
            this.txtImpuestoUnitario.setText(NumberFormat.getCurrencyInstance().format(dbl_ImpuestoUnitario));
            this.txtPrecioUnitario.setText(NumberFormat.getCurrencyInstance().format(dbl_PrecioUnitario));
            this.txtValorVenta.setText(NumberFormat.getCurrencyInstance().format(dbl_ValorVenta));
            this.txtImpuestoVenta.setText(NumberFormat.getCurrencyInstance().format(dbl_ImpuestoVenta));
            this.txtPrecioVenta.setText(NumberFormat.getCurrencyInstance().format(dbl_PrecioVenta));
        }
        else
        {
            this.txtImpuestoUnitario.setText(NumberFormat.getCurrencyInstance(Locale.US).format(dbl_ImpuestoUnitario));
            this.txtPrecioUnitario.setText(NumberFormat.getCurrencyInstance(Locale.US).format(dbl_PrecioUnitario));
            this.txtValorVenta.setText(NumberFormat.getCurrencyInstance(Locale.US).format(dbl_ValorVenta));
            this.txtImpuestoVenta.setText(NumberFormat.getCurrencyInstance(Locale.US).format(dbl_ImpuestoVenta));
            this.txtPrecioVenta.setText(NumberFormat.getCurrencyInstance(Locale.US).format(dbl_PrecioVenta));
            this.txtTotal.setText(NumberFormat.getCurrencyInstance(Locale.US).format(dbl_Total));
        }
    }//GEN-LAST:event_txtValorUnitarioKeyReleased

    private void cmbTipoMonedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoMonedaActionPerformed
        // Selecciona el tipo de moneda
        str_TipoMoneda = (String) this.cmbTipoMoneda.getSelectedItem();
        if(str_TipoMoneda != null)
        {
            str_TipoMoneda = (String) this.cmbTipoMoneda.getSelectedItem();
            if(str_TipoMoneda.equals("Colones"))
            {
                tools.limpiar_Componentes(this.txtImpuestoUnitario);
                tools.limpiar_Componentes(this.txtPrecioUnitario);
                tools.limpiar_Componentes(this.txtValorVenta);
                tools.limpiar_Componentes(this.txtImpuestoVenta);
                tools.limpiar_Componentes(this.txtPrecioVenta);
                this.txtValorUnitario.setText("C");
            }
            else
            {
                tools.limpiar_Componentes(this.txtImpuestoUnitario);
                tools.limpiar_Componentes(this.txtPrecioUnitario);
                tools.limpiar_Componentes(this.txtValorVenta);
                tools.limpiar_Componentes(this.txtImpuestoVenta);
                tools.limpiar_Componentes(this.txtPrecioVenta);
                this.txtValorUnitario.setText("$");
            }
        }
        else
        {
            str_TipoMoneda = "Colones";
        }
    }//GEN-LAST:event_cmbTipoMonedaActionPerformed

    private void cmbUnidadMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUnidadMedidaActionPerformed
        //Selecciona el tipo de unidad de medida
        str_UnidadMedida = (String) this.cmbUnidadMedida.getSelectedItem();
        if(str_UnidadMedida != null)
        {
            str_UnidadMedida = (String) this.cmbUnidadMedida.getSelectedItem();
        }
        else
        {
            str_UnidadMedida = "Gramos";
        }
    }//GEN-LAST:event_cmbUnidadMedidaActionPerformed

    private void cmbTipoOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoOperacionActionPerformed
        //Selecciona el tipo de operación
        str_TipoOperacion = (String) this.cmbTipoOperacion.getSelectedItem();
        if(str_TipoOperacion != null)
        {
            str_TipoOperacion = (String) this.cmbTipoOperacion.getSelectedItem();
        }
        else
        {
            str_TipoOperacion = "Compra";
        }
    }//GEN-LAST:event_cmbTipoOperacionActionPerformed

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
        // Invoca al evento Key Released de valor unitario
        txtValorUnitarioKeyReleased(evt);
    }//GEN-LAST:event_txtCantidadKeyReleased

    private void btnIngresarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarDetalleActionPerformed
        //Ingresar detalle
       
        clsDetalle cls_detail = new clsDetalle(this.txtCodigo.getText(), this.txtProducto.getText(), this.txtCantidad.getText(), 
                (String) this.cmbUnidadMedida.getSelectedItem(), this.txtValorVenta.getText(),this.txtImpuestoVenta.getText(),this.txtPrecioVenta.getText());
        arr_Detalle.add(cls_detail);
        Llenar_Tabla();
        dbl_Total = (dbl_Total + dbl_PrecioVenta);
        if(str_TipoMoneda.equals("Colones"))
        {
            this.txtTotal.setText(NumberFormat.getCurrencyInstance().format(dbl_Total));        
        }
        else
        {
            this.txtTotal.setText(NumberFormat.getCurrencyInstance(Locale.US).format(dbl_Total));
        }
    }//GEN-LAST:event_btnIngresarDetalleActionPerformed

    private void btnEliminarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDetalleActionPerformed
        //Eliminar registro de tabla detalle
        try {
            int int_FilaSelect = Tabla.getSelectedRow();
            if(int_FilaSelect >= 0)
            {
                int int_resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este producto?", "Eliminar", JOptionPane.YES_NO_OPTION);
                if(int_resp == JOptionPane.YES_OPTION)
                {
                    DefaultTableModel modelo = (DefaultTableModel) TablaDetalle.getModel();
                    modelo.removeRow(int_FilaSelect);
                    dbl_Total = (dbl_Total - dbl_PrecioVenta);
                    if(str_TipoMoneda.equals("Colones"))
                    {
                        this.txtTotal.setText(NumberFormat.getCurrencyInstance().format(dbl_Total));        
                    }
                    else
                    {
                        this.txtTotal.setText(NumberFormat.getCurrencyInstance(Locale.US).format(dbl_Total));
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un registro", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnEliminarDetalleActionPerformed

    private void txtDocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.txtComprobante.requestFocus();
        }
    }//GEN-LAST:event_txtDocumentoKeyPressed

    private void txtComprobanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComprobanteKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.txtCantidad.requestFocus();
        }
    }//GEN-LAST:event_txtComprobanteKeyPressed

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.cmbUnidadMedida.requestFocus();
        }
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void cmbUnidadMedidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbUnidadMedidaKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.cmbTipoOperacion.requestFocus();
        }
    }//GEN-LAST:event_cmbUnidadMedidaKeyPressed

    private void cmbTipoOperacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbTipoOperacionKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.txtValorUnitario.requestFocus();
        }
    }//GEN-LAST:event_cmbTipoOperacionKeyPressed

    private void txtValorUnitarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorUnitarioKeyPressed
        // Evento para pasar de un Jtextfield a otro
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.btnIngresarDetalle.requestFocus();
        }
    }//GEN-LAST:event_txtValorUnitarioKeyPressed
    
    public void Llenar_Tabla()
    {
        Object str_LlenarTabla [][] = new Object [arr_Detalle.size()] [7];
        for(int i = 0; i < arr_Detalle.size(); i++)
        {
            str_LlenarTabla [i][0] = arr_Detalle.get(i).getStr_Codigo();
            str_LlenarTabla [i][1] = arr_Detalle.get(i).getStr_Producto();
            str_LlenarTabla [i][2] = arr_Detalle.get(i).getStr_Cantidad();
            str_LlenarTabla [i][3] = arr_Detalle.get(i).getStr_UnidadMedida();
            str_LlenarTabla [i][4] = arr_Detalle.get(i).getStr_ValorVenta();
            str_LlenarTabla [i][5] = arr_Detalle.get(i).getStr_ImpuestoVenta();
            str_LlenarTabla [i][6] = arr_Detalle.get(i).getStr_PrecioVenta();
        }
        
        String[] columnas = {"Código", "Producto", "Cantidad", "Unidad Medida", "Valor venta", "Impuesto venta", "Precio Venta"};
        DefaultTableModel modelo = new DefaultTableModel(str_LlenarTabla,columnas);
        TablaDetalle.setModel(modelo);
    }
    
    void Traer_Consecutivo()
    {
        int_Consecutivo = cls_inventory.Traer_Llave();
        this.txtConsecutivo.setText( String.valueOf(int_Consecutivo));
    }
    
    void Traer_TipoCambio()
    {
        try {
            rs = cls_exchange_rate.Obtener_id_TipoCambio();
            while(rs.next())
            {
                dbl_TipoCambio = rs.getDouble("exchange_rate_value");
            }
            this.txtTipoCambio.setText(String.valueOf(dbl_TipoCambio));
        } catch (Exception e) {
        }
    }
    
    void Cargar_Producto(String str_BuscarProducto)
    {
        try {
            con = new Conectar();
            ps = con.getConnection().prepareStatement("SELECT * FROM product WHERE product_name LIKE '%" + str_BuscarProducto + "%'");
            rs = ps.executeQuery();
            String[] columnas = {"Código", "Producto"};
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.setColumnIdentifiers(columnas);
            Tabla.setModel(modelo);
            while(rs.next())
            {
                str_CodigoProducto = rs.getString("product_id");
                str_Producto = rs.getString("product_name");
                modelo.addRow(new Object[]{str_CodigoProducto, str_Producto});
            }    
        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JTable TablaDetalle;
    private javax.swing.JButton btnBuscarProveedor;
    private javax.swing.JButton btnEliminarDetalle;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIngresarDetalle;
    private javax.swing.JComboBox<String> cmbTipoMoneda;
    private javax.swing.JComboBox<String> cmbTipoOperacion;
    private javax.swing.JComboBox<String> cmbUnidadMedida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBProducto;
    private javax.swing.JButton lblCancelar;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblComporbante;
    private javax.swing.JLabel lblConsecutivo;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblImpuesto;
    private javax.swing.JLabel lblImpuestoUnitario;
    private javax.swing.JLabel lblImpuestoVenta;
    public static javax.swing.JLabel lblLoginUsuario;
    private javax.swing.JLabel lblMoneda;
    private javax.swing.JLabel lblPrecioUnitario;
    private javax.swing.JLabel lblPrecioVenta;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblTipoCambio;
    private javax.swing.JLabel lblTipoOperación;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblUnidadMedida;
    private javax.swing.JLabel lblValorUnitario;
    private javax.swing.JLabel lblValorVEnta;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtCantidad;
    public static javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtComprobante;
    private javax.swing.JTextField txtConsecutivo;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtImpuesto;
    private javax.swing.JTextField txtImpuestoUnitario;
    private javax.swing.JTextField txtImpuestoVenta;
    private javax.swing.JTextField txtPrecioUnitario;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtProducto;
    public static javax.swing.JTextField txtProveedor;
    private javax.swing.JTextField txtTipoCambio;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtValorUnitario;
    private javax.swing.JTextField txtValorVenta;
    // End of variables declaration//GEN-END:variables
}
