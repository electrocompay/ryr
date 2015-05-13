/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cotizaciones;

import interfaces.Transaccionable;
import java.sql.Date;
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
public class DetalleCotizacion implements Cotizable{
    private Integer id;
    private Integer idCotizacion;
    private Integer idArticulo;
    private String descripcionArticulo;
    private Integer idCliente;
    private Double cantidad;
    private Double precioUnitario;
    private int  descuento;
    private String observaciones;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(Integer idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcionArticulo() {
        return descripcionArticulo;
    }

    public void setDescripcionArticulo(String descripcionArticulo) {
        this.descripcionArticulo = descripcionArticulo;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public Object cargarEncabezado(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList cargarDetalle(Integer idCotizacion) {
        ArrayList detalle=new ArrayList();
        String sql="select * from detallecotizaciones where idcotizacion="+idCotizacion+" order by id";
        Transaccionable tra=new Conecciones();
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        DetalleCotizacion cotizacionD;
        try {
            while(rs.next()){
                cotizacionD=new DetalleCotizacion();
                cotizacionD.setId(rs.getInt("id"));
                cotizacionD.setIdArticulo(rs.getInt("idArticulo"));
                cotizacionD.setDescripcionArticulo(rs.getString("descripcionarticulo"));
                cotizacionD.setCantidad(rs.getDouble("cantidad"));
                cotizacionD.setIdCliente(rs.getInt("idcliente"));
                cotizacionD.setIdCotizacion(rs.getInt("idcotizacion"));
                cotizacionD.setPrecioUnitario(rs.getDouble("preciounitario"));
                detalle.add(cotizacionD);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleCotizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return detalle;
    }

    @Override
    public ArrayList listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listarPorCliente(Integer idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listarPorEstado(Integer idCliente, int estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listarPorFecha(Date fechaDesde, Date fechaHasta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listarPorVencimiento(Date fechaDesde, Date fechaHasta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listarPorArticulo(Integer idArticulo, Integer idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listarPorPedido(Integer idPedido, Integer idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer nuevaCotizacion(Object coti) {
       DetalleCotizacion detalle=new DetalleCotizacion();
       detalle=(DetalleCotizacion)coti;
       int dev=0;
       String sql="insert into detallecotizaciones (idcotizacion,idarticulo,descripcionarticulo,idcliente,cantidad,preciounitario,descuento,observaciones) values ("+detalle.getIdCotizacion()+","+detalle.getIdArticulo()+",'"+detalle.getDescripcionArticulo()+"',"+detalle.getIdCliente()+","+detalle.getCantidad()+","+detalle.getPrecioUnitario()+","+detalle.getDescuento()+",'xx')";
       Transaccionable tra=new Conecciones();
       tra.guardarRegistro(sql);
       
       return dev;
    }

    @Override
    public Object modificarCotizacion(Object coti) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarCotizacion(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel mostrarListado(ArrayList listadoC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void transformarEnPedido(Object coti, ArrayList detalle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void transformarEnFactura(Object coti, ArrayList detalle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
