/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGraficas;

import Proveedores.AbmProveedores;
import Articulos.RubrosAbm;
import Actualizaciones.Actualiza;
import Actualizaciones.Actualiza1;
import Actualizaciones.BkDeConeccion;
import Articulos.AbmArticulos;
import Proveedores.Proveedores;
import Depositos.Depositos;
import Excel.InformeMensual;
import Sucursales.Cajas;
import Sucursales.ListasDePrecios;
import Sucursales.Sucursales;
import Sucursales.Usuarios;
import facturacion.clientes.Clientes;
import Cotizaciones.IngresoDeCotizacion;
import facturacion.pantallas.IngresoDeFacturas;
import Pedidos.IngresoDePedidos;
import Remitos.IngresoDeRemitos;
import interfacesPrograma.Cajeables;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import Articulos.Articulos;
import Articulos.SubRubrosAbm;
import FacturaE.AbmFacturaElectronica;
import Recibos.ChequesAbm;
import objetos.GastosF;

/**
 *
 * @author mauro
 */
public class Inicio extends javax.swing.JFrame {
    public static Integer niv;
    public static Usuarios usuario;
    public static Sucursales sucursal;
    public static Depositos deposito;
    public static Cajas caja;
    public static String fechaDia;
    public static Date fechaVal;
    public static Integer numeroCajaAdministradora=0;
    private BufferedImage img;
    public static Boolean coneccionRemota=true;
    public static Integer actualizable=0;
    public static int actualizacionesClientes=0;

    public void setNiv(Integer nive) {
        niv = nive;
        permisos(niv);
    }
    
    
    /**
     * Creates new form Inicio
     */
    public Inicio(Integer nivel) {
        //Articulos.CargarMap();
        //if(coneccionRemota){
        //Articulos.CargarMap();
        Inicio.coneccionRemota=false;
        if(Inicio.coneccionRemota){
            Proveedores.cargarListadoProv1();
        }else{
            Proveedores.cargarListadoProv();
        }
        Clientes.cargarMap();
        actualizacionesClientes=2;
        ListasDePrecios.cargarMap();
        //Cajas.BackapearCajas();
        Cajas.LeerCajaAdministradora();
        DecimalFormat fr=new DecimalFormat("00");
        Calendar c1=Calendar.getInstance();
	Calendar c2=new GregorianCalendar();
	String dia=Integer.toString(c2.get(Calendar.DAY_OF_MONTH));
	String mes=Integer.toString(c2.get(Calendar.MONTH));
	String ano=Integer.toString(c2.get(Calendar.YEAR));
	
        int da=Integer.parseInt(dia);
        int me=Integer.parseInt(mes);
        me++;
        dia=fr.format(da);
        mes=fr.format(me);
        fechaDia=ano+"-"+mes+"-"+dia;
	//System.err.println(fechaDia);
        //fecha="23/12/2011";
        String fh=ano+"-"+mes+"-"+dia;
        SimpleDateFormat ff=new SimpleDateFormat("yyyy-mm-dd");
        fechaVal = null;    
        try {
            fechaVal = ff.parse(fh);
        } catch (ParseException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //}else{
        
        Actualiza actu=new Actualiza();
        actu.start();
        Actualiza1 actu1=new Actualiza1();
        actu1.start();
        //}
        initComponents();
        Image icon=new ImageIcon(getClass().getResource("/imagen/icono.png")).getImage();
        this.setIconImage(icon);
        
 
        //permisos(nivel);
    }

    public Inicio() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        try {
            if(coneccionRemota){
                img = ImageIO.read(new URL("http://www.maurodi.net/imagenes/saynomore.jpg"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        jDesktopPane1 = new javax.swing.JDesktopPane(){
            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                grphcs.drawImage(img, 0, 0, null);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800,600);
            }

        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem25 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISITEMA DE GESTION BAMBU SOFTWARE");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jDesktopPane1.setAutoscrolls(true);
        jDesktopPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jDesktopPane1ComponentShown(evt);
            }
        });

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/developer_black.png"))); // NOI18N
        jMenu1.setText("Administracion");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setText("Listas de Precios");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuItem16.setText("Listado de Cheques");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem16);

