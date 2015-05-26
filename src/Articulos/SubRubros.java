/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Articulos;

import interfaces.Transaccionable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import objetos.Conecciones;

/**
 *
 * @author mauro di
 */
public class SubRubros implements Rubrable{
    private Integer id;
    private Integer idRubro;
    private String descripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(Integer idRubro) {
        this.idRubro = idRubro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public Integer nuevo(Object rubro) {
        SubRubros subRubro=new SubRubros();
        subRubro=(SubRubros)rubro;
        
        String sql="insert into subrubros(descripcion) values ('"+subRubro.getDescripcion()+"')";
        Transaccionable tra=new Conecciones();
        tra.guardarRegistro(sql);
        int ultimo=0;
        sql="select LAST_INSERT_ID()";
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rs.next()){
                ultimo=rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubRubros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ultimo;
    }

    @Override
    public Boolean modificar(Object rubros) {
        SubRubros rubro=new SubRubros();
        rubro=(SubRubros)rubros;
        String sql="update subrubros set descripcion='"+rubro.getDescripcion()+"' where id="+rubro.getId();
        Transaccionable tra=new Conecciones();
        tra.guardarRegistro(sql);
        return true;
    }

    @Override
    public void modificarPrecioRubro(Integer idRubro, Double precio) {
        Double coe=precio / 100;
        coe=coe + 1;
        System.out.println("resultado :"+coe);
        String sql="update articulos set precio=round((precio * "+coe+"),4) where idsubrubro="+idRubro;
        Transaccionable tra=new Conecciones();
        tra.guardarRegistro(sql);
    }

    @Override
    public ArrayList listarPorRubro(Integer idRubro) {
        ArrayList listado=new ArrayList();
        SubRubros subRubro;
        String sql="select * from subrubros order by descripcion";
        Transaccionable tra=new Conecciones();
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rs.next()){
                subRubro=new SubRubros();
                subRubro.setDescripcion(rs.getString("descripcion"));
                subRubro.setId(rs.getInt("id"));
                listado.add(subRubro);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubRubros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
    }

    @Override
    public ArrayList listarPorSubRubro(Integer idSubRubro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer idRubro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarCostoPorRubro(Integer idRubro, Double precio) {
        Double coe=precio / 100;
        coe=coe + 1;
        System.out.println("resultado :"+coe);
        String sql="update articulos set costo=round((costo * "+coe+"),4) where idsubrubro="+idRubro;
        Transaccionable tra=new Conecciones();
        tra.guardarRegistro(sql);
    }

    @Override
    public DefaultTableModel mostrarListado(ArrayList listado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
