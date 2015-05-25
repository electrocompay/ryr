/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion.clientes;

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
public class DetalleFacturas implements Facturable{
    private Integer id;
    private Integer idFactura;
    private Integer idArticulo;
    private Double cantidad;
    private String descripcionArticulo;
    private Double precioUnitario;
    private Integer descuento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcionArticulo() {
        return descripcionArticulo;
    }

    public void setDescripcionArticulo(String descripcionArticulo) {
        this.descripcionArticulo = descripcionArticulo;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    @Override
    public Integer nuevaFactura(Object ped) {
        DetalleFacturas detalle=new DetalleFacturas();
        int id=0;
        detalle=(DetalleFacturas)ped;
        String sql="insert into detallefacturas (idfactura,idarticulo,cantidad,preciounitario,descuento) values ("+detalle.getIdFactura()+","+detalle.getIdArticulo()+","+detalle.getCantidad()+",round("+detalle.getPrecioUnitario()+",4),"+detalle.getDescuento()+")";
        Transaccionable tra=new Conecciones();
        tra.guardarRegistro(sql);
        return id;
    }

    @Override
    public ArrayList cargarDetallefactura(Integer idPed) {
        DetalleFacturas detalle;
        ArrayList listadoDetalle=new ArrayList();
        String sql="select *,(select articulos.nombre from articulos where articulos.id=detallefacturas.idarticulo)as descripcion from detallefacturas where idfactura="+idPed;
        Transaccionable tra=new Conecciones();
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rs.next()){
                detalle=new DetalleFacturas();
                detalle.setIdArticulo(rs.getInt("idArticulo"));
                detalle.setCantidad(rs.getDouble("cantidad"));
                detalle.setPrecioUnitario(rs.getDouble("preciounitario"));
                detalle.setId(rs.getInt("id"));
                detalle.setDescripcionArticulo(rs.getString("descripcion"));
                listadoDetalle.add(detalle);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleFacturas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listadoDetalle;
    }

    @Override
    public Object cargarEncabezadoFactura(Integer idPed,Integer tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listarPorCliente(Integer idClient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listarPorEstado(Integer idClient, int estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean modificarFactura(Object ped) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarFactura(Integer idPed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel mostrarListado(ArrayList lista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void transformarEnRemito(Object ped, ArrayList detalle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void transformarEnrecibo(Object ped, ArrayList detalle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void transformarEndetalle(Object ped, ArrayList detalle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList convertirAArticulos(ArrayList detalle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
