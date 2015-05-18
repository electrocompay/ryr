/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Articulos;

import interfaces.Personalizable;
import interfaces.Transaccionable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Conecciones;

/**
 *
 * @author mauro di
 */
public class Rubros implements Personalizable,Rubrable{
    private Integer id;
    private String descripcion;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean modificar(Object objeto) {
        Rubros rubro=new Rubros();
        rubro=(Rubros)objeto;
        String sql="update rubros set descripcion='"+rubro.getDescripcion()+"' where id="+rubro.getId();
        Transaccionable tra=new Conecciones();
        tra.guardarRegistro(sql);
        return true;
    }

    @Override
    public Boolean eliminar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscarPorNumero(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        ArrayList listado=new ArrayList();
        String sql="select * from rubros order by descripcion";
        Transaccionable tra=new Conecciones();
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rs.next()){
                Rubros rubro=new Rubros();
                rubro.setId(rs.getInt("id"));
                rubro.setDescripcion(rs.getString("descripcion"));
                listado.add(rubro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Rubros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
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
    public Integer nuevo(Object rubro) {
        Rubros rubros=new Rubros();
        rubros=(Rubros)rubro;
        String sql="insert into rubros (descripcion) values ('"+rubros.getDescripcion()+"')";
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
            Logger.getLogger(Rubros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ultimo;
    }

    @Override
    public void modificarPrecioRubro(Integer idRubro, Double precio) {
        Double coe=precio / 100;
        coe=coe + 1;
        System.out.println("resultado :"+coe);
        String sql="update articulos set precio=round((precio * "+coe+"),4) where idrubro="+idRubro;
        Transaccionable tra=new Conecciones();
        tra.guardarRegistro(sql);
        
    }

    @Override
    public ArrayList listarPorRubro(Integer idRubro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        String sql="update articulos set costo=round((costo * "+coe+"),4) where idrubro="+idRubro;
        Transaccionable tra=new Conecciones();
        tra.guardarRegistro(sql);
    }
    
    
}