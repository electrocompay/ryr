/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion.clientes;

import Conversores.Numeros;
import interfaces.Transaccionable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import objetosR.Conecciones;
import tablas.MiModeloTablaContacto;

/**
 *
 * @author mauro di
 */
public class MovimientoProveedores implements Facturable{
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
    private Double montoOriginal;
    private String numeroFiscal;
    private Double subTotal;
    private Double descuento;
    private Double porcentajeDescuento;

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(Double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
    

    public String getNumeroFiscal() {
        return numeroFiscal;
    }

    public void setNumeroFiscal(String numeroFiscal) {
        this.numeroFiscal = numeroFiscal;
    }
    
    

    public Double getMontoOriginal() {
        return montoOriginal;
    }

    public void setMontoOriginal(Double montoOriginal) {
        this.montoOriginal = montoOriginal;
    }
    
    

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
        MovimientoProveedores factura=new MovimientoProveedores();
        factura=(MovimientoProveedores)ped;
        Transaccionable tra=new Conecciones();
        String sql="insert into facturas (idcliente,total,tipo,idusuario,idpedido,idremito,numerofactura,estado,saldo,subtotal,descuento,porcentajeD) values ("+factura.getIdCliente()+",round("+factura.getTotal()+",4),"+factura.getTipo()+","+factura.getIdUsuario()+","+factura.getIdPedido()+","+factura.getIdRemito()+","+factura.getNumeroFactura()+","+factura.getEstado()+",round("+factura.getTotal()+",4),"+factura.getSubTotal()+","+factura.getDescuento()+","+factura.getPorcentajeDescuento()+")";
        tra.guardarRegistro(sql);
        int idNuevo=0;
        sql="select LAST_INSERT_ID()";
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rs.next()){
                idNuevo=rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovimientoProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idNuevo;
    }

    @Override
    public ArrayList cargarDetallefactura(Integer idPed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object cargarEncabezadoFactura(Integer idPed,Integer tipo) {
        MovimientoProveedores factura=new MovimientoProveedores();
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
                factura.setSubTotal(rs.getDouble("subtotal"));
                factura.setDescuento(rs.getDouble("descuento"));
                factura.setPorcentajeDescuento(rs.getDouble("porcentajeD"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovimientoProveedores.class.getName()).log(Level.SEVERE, null, ex);
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
        MiModeloTablaContacto listado1=new MiModeloTablaContacto();
        MovimientoProveedores cotizacion;
        Iterator iL=lista.listIterator();
        listado1.addColumn("Recibo");
        listado1.addColumn("Fecha");
        listado1.addColumn("Numero");
        listado1.addColumn("Monto");
        listado1.addColumn("Saldo");
        listado1.addColumn("Remito");
        Object[] fila=new Object[6];
        while(iL.hasNext()){
            cotizacion=(MovimientoProveedores)iL.next();
            fila[0]=false;
            fila[1]=String.valueOf(cotizacion.getFecha());
            
                fila[2]=String.valueOf(cotizacion.getNumeroFactura());
            
            fila[3]=String.valueOf(cotizacion.getMontoOriginal());
            fila[4]=Numeros.ConvertirNumero(cotizacion.getTotal());
            fila[5]=String.valueOf(cotizacion.getIdRemito());
            listado1.addRow(fila);
        }
        return listado1;
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

    @Override
    public ArrayList listarPorClienteNoRemitidas(Integer idClient) {
       ArrayList listado=new ArrayList();
       String sql="select facturas.*,pedidos.saldo as saldo1,tipocomprobantes.descripcion as descripcionTipo,remitos.numeroremito as remito from facturas left join pedidos on pedidos.idfactura=facturas.id join tipocomprobantes on tipocomprobantes.id=facturas.tipo left join remitos on remitos.id=facturas.idremito where facturas.idcliente="+idClient;
       System.out.println(sql);
       Transaccionable tra=new Conecciones();
       ResultSet rs=tra.leerConjuntoDeRegistros(sql);
       MovimientoProveedores factura;
        try {
            while(rs.next()){
                factura=new MovimientoProveedores();
                factura.setId(rs.getInt("id"));
                factura.setEstado(rs.getInt("estado"));
                factura.setFecha(rs.getDate("fecha"));
                factura.setIdCliente(rs.getInt("idcliente"));
                factura.setIdPedido(rs.getInt("idpedido"));
                factura.setIdUsuario(rs.getInt("idusuario"));
                factura.setNumeroFactura(rs.getInt("numerofactura"));
                factura.setIdRemito(rs.getInt("remito"));
                factura.setTipo(rs.getInt("tipo"));
                factura.setTotal(rs.getDouble("saldo1"));
                factura.setMontoOriginal(rs.getDouble("total"));
                factura.setDescripcionTipo(rs.getString("descripciontipo"));
                factura.setNumeroFiscal(rs.getString("numerofactura"));
                factura.setSubTotal(rs.getDouble("subtotal"));
                factura.setDescuento(rs.getDouble("descuento"));
                factura.setPorcentajeDescuento(rs.getDouble("porcentajeD"));
                listado.add(factura);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovimientoProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
       return listado;
    }

    @Override
    public ArrayList listarAdeudadaas(Integer idClient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean identificarPedidoAFactura(Integer idPedido, Integer idFactura,Integer numeroFactura) {
        String sql="update pedidos set idfactura="+idFactura+" where id="+idPedido;
        Transaccionable tra=new Conecciones();
        tra.guardarRegistro(sql);
        sql="update facturas set idpedido="+idPedido+",numerofactura="+numeroFactura+" where id="+idFactura;
        tra.guardarRegistro(sql);
        
        return true;
    }

    @Override
    public void actualizadorDeEstado(Object factu) {
        //ACA DEBO PONER EL NUMERO DE ESTADO SI SE HACE RECIBO Y REMITO Y CARGAR EL SALDO
    }

    @Override
    public Object cargarIdFactura(Integer id) {
        MovimientoProveedores factura=new MovimientoProveedores();
        String sql="select *,(select tipocomprobantes.descripcion from tipocomprobantes where tipocomprobantes.id=facturas.tipo)as descripcionTipo from facturas where id="+id;
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
                factura.setSubTotal(rs.getDouble("subtotal"));
                factura.setDescuento(rs.getDouble("descuento"));
                factura.setPorcentajeDescuento(rs.getDouble("porcentajeD"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovimientoProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return factura;
    }
    
    
}
