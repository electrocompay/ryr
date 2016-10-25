
package objetos;

import interfaces.Componable;
import interfaces.Personalizable;
import interfaces.Transaccionable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauro
 */
public class Transportes implements Personalizable,Componable{
   private Integer id;
   private String descripcion;
   private String direccion;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public Boolean agregar(Object objeto) {
        Transportes transporte=(Transportes) objeto;
        Boolean verif=false;
        String sql="insert into transportes (descripcion,direccion) values ('"+transporte.getDescripcion()+"','"+transporte.getDireccion()+"')";
        Transaccionable tra=new Conecciones();
        verif=tra.guardarRegistro(sql);
        
        return verif;
    }

    @Override
    public Boolean modificar(Object objeto) {
        Transportes transporte=(Transportes) objeto;
        Boolean verif=false;
        String sql="update transportes set descripcion='"+transporte.getDescripcion()+"',direccion='"+transporte.getDireccion()+"' where id="+transporte.getId();
        Transaccionable tra=new Conecciones();
        verif=tra.guardarRegistro(sql);
        
        return verif;
    }

    @Override
    public Boolean eliminar(Object objeto) {
        Transportes transporte=(Transportes) objeto;
        Boolean verif=false;
        String sql="delete from transportes where id="+transporte.getId();
        Transaccionable tra=new Conecciones();
        verif=tra.guardarRegistro(sql);
        return verif;
    }

    @Override
    public Object buscarPorNumero(Integer id) {
        Transportes transporte=new Transportes();
        Transaccionable tra=new Conecciones();
        ResultSet rs=tra.leerConjuntoDeRegistros("select * from transportes where id="+transporte.getId());
       try {
           while(rs.next()){
               transporte.setId(rs.getInt("id"));
               transporte.setDescripcion(rs.getString("descripcion"));
               transporte.setDireccion(rs.getString("direccion"));
               
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(Transportes.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return transporte;
    }

    @Override
    public Object buscarPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscarPorCuit(String cuit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listar() {
        ArrayList lisatdo=new ArrayList();
        String sql="select * from transportes order by descripcion";
        Transaccionable tra=new Conecciones();
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        Transportes transporte;
       try {
           while(rs.next()){
               transporte=new Transportes();
               transporte.setId(rs.getInt("id"));
               transporte.setDescripcion(rs.getString("descripcion"));
               transporte.setDireccion(rs.getString("direccion"));
               lisatdo.add(transporte);
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(Transportes.class.getName()).log(Level.SEVERE, null, ex);
       }
       return lisatdo;
    }

    @Override
    public ArrayList listarPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listarPorCuit(String cuit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultListModel LlenarList(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel LlenarTabla(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ComboBoxModel LlenarCombo(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultListModel LlenarListConArray(ArrayList listado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel LlenarTablaConArray(ArrayList listado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultComboBoxModel LlenarComboConArray(ArrayList listado) {
        DefaultComboBoxModel combo=new DefaultComboBoxModel();
        Iterator it=listado.listIterator();
        Transportes transporte;
        while(it.hasNext()){
            transporte=(Transportes)it.next();
            combo.addElement(transporte.getDescripcion());
        }
        return combo;
    }
   
   
}
