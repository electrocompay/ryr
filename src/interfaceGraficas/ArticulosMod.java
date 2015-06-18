/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGraficas;

import Compras.Proveedores;
import Conversores.Numeros;
import interfaces.Editables;
import interfaces.Personalizable;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTextField;
import Articulos.Articulos;
import Articulos.Rubrable;
import Articulos.Rubros;
import Articulos.SubRubros;
import tablas.MiModeloTablaArticulos;

/**
 *
 * @author mauro
 */
public class ArticulosMod extends javax.swing.JInternalFrame {
    private Articulos arti=new Articulos();
    private Integer accion=0;
    private Double ajuste=0.00;
    public static ArrayList combo;
    private ArrayList lstPorSuc=new ArrayList();
    private ArrayList lstProveedores=new ArrayList();
    private ArrayList lstRubros=new ArrayList();
    private ArrayList lstSubRubros=new ArrayList();

    public ArticulosMod(Articulos art) {
        arti=art;
        Editables edi=new Articulos();
        Articulos arr=new Articulos();
        lstPorSuc=edi.ListarPorSucursal(arti);
        Double totalActual=0.00;
        Iterator itL=lstPorSuc.listIterator();
        while(itL.hasNext()){
            arr=(Articulos)itL.next();
            totalActual=totalActual + arr.getCantidad();
        }
        arti.setStockActual(totalActual);
        Personalizable rub=new Rubros();
        lstRubros=rub.listar();
        Rubrable sR=new SubRubros();
        lstSubRubros=sR.listarPorRubro(arti.getRubroId());
        
        
        initComponents();
        
        
        combo=new ArrayList();
        Iterator itR=lstRubros.listIterator();
        Rubros rubro=new Rubros();
        int rengl=0;
        int posicion=0;
        Integer rubroI=0;
        Integer artI=arti.getRubroId();
        while(itR.hasNext()){
            rubro=(Rubros)itR.next();
            rubroI=rubro.getId();
            
            if(rubroI==artI){
               posicion=rengl; 
            }
            rengl++;
        }
        this.jComboBox1.setSelectedIndex(posicion);
        Iterator itSr=lstSubRubros.listIterator();
        SubRubros sub=new SubRubros();
        rengl=0;
        posicion=0;
        rubroI=0;
        artI=arti.getIdSubRubro();
        while(itSr.hasNext()){
            sub=(SubRubros)itSr.next();
            rubroI=sub.getId();
            System.out.println("subrubro: "+rubroI);
            if(rubroI==artI){
                posicion=rengl;
            }
            rengl++;
        }
        System.out.println("posicion "+posicion+"cantidad "+lstSubRubros.size()+" seleccionado "+artI);
        this.jComboBox3.setSelectedIndex(posicion);
        this.jTextField1.setText(arti.getDescripcionArticulo());
        
        //this.jTextField2.setText(String.valueOf(totalActual));
        this.jTextField3.setText(String.valueOf(arti.getStockMinimo()));
        this.jTextField4.setText(String.valueOf(arti.getPrecioDeCosto()));
        this.jTextField5.setText(String.valueOf(arti.getPrecioUnitarioNeto()));
        this.jTextField7.setText(String.valueOf(arti.getCodigoDeBarra()));
        //this.jTextField6.setText(String.valueOf(arti.getPrecioServicio()));
       // this.jTextField9.setText(String.valueOf(arti.getPrecioServicio1()));
        //this.jCheckBox1.setSelected(arti.getModificaPrecio());
        //this.jCheckBox2.setSelected(arti.getModificaServicio());
        
        
        if(arti.getIdCombo() > 0 )this.jCheckBox3.setSelected(true);
        //this.jPanel2.setVisible(false);
        this.jTextField7.selectAll();
        this.jTextField7.requestFocus();
        accion=2;
    }
    
    
    /**
     * Creates new form ArticulosMod
     */
    public ArticulosMod() {
        initComponents();
        combo=new ArrayList();
        this.setTitle("CARGA DE NUEVO ARTICULO");
        //this.jPanel2.setVisible(false);
        this.jTextField7.requestFocus();
        accion=1;
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
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jCheckBox3 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Modificacion de Articulos");
        setPreferredSize(new java.awt.Dimension(523, 585));

        jLabel1.setText("Descripcion");

        jLabel2.setText("Proveedor");

        jLabel3.setText("Stock Mínimo :");

        jTextField3.setText("0");

        jLabel4.setText("Precio de Costo:");

        jTextField4.setText("0");

        jLabel5.setText("Precio de Venta :");

        jTextField5.setText("0");

        jLabel6.setText("Rubro");

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Codigo de Barra");

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
        });

        jButton2.setText("INHABILITAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("Transformar en Combo");
        jCheckBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox3MouseClicked(evt);
            }
        });
        jCheckBox3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCheckBox3PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Personalizable perR=new Rubros();
        Rubros rubro=new Rubros();
        lstRubros=perR.listar();
        Iterator iR=lstRubros.listIterator();
        while(iR.hasNext()){
            rubro=(Rubros)iR.next();
            jComboBox1.addItem(rubro.getDescripcion());
        }
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        Personalizable per=new Proveedores();
        Proveedores proveedor=new Proveedores();
        lstProveedores=per.listar();
        Iterator iP=lstProveedores.listIterator();
        while(iP.hasNext()){
            proveedor=(Proveedores)iP.next();
            jComboBox2.addItem(proveedor.getNombre());
        }

        jLabel8.setText("Sub Rubro");

        Iterator iRs=lstSubRubros.listIterator();
        SubRubros sRubro=new SubRubros();
        while(iRs.hasNext()){
            sRubro=(SubRubros)iRs.next();
            jComboBox3.addItem(sRubro.getDescripcion());
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jTextField3)
                    .addComponent(jTextField4)
                    .addComponent(jTextField5)
                    .addComponent(jTextField7)
                    .addComponent(jComboBox1, 0, 211, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(408, 408, 408)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(650, 650, 650))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        arti.setCodigoDeBarra(this.jTextField7.getText());
        arti.setDescripcionArticulo(this.jTextField1.getText().toUpperCase());
        //Double cant=Numeros.ConvertirStringADouble(this.jTextField2.getText());
        
        Double cant=0.0000;
        arti.setStockActual(cant);
        cant=Numeros.ConvertirStringADouble(this.jTextField3.getText());
        arti.setStockMinimo(cant);
        cant=Numeros.ConvertirStringADouble(this.jTextField4.getText());
        arti.setPrecioDeCosto(cant);
        cant=Numeros.ConvertirStringADouble(this.jTextField5.getText());
        arti.setPrecioUnitarioNeto(cant);
        //cant=Numeros.ConvertirStringADouble(this.jTextField6.getText());
        arti.setPrecioServicio(cant);
        //cant=Numeros.ConvertirStringADouble(this.jTextField9.getText());
        arti.setPrecioServicio1(cant);
        //arti.setModificaPrecio(this.jCheckBox1.isSelected());
        //arti.setModificaServicio(this.jCheckBox2.isSelected());
        
        //Proveedores proveedor=new Proveedores();
        //proveedor=(Proveedores)lstProveedores.get(this.jComboBox2.getSelectedIndex());
        //
        arti.setProveedorId(1);
        Rubros rubro=new Rubros();
        rubro=(Rubros)lstRubros.get(this.jComboBox1.getSelectedIndex());
        arti.setRubroId(rubro.getId());
        if(lstSubRubros.size() > 0){
        SubRubros sub=new SubRubros();
        sub=(SubRubros)lstSubRubros.get(this.jComboBox3.getSelectedIndex());
        arti.setIdSubRubro(sub.getId());
        }else{
            arti.setIdSubRubro(0);
        }
        if(this.jCheckBox3.isSelected()){
            arti.setIdCombo(1);
        }else{
            arti.setIdCombo(0);
        }
        if(arti.getIdCombo() > 0)arti.setCombo(combo);
        Editables edit=new Articulos();
        if(accion==2){
            edit.ModificaionObjeto(arti);
        }else{
            edit.AltaObjeto(arti);
        }
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Editables editable=new Articulos();
        if(editable.EliminacionDeObjeto(arti))this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCheckBox3PropertyChange
       // TODO add your handling code here: 
    }//GEN-LAST:event_jCheckBox3PropertyChange

    private void jCheckBox3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox3MouseClicked
        
        if(this.jCheckBox3.isSelected()){
            System.out.println("entrooooooo");
            Combos combo=new Combos();
            combo.setVisible(true);
            arti.setIdCombo(1);
            
            
        }
        
    }//GEN-LAST:event_jCheckBox3MouseClicked

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyPressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        int seleccion=this.jComboBox1.getSelectedIndex();
        Rubros rub=new Rubros();
        rub=(Rubros)lstRubros.get(seleccion);
        Rubrable rubra=new SubRubros();
        lstSubRubros.clear();
        lstSubRubros=rubra.listarPorRubro(rub.getId());
        this.jComboBox3.removeAllItems();
        Iterator iSb=lstSubRubros.listIterator();
        SubRubros subR=new SubRubros();
        while(iSb.hasNext()){
            subR=(SubRubros)iSb.next();
            this.jComboBox3.addItem(subR.getDescripcion());
        }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
