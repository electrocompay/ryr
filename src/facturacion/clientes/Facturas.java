/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion.clientes;

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
public class Facturas implements Facturable{
    private Integer id;
    private Integer idCliente;
    private Date fecha;
    private Double total;
    private Integer tipo;
    private Integer idUsuario;
    private Integer idPedido;
    private Integer idRemito;
    private String archivo;
    private Integer numeroFactura;
    private Integer estado;
    private String descripcionTipo;

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }

    
    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdRemito() {
        return idRemito;
    }

    public void setIdRemito(Integer idRemito) {
        this.idRemito = idRemito;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public Integer getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    @Override
    public Integer nuevaFactura(Object ped) {
        Facturas factura=new Facturas();
        factura=(Facturas)ped;
        Transaccionable tra=new Conecciones();
        String sql="insert into facturas (idcliente,total,tipo,idusuario,idpedido,idremito,numerofactura,estado) values ("+factura.getIdCliente()+",round("+factura.getTotal()+",4),"+factura.getTipo()+","+factura.getIdUsuario()+","+factura.getIdPedido()+","+factura.getIdRemito()+","+factura.getNumeroFactura()+","+factura.getEstado()+")";
        tra.guardarRegistro(sql);
        int idNuevo=0;
        sql="select LAST_INSERT_ID()";
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rs.next()){
                idNuevo=rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Facturas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idNuevo;
    }

    @Override
    public ArrayList cargarDetallefactura(Integer idPed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object cargarEncabezadoFactura(Integer idPed,Integer tipo) {
        Facturas factura=new Facturas();
        String sql="select *,(select tipocomprobantes.descripcion from tipocomprobantes where tipocomprobantes.id=facturas.tipo)as descripcionTipo from facturas where numerofactura="+idPed+" and tipo="+tipo;
        Transaccionable tra=new Conecciones();
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rs.next()){
                factura.setEstado(rs.getInt("estado"));
                factura.setFecha(rs.getDate("fecha"));
                factura.setId(rs.getInt("id"));
                factura.setIdCliente(rs.getInt("idcliente"));
                factura.setIdPedido(rs.getInt("idpedido"));
                factura.setIdRemito(rs.getInt("idremito"));
                factura.setIdUsuario(rs.getInt("idusuario"));
                factura.setNumeroFactura(rs.getInt("numerofactura"));
                factura.setTipo(rs.getInt("tipo"));
                factura.setTotal(rs.getDouble("total"));
                factura.setDescripcionTipo(rs.getString("descripcionTipo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Facturas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return factura;
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
