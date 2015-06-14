/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGraficas;

import Conversores.Numeros;
import Cotizaciones.Cotizable;
import Cotizaciones.Cotizacion;
import Cotizaciones.DetalleCotizacion;
import Cotizaciones.IngresoDeCotizacion;
import Cotizaciones.ModificacionDeCotizacion;
import ListasDePrecios.ListasPorCliente;
import Pedidos.ImprimirPedido;
import Pedidos.ModificacionDePedidos;
import Pedidos.Pedable;
import Pedidos.Pedidos;
import Remitos.IngresoDeRemitos;
import facturacion.clientes.Clientes;
import facturacion.clientes.Facturable;
import facturacion.clientes.Facturas;
import facturacion.clientes.ListasDePrecios;
import facturacion.pantallas.ModificacionDeFacturas;
import interfaceGraficas.AbmClientes;
import interfaceGraficas.Inicio;
import interfaces.Personalizable;
import interfacesPrograma.Busquedas;
import interfacesPrograma.Facturar;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import objetos.CondicionesIva;
import objetos.Localidades;

/**
 *
 * @author hernan
 */
public class NuevoCliente extends javax.swing.JInternalFrame {
    private JInternalFrame clientes;
    private int modificacion;
    private Clientes cliTa=new Clientes();
    private ArrayList listadoL=new ArrayList();
    private ArrayList listadoIva=new ArrayList();
    private ArrayList listadoLoc=new ArrayList();
    private Cotizacion cotizacionT=new Cotizacion();
    private ArrayList listadoCot=new ArrayList();
    private ArrayList listadoPed=new ArrayList();
    DefaultTableModel modelo=new DefaultTableModel();
    DefaultTableModel modelo1=new DefaultTableModel();
    DefaultTableModel modelo2=new DefaultTableModel();        
    private CondicionesIva condicion=new CondicionesIva();
    private ListasDePrecios listaPrecio=new ListasDePrecios();
    private Localidades localidad=new Localidades();
    private ArrayList listadoFac=new ArrayList();
    
