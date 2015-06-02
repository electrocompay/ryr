/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasDePrecios;

import Articulos.Rubrable;
import Articulos.Rubros;
import Articulos.SubRubros;
import Conversores.Numeros;
import Sucursales.ListasDePrecios;
import facturacion.clientes.Clientes;
import interfaces.Personalizable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauro di
 */
public class ListasPorCliente extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo1=new DefaultTableModel();
    private DefaultTableModel modelo2=new DefaultTableModel();
    private DefaultTableModel modelo3=new DefaultTableModel();
    private ArrayList listadoSeleccion=new ArrayList();
    private ArrayList listadoRubros=new ArrayList();
    private ArrayList listadoSubRubros=new ArrayList();
    private ArrayList listadoGral=new ArrayList();
    private Clientes cliT=new Clientes();
    private ArticulosAsignados articulos;
    private ListasDePrecios listaDePrecios;
    private ArrayList listadoDePrecios=new ArrayList();
    
    
    /**
     * Creates new form ListasPorCliente
     */
    public ListasPorCliente(Object cliente) {
        cliT=(Clientes)cliente;
        initComponents();
        SubRubros rubro=new SubRubros();
        Rubrable rble=new SubRubros();
        listadoSubRubros=rble.listarPorRubro(0);
        
        modelo2=rble.mostrarListado(listadoSubRubros);
        Articulable artis=new ArticulosAsignados();
        listadoGral=artis.listarTodos(cliT);
        System.out.println("CANTIDAD: "+listadoGral.size());
        modelo1=artis.mostrarListado(listadoGral);
        this.jTable1.setModel(modelo1);
        this.jTable2.setModel(modelo2);
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();

        setClosable(true);
        setMaximizable(true);
        setTitle("Editor de Listas de Precios");

        jTable1.setModel(modelo1);
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(modelo2);
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable2KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel6.setText("Filtrar por Rubros - Seleccione o des seleccione los rubros a incluir ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 252, Short.MAX_VALUE))
        );

        jButton1.setText("Emitir Lista de Precio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Asignar lista de precio");

        listadoDePrecios=ListasDePrecios.Listado();
        Iterator iLp=listadoDePrecios.listIterator();
        while(iLp.hasNext()){
            listaDePrecios=(ListasDePrecios)iLp.next();
            jComboBox3.addItem(listaDePrecios.getDesccripcion());
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(47, 47, 47)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int cantidad=this.jTable1.getRowCount();
        ArticulosAsignados articulos;
        Boolean selec;
        for (int a=0;a < cantidad;a++){
            selec=(Boolean) this.jTable1.getValueAt(a, 0);
            if(selec){
            articulos=(ArticulosAsignados)listadoGral.get(a);
            listadoSeleccion.add(articulos);
            }
        }
        pdfsJavaGenerador pdf=new pdfsJavaGenerador();
        pdf.setCliente(cliT);
        pdf.setDoc(listadoSeleccion);
        pdf.run();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
        ArrayList lls=new ArrayList();
        int ctt=this.jTable2.getRowCount();
        SubRubros rubro;
        Boolean ss;
        for (int aa=0;aa < ctt;aa++){
            
            ss=(Boolean)this.jTable2.getValueAt(aa,0);
            if(ss){
                rubro=new SubRubros();
                rubro=(SubRubros)listadoSubRubros.get(aa);
                lls.add(rubro);
            }
        }
        Articulable att=new ArticulosAsignados();
        listadoGral=att.filtrador(lls, listadoRubros, cliT);
        modelo1=att.mostrarListado(listadoGral);
        this.jTable1.setModel(modelo1);
    }//GEN-LAST:event_jTable2KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        listaDePrecios=(ListasDePrecios)listadoDePrecios.get(this.jComboBox3.getSelectedIndex());
        Double coeficiente=0.00;
        String observaciones=JOptionPane.showInputDialog(this,"Ingrese comentario");
        
            coeficiente=listaDePrecios.getCoeficiente();
        
        Articulable att=new ArticulosAsignados();
        ArticulosAsignados articulo=new ArticulosAsignados();
        
        ArrayList resultado=new ArrayList();
        int renglones=this.jTable1.getRowCount();
        for(int a = 0;a < renglones;a++){
            if((Boolean) this.jTable1.getValueAt(a, 0)){
                articulo=(ArticulosAsignados)listadoGral.get(a);
            articulo.setCoeficiente(coeficiente);
            articulo.setIdLista(listaDePrecios.getId());
            articulo.setObservaciones(observaciones);
            resultado.add(articulo);
            }
        }
        att.guardar(resultado);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