        jMenuItem10.setText("Sucursales");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem14.setText("Cajas");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem14);

        jMenuItem21.setText("Informes");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem21);

        jMenuItem24.setText("Blanquear Base");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem24);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/download_folder_black.png"))); // NOI18N
        jMenu2.setText("Compras");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/tractorunitblack.png"))); // NOI18N
        jMenuItem6.setText("Ingreso de Mercaderia");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/stuff_black.png"))); // NOI18N
        jMenuItem12.setText("Articulos");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem12);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setText("Rubros");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Sub rubros");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/documents_black.png"))); // NOI18N
        jMenuItem13.setText("Consultas");
        jMenu2.add(jMenuItem13);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/currency_black_dollar.png"))); // NOI18N
        jMenu3.setText("Ventas");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/cash_register.png"))); // NOI18N
        jMenuItem5.setText("Abrir Caja");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/List.png"))); // NOI18N
        jMenuItem22.setText("Cotizaciones");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem22);

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Task.png"))); // NOI18N
        jMenuItem11.setText("Ingreso de Pedidos");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/delete_ticket.png"))); // NOI18N
        jMenuItem2.setText("Facturacion");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem17.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/stuff_black.png"))); // NOI18N
        jMenuItem17.setText("Generar Remito");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem17);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/comment_edit.png"))); // NOI18N
        jMenuItem3.setText("Arqueo de Caja");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/numbers_black.png"))); // NOI18N
        jMenuItem4.setText("Cierre de Caja");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/man_black.png"))); // NOI18N
        jMenu4.setText("Proveedores");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/groups_black.png"))); // NOI18N
        jMenu6.setText("Clientes");
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu6);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/developer_folder_black.png"))); // NOI18N
        jMenu5.setText("Parametros");

        jMenuItem15.setText("Tipos de Accesos");
        jMenuItem15.setEnabled(false);
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem15);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/users_folder_black - copia.png"))); // NOI18N
        jMenuItem7.setText("Usuarios");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuBar1.add(jMenu5);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/library_black.png"))); // NOI18N
        jMenu8.setText("Bases de Datos");

        jMenuItem23.setText("Ejecutar sincronizacion");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem23);

        jMenuBar1.add(jMenu8);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/torrents_black.png"))); // NOI18N
        jMenu9.setText("C.A.E. Pendientes");

        jMenuItem25.setText("Listar");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem25);

        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDesktopPane1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jDesktopPane1ComponentShown
        Loguin log=new Loguin();
        //this.jDesktopPane1.add(log);
        log.setVisible(true);
        //log.toFront();
        log.pack();
        
    }//GEN-LAST:event_jDesktopPane1ComponentShown

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        IngresoDeFacturas ingPed=new IngresoDeFacturas();
        jDesktopPane1.add(ingPed);
        ingPed.setVisible(true);
        ingPed.toFront();
        try {
            ingPed.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       this.jMenuItem2.setEnabled(true);
       Cajeables caj=new Cajas();
       if(caj.VerificarCaja(usuario.getNumero(),sucursal.getNumero(),fechaDia)){
           Inicio.caja=(Cajas)caj.CargarCaja(usuario.getNumero(),sucursal.getNumero(),fechaDia);
       }else{
       Inicio.caja=new Cajas(1);
       Double saldo=Double.parseDouble(JOptionPane.showInputDialog("Ingrese Saldo Inicial","0.00"));
       //System.out.println("SALDO INGRESADO "+saldo);
       Inicio.caja.setSaldoInicial(saldo);
       
       Inicio.caja=(Cajas) caj.AbrirCaja(caja);
       }
       Inicio.sucursal.setCaja(caja);
       this.jMenuItem5.setEnabled(false);
       //System.out.println("CAJA Nº "+caja.getNumero());
       
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        //Cajeables caj=new Cajas();
        //Cajas cajas=(Cajas)caj.ArquearCaja(caja);
        //System.out.println("SALDO DE CAJA "+cajas.getSaldoFinal());
        CajaAbm arq=new CajaAbm();
        jDesktopPane1.add(arq);
        arq.setVisible(true);
        arq.toFront();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        IngresoDeMercaderia ing=new IngresoDeMercaderia();
        jDesktopPane1.add(ing);
        ing.setVisible(true);
        ing.toFront();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
       
       jMenu1.setEnabled(Inicio.usuario.getMenu().getMenu1());
       jMenu2.setEnabled(Inicio.usuario.getMenu().getMenu2());
       jMenu3.setEnabled(Inicio.usuario.getMenu().getMenu3());
       jMenu4.setEnabled(Inicio.usuario.getMenu().getMenu4());
       jMenu5.setEnabled(Inicio.usuario.getMenu().getMenu5());
       jMenu6.setEnabled(Inicio.usuario.getMenu().getMenu6());
       //jMenu7.setEnabled(Inicio.usuario.getMenu().getMenu7());
              this.jMenuItem2.setEnabled(true);
       Cajeables caj=new Cajas();
       if(caj.VerificarCaja(usuario.getNumero(),sucursal.getNumero(),fechaDia)){
           this.caja=(Cajas)caj.CargarCaja(usuario.getNumero(),sucursal.getNumero(),fechaDia);
       }else{
       this.caja=new Cajas(1);
       Double saldo=Double.parseDouble(JOptionPane.showInputDialog("Ingrese Saldo Inicial","0.00"));
       //System.out.println("SALDO INGRESADO "+saldo);
       this.caja.setSaldoInicial(saldo);
       
       this.caja=(Cajas) caj.AbrirCaja(caja);
       }
       this.sucursal.setCaja(caja);
       this.jMenuItem5.setEnabled(false);

    }//GEN-LAST:event_formComponentShown

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        CajaAbm cajA=new CajaAbm();
        jDesktopPane1.add(cajA);
        cajA.setVisible(true);
        cajA.toFront();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        UsuariosAbm abmU=new UsuariosAbm();
        jDesktopPane1.add(abmU);
        abmU.setVisible(true);
        abmU.toFront();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        RubrosAbm rubross=new RubrosAbm();
        jDesktopPane1.add(rubross);
        rubross.setVisible(true);
        rubross.toFront();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        ListasDePreciosAbm ldpA=new ListasDePreciosAbm();
        jDesktopPane1.add(ldpA);
        ldpA.setVisible(true);
        ldpA.toFront();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        SucursalesAbm sucA=new SucursalesAbm();
        jDesktopPane1.add(sucA);
        sucA.setVisible(true);
        sucA.toFront();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        AbmArticulos artt=new AbmArticulos();
        jDesktopPane1.add(artt);
        try {
            artt.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        artt.setVisible(true);
        artt.toFront();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        ArqueoDeCaja cajaA=new ArqueoDeCaja();
        jDesktopPane1.add(cajaA);
        cajaA.setTitle("CIERRE DE CAJA");
        cajaA.setVisible(true);
        cajaA.toFront();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        IngresoDeRemitos nuevoRemito=new IngresoDeRemitos();
        jDesktopPane1.add(nuevoRemito);
        nuevoRemito.setVisible(true);
        nuevoRemito.toFront();
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        EmisorDeInformes emisor=new EmisorDeInformes();
        jDesktopPane1.add(emisor);
        emisor.setVisible(true);
        emisor.toFront();
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        TipoAccesoAbm tipo=new TipoAccesoAbm();
        jDesktopPane1.add(tipo);
        tipo.setVisible(true);
        tipo.toFront();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        Inicio.actualizable=1;
        Usuarios.BackapearUsuarios();
        Sucursales.BackapearSucursales();
            Articulos.RecargarMap(1);
        
        Proveedores.BackapearProveedores();
        Clientes.BackapearClientes();
        ListasDePrecios.BackapearListasDePrecios();
        Cajas.BackapearCajas();
        Cajas.LeerCajaAdministradora();
        Articulos.BackapearMap(1);
        Depositos.BackapearDepositos();
        
        
        
        Proveedores.cargarListadoProv();
        Clientes.cargarMap();
        ListasDePrecios.cargarMap();
        BkDeConeccion bk=new BkDeConeccion();
        bk.procesosDeCierre();
        Inicio.actualizable=0;
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        BkDeConeccion bkC=new BkDeConeccion();
        bkC.limpiarBasesLocal();
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
        
    }//GEN-LAST:event_jMenu6ActionPerformed

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
         AbmClientes clie=new AbmClientes();
        jDesktopPane1.add(clie);
        try {
            clie.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        clie.setVisible(true);
        clie.toFront();
    }//GEN-LAST:event_jMenu6MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        AbmProveedores abmP=new AbmProveedores();
        jDesktopPane1.add(abmP);
        abmP.setVisible(true);
        abmP.toFront();
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        IngresoDeCotizacion cotizacion=new IngresoDeCotizacion();
        jDesktopPane1.add(cotizacion);
        cotizacion.setVisible(true);
        cotizacion.toFront();
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        IngresoDePedidos pedido=new IngresoDePedidos();
        jDesktopPane1.add(pedido);
        pedido.setVisible(true);
        pedido.toFront();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       SubRubrosAbm sub=new SubRubrosAbm();
       Inicio.jDesktopPane1.add(sub);
       sub.setVisible(true);
       sub.toFront();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        ChequesAbm chequ=new ChequesAbm();
        Inicio.jDesktopPane1.add(chequ);
        chequ.setVisible(true);
        chequ.toFront();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        AbmFacturaElectronica fe=new AbmFacturaElectronica();
        Inicio.jDesktopPane1.add(fe);
        fe.setVisible(true);
        fe.toFront();
    }//GEN-LAST:event_jMenuItem25ActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }
    public void permisos(Integer nivel){
        jMenu1.setEnabled(Inicio.usuario.getMenu().getMenu1());
       jMenu2.setEnabled(Inicio.usuario.getMenu().getMenu2());
       jMenu3.setEnabled(Inicio.usuario.getMenu().getMenu3());
       jMenu4.setEnabled(Inicio.usuario.getMenu().getMenu4()); 
       jMenu5.setEnabled(Inicio.usuario.getMenu().getMenu5());
       this.jMenuItem2.setEnabled(true);
       Cajeables caj=new Cajas();
       if(caj.VerificarCaja(usuario.getNumero(),sucursal.getNumero(),fechaDia)){
           this.caja=(Cajas)caj.CargarCaja(usuario.getNumero(),sucursal.getNumero(),fechaDia);
       }else{
       this.caja=new Cajas(1);
       Double saldo=Double.parseDouble(JOptionPane.showInputDialog("Ingrese Saldo Inicial","0.00"));
       //System.out.println("SALDO INGRESADO "+saldo);
       this.caja.setSaldoInicial(saldo);
       
       this.caja=(Cajas) caj.AbrirCaja(caja);
       }
       this.sucursal.setCaja(caja);
       this.jMenuItem5.setEnabled(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane jDesktopPane1;
    public static javax.swing.JMenu jMenu1;
    public static javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    public static javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