    /**
     * Creates new form NuevoCliente
     */
    public NuevoCliente() {
        initComponents();
        this.jPanel2.setVisible(false);
    }
    public NuevoCliente(Object client) {
        initComponents();
        cliTa=(Clientes)client;
        this.jTextField1.setText(cliTa.getRazonSocial());
        //this.setTitle("MODIFICACION DATOS DEL CLIENTE - "+cliTa.getRazonSocial());
        this.jTextField2.setText(cliTa.getDireccion());
        Iterator iIva=listadoIva.listIterator();
        int tipoIvaC=cliTa.getTipoIva();
        int rengl=0;
        int posicion=0;
        while(iIva.hasNext()){
            condicion=(CondicionesIva)iIva.next();
            if(tipoIvaC==condicion.getId()){
                posicion=rengl;
            }
            rengl++;
        }
        this.jComboBox1.setSelectedIndex(posicion);
        
        this.jTextField3.setText(cliTa.getNumeroDeCuit());
        this.jTextField4.setText(cliTa.getTelefono());
        tipoIvaC=cliTa.getListaDePrecios();
        rengl=0;
        posicion=0;
        Iterator iLst=listadoL.listIterator();
        while(iLst.hasNext()){
            listaPrecio=(ListasDePrecios)iLst.next();
            if(tipoIvaC==listaPrecio.getNumeroLista()){
                posicion=rengl;
            }
            rengl++;
        }
        this.jComboBox2.setSelectedIndex(posicion);
        String loc=cliTa.getLocalidad();
        String loc2="";
        rengl=0;
        posicion=0;
        Iterator itLoc=listadoLoc.listIterator();
        while(itLoc.hasNext()){
            localidad=(Localidades)itLoc.next();
            loc2=localidad.getDescripcion();
            if(loc.equals(loc2)){
                posicion=rengl;
            }
            rengl++;
        }
        this.jComboBox3.setSelectedIndex(posicion);
        this.jTextField5.setText(String.valueOf(cliTa.getCupoDeCredito()));
        Double coef=0.00;
        coef=cliTa.getCoeficienteListaDeprecios() - 1;
        if(coef==0.00)coef=1.00;
        /*
        if(cliTa.getCoeficienteListaDeprecios() < 1){
            
            coef=coef * 100;
        }else{
            coef=0.00;
        }
        */
        this.jTextField6.setText(cliTa.getDireccionDeEntrega());
        this.jTextField7.setText(cliTa.getResponsable());
        this.jTextField8.setText(cliTa.getFantasia());
        this.jTextField9.setText(cliTa.getCelular());
        this.jTextField10.setText(cliTa.getDireccionFantasia());
        this.jTextField11.setText(cliTa.getFax());
        this.jTextField12.setText(cliTa.getEmail());
        
        modificacion=1;
        //this.setTitle("MODIFICACION DATOS DEL CLIENTE");
        Cotizable cotizable=new Cotizacion();
        Cotizacion cotizacion=new Cotizacion();
        listadoCot=cotizable.listarPorEstado(cliTa.getCodigoId(),0);
        modelo=cotizable.mostrarListado(listadoCot);
        if(Inicio.usuario.getNumeroId()==2){
            this.jButton5.setVisible(false);
            this.jButton8.setVisible(false);
        }
        this.jTable1.setModel(modelo);
        Pedable pedable=new Pedidos();
        Pedidos pedidos=new Pedidos();
        listadoPed=pedable.listarPorEstado(cliTa.getCodigoId(),0);
        modelo1=pedable.mostrarListado(listadoPed);
        this.jTable2.setModel(modelo1);
        Facturable ff=new Facturas();
        Facturas factura=new Facturas();
        listadoFac=ff.listarPorClienteNoRemitidas(cliTa.getCodigoId());
        modelo2=ff.mostrarListado(listadoFac);
        this.jTable3.setModel(modelo2);
        
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
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("FACTURACION - CARGA DE NUEVO CLIENTE");
        setAutoscrolls(true);

        jLabel1.setText("Razon Social");

        jLabel2.setText("Domicilio :");

        jLabel3.setText("Cond Iva:");

        CondicionesIva condicion=new CondicionesIva();
        Busquedas bus=new CondicionesIva();
        listadoIva=bus.listar("");
        Iterator iIva=listadoIva.listIterator();
        while(iIva.hasNext()){
            condicion=(CondicionesIva)iIva.next();
            jComboBox1.addItem(condicion.getDescripcion());
        }

        jLabel4.setText("N° de CUIT:");

        jLabel5.setText("Telefono :");

        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Lista de precios :");

        Personalizable per=new ListasDePrecios();
        ListasDePrecios listaP=new ListasDePrecios();
        listadoL=per.listar();
        Iterator ilL=listadoL.listIterator();
        while(ilL.hasNext()){
            listaP=(ListasDePrecios)ilL.next();
            jComboBox2.addItem(listaP.getDescripcionLista());
        }

        jLabel9.setText("Cupo de Credito :");

        jTextField5.setText("jTextField5");

        jLabel10.setText("Dirección de Entrega:");

        jTextField6.setText("jTextField6");

        jLabel11.setText("Responsable :");

        jTextField7.setText("jTextField7");

        jLabel12.setText("Nombre de Fantasía :");

        jTextField8.setText("jTextField8");

        jLabel13.setText("Celular :");

        jTextField9.setText("jTextField9");

        jLabel14.setText("Dirección Fantasía :");

        jTextField10.setText("jTextField10");

        jLabel15.setText("Fax :");

        jTextField11.setText("jTextField11");

        jLabel16.setText("email  :");

        jTextField12.setText("jTextField12");

        jLabel17.setText("Localidad :");

        Localidades localidad1=new Localidades();
        Busquedas busca=new Localidades();
        listadoLoc=busca.listar("");
        Iterator iLoc=listadoLoc.listIterator();
        while(iLoc.hasNext()){
            localidad1=(Localidades)iLoc.next();
            jComboBox3.addItem(localidad1.getDescripcion());
        }

        jButton11.setText("LISTAS DE PRECIOS");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("VER REMITOS");

        jButton13.setText("DETALLE DE SALDO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jComboBox1, 0, 297, Short.MAX_VALUE)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField5)
                            .addComponent(jTextField6)
                            .addComponent(jTextField7)
                            .addComponent(jTextField8)
                            .addComponent(jTextField9)
                            .addComponent(jTextField10)
                            .addComponent(jTextField11)
                            .addComponent(jTextField12)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(jButton13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(modelo);
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setText("Cotizaciones pendientes");

        jTable2.setModel(modelo1);
        jScrollPane2.setViewportView(jTable2);

        jLabel8.setText("Pedidos Pendientes");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/pdf.png"))); // NOI18N
        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Cart.png"))); // NOI18N
        jButton3.setText("Pedido");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Print.png"))); // NOI18N
        jButton4.setText("OTrabajo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Print.png"))); // NOI18N
        jButton5.setText("Detallado");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/List.png"))); // NOI18N
        jButton6.setText("Factura");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/comment_edit.png"))); // NOI18N
        jButton7.setText("Modificar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/tractorunitblack.png"))); // NOI18N
        jButton8.setText("Remitir");

        jLabel18.setText("Facturas ");

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/tractorunitblack.png"))); // NOI18N
        jButton9.setText("Remitir");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jTable3.setModel(modelo2);
        jScrollPane3.setViewportView(jTable3);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Currency- Dollar.png"))); // NOI18N
        jButton10.setText("Emitir Recibo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton3))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton10))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton8)))
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jButton9)
                    .addComponent(jButton10))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Clientes cli=new Clientes();
       //cli.setCodigoCliente(title);
       if(modificacion==1){
           cli=cliTa;
       }
       cli.setRazonSocial(this.jTextField1.getText());
       cli.setDireccion(this.jTextField2.getText());
       String condicion1=null;
       Integer tipo=0;
       condicion=(CondicionesIva)listadoIva.get(this.jComboBox1.getSelectedIndex());
       tipo=condicion.getId();
       
       if(this.jComboBox1.getSelectedIndex() < 4){
           cli.setEmpresa("sd");
       }else{
           cli.setEmpresa("bu");
       }
       ListasDePrecios lista=new ListasDePrecios();
       lista=(ListasDePrecios)listadoL.get(this.jComboBox2.getSelectedIndex());
       cli.setListaDePrecios(lista.getNumeroLista());
       cli.setTipoIva(tipo);
       cli.setCondicionIva(condicion1);
       cli.setNumeroDeCuit(this.jTextField3.getText());
       cli.setTelefono(this.jTextField4.getText());
       cli.setCupoDeCredito(Numeros.ConvertirStringADouble(this.jTextField5.getText()));
       cli.setDireccionDeEntrega(this.jTextField6.getText());
       //Double coef=Numeros.ConvertirStringADouble(this.jTextField6.getText()) / 100;
       //coef=coef + 1;
       //cli.setCoeficienteListaDeprecios(coef);
       cli.setResponsable(this.jTextField7.getText());
       cli.setFantasia(this.jTextField8.getText());
       cli.setCelular(this.jTextField9.getText());
       cli.setFax(this.jTextField11.getText());
       cli.setDireccionFantasia(this.jTextField10.getText());
       cli.setEmail(this.jTextField12.getText());
       localidad=(Localidades)listadoLoc.get(this.jComboBox3.getSelectedIndex());
       cli.setLocalidad(String.valueOf(localidad.getId()));
       
       Facturar fact=new Clientes();
       if(modificacion==1){
          
        fact.modificarDatosDelCliente(cli); 
       }else{
       
        fact.guardarNuevoCliente(cli);
       }
      try{  
       IngresoDeCotizacion.jCheckBox2.setSelected(true);
       IngresoDeCotizacion.jCheckBox2.setEnabled(false);
       IngresoDeCotizacion.cliT=cli;
       IngresoDeCotizacion.jLabel6.setText(cli.getRazonSocial());
      }catch (java.lang.NullPointerException exx){
           //JInternalFrame AbmClientes = null;
          //ControlaInstancia(AbmClientes);
      }
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Pedidos pedido=new Pedidos();
        pedido=(Pedidos)listadoPed.get(this.jTable2.getSelectedRow());
        ModificacionDePedidos modificar=new ModificacionDePedidos(pedido);
        Inicio.jDesktopPane1.add(modificar);
        try {
            modificar.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(NuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        modificar.setVisible(true);
        modificar.toFront();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Pedidos pedido=new Pedidos();
        pedido=(Pedidos)listadoPed.get(this.jTable2.getSelectedRow());
        ImprimirPedido imprimir=new ImprimirPedido();
        try {
            imprimir.ImprimirOrdenDetallada(pedido);
        } catch (IOException ex) {
            Logger.getLogger(NuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Pedidos pedido=new Pedidos();
        pedido=(Pedidos)listadoPed.get(this.jTable2.getSelectedRow());
        ImprimirPedido imprimir=new ImprimirPedido();
        try {
            imprimir.ImprimirOrdenDeTrabajo(pedido.getId());
        } catch (IOException ex) {
            Logger.getLogger(NuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Cotizacion cotizacion=new Cotizacion();
        cotizacion=(Cotizacion)listadoCot.get(this.jTable1.getSelectedRow());
        Cotizable coti=new Cotizacion();
        ArrayList detalleC=new ArrayList();
        Cotizable detC=new DetalleCotizacion();
        detalleC=detC.cargarDetalle(cotizacion.getId());
        coti.transformarEnPedido(cotizacion, detalleC);
        this.jTable2.removeAll();
        Pedable pedable=new Pedidos();
        listadoPed.clear();
        listadoPed=pedable.listarPorEstado(cliTa.getCodigoId(),0);
        modelo1=pedable.mostrarListado(listadoPed);
        this.jTable2.setModel(modelo1);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Cotizable cotizable=new Cotizacion();
        Cotizacion cotizacion=new Cotizacion();
        cotizacion=(Cotizacion)listadoCot.get(this.jTable1.getSelectedRow());
        ModificacionDeCotizacion modificar=new ModificacionDeCotizacion(cliTa,cotizacion);
        Inicio.jDesktopPane1.add(modificar);
        try {
            modificar.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(NuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        modificar.setVisible(true);
        modificar.toFront();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Pedidos pedido=new Pedidos();
        pedido=(Pedidos)listadoPed.get(this.jTable2.getSelectedRow());
        ModificacionDeFacturas factu=new ModificacionDeFacturas(pedido);
        Inicio.jDesktopPane1.add(factu);
        try {
            factu.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(NuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        factu.setVisible(true);
        factu.toFront();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        ListasPorCliente listas=new ListasPorCliente(cliTa);
        Inicio.jDesktopPane1.add(listas);
        try {
            listas.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(NuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        listas.setVisible(true);
        listas.toFront();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Integer numeroF=0;
        Facturas factura=new Facturas();
        factura=(Facturas)listadoFac.get(this.jTable3.getSelectedRow());
        IngresoDeRemitos remi=new IngresoDeRemitos(cliTa,factura);
        Inicio.jDesktopPane1.add(remi);
        try {
            remi.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(NuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        remi.setVisible(true);
        remi.toFront();
    }//GEN-LAST:event_jButton9ActionPerformed
    private void ControlaInstancia(JInternalFrame inter){
        /*
        boolean mostrar=true;
        //String nombre=inter.getTitle();
        for(int a =0;a < Inicio.jDesktopPane1.getComponentCount();a++){
            if(inter.getClass().isInstance(Inicio.jDesktopPane1.getComponent(a))){
                inter.toFront();
                Inicio.jDesktopPane1.moveToFront(inter);
            }
        }
        */
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
