/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasDePrecios;

import Articulos.Rubros;
import facturacion.clientes.Clientes;
import interfaces.Transaccionable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import objetos.Conecciones;
import tablas.MiModeloTablaContacto;

/**
 *
 * @author mauro di
 */
public class ArticulosAsignados implements Articulable{
    private Integer id;
    private String descripcion;
    private Double precioUnitario;
    private Double precioDeCosto;
    private Integer idCliente;
    private Integer idRubro;
    private Integer idSubRubro;
    private Integer idLista;
    private Double coeficiente;
    private String observaciones;

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

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getPrecioDeCosto() {
        return precioDeCosto;
    }

    public void setPrecioDeCosto(Double precioDeCosto) {
        this.precioDeCosto = precioDeCosto;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(Integer idRubro) {
        this.idRubro = idRubro;
    }

    public Integer getIdSubRubro() {
        return idSubRubro;
    }

    public void setIdSubRubro(Integer idSubRubro) {
        this.idSubRubro = idSubRubro;
    }

    public Integer getIdLista() {
        return idLista;
    }

    public void setIdLista(Integer idLista) {
        this.idLista = idLista;
    }

    public Double getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(Double coeficiente) {
        this.coeficiente = coeficiente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
    
    @Override
    public ArrayList filtrador(ArrayList rubro1, ArrayList subRubro,Object cli) {
        ArrayList listado=new ArrayList();
        String sql="";
        Rubros rubro=new Rubros();
        Clientes cliente=new Clientes();
        cliente=(Clientes)cli;
        ArticulosAsignados articulo;
        Transaccionable tra=new Conecciones();
        ResultSet rs;
        Iterator it=rubro1.listIterator();
        while(it.hasNext()){
            rubro=(Rubros)it.next();
            sql="select articulos.id,articulos.nombre,articulos.costo,articulos.precio,articulos.idrubro,articulos.idsubrubro,(select aplicacion.coeficiente from aplicacion where aplicacion.idarticulo=articulos.id and aplicacion.idcliente="+cliente.getCodigoId()+")as coeficienteA,(select aplicacion.observaciones from aplicacion where aplicacion.idarticulo=articulos.id and aplicacion.idcliente="+cliente.getCodigoId()+")as observaciones,(select aplicacion.idlista from aplicacion where aplicacion.idarticulo=articulos.id and aplicacion.idcliente="+cliente.getCodigoId()+")as idlista from articulos where idrubro="+rubro.getId()+" order by nombre";
            rs=tra.leerConjuntoDeRegistros(sql);
        Double precio=0.00;
        Double coeficiente=1.00;
        try {
            while(rs.next()){
                articulo=new ArticulosAsignados();
                articulo.setId(rs.getInt("id"));
                
                articulo.setDescripcion(rs.getString("nombre"));
                articulo.setIdCliente(cliente.getCodigoId());
                if(rs.getInt("idlista")==0){
                    articulo.setIdLista(cliente.getListaDePrecios());
                    coeficiente=cliente.getCoeficienteListaDeprecios();
                    articulo.setCoeficiente(cliente.getCoeficienteListaDeprecios());
                }else{
                    articulo.setIdLista(rs.getInt("idlista"));
                    articulo.setCoeficiente(rs.getDouble("coeficienteA"));
                    coeficiente=rs.getDouble("coeficienteA");
                }
                articulo.setIdRubro(rs.getInt("idrubro"));
                articulo.setIdSubRubro(rs.getInt("idsubrubro"));
                articulo.setObservaciones(rs.getString("observaciones"));
                articulo.setPrecioDeCosto(rs.getDouble("costo"));
                precio=rs.getDouble("precio") * coeficiente;
                articulo.setPrecioUnitario(precio);
                listado.add(articulo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticulosAsignados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // fin iterator
        }
        return listado;
    }

    @Override
    public void guardar(ArrayList listado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel mostrarListado(ArrayList lista) {
        MiModeloTablaContacto modelo=new MiModeloTablaContacto();
        Iterator it=lista.listIterator();
        ArticulosAsignados articulos=new ArticulosAsignados();
        modelo.addColumn("Listar");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio");
        modelo.addColumn("Costo");
        modelo.addColumn("Lista Asig.");
        Object [] fila=new Object[5];
        while(it.hasNext()){
            articulos=(ArticulosAsignados)it.next();
            fila[0]=true;
            fila[1]=articulos.getDescripcion();
            fila[2]=articulos.getPrecioUnitario();
            fila[3]=articulos.getPrecioDeCosto();
            fila[4]=articulos.getIdLista();
            modelo.addRow(fila);
        }
        return modelo;
        
    }

    @Override
    public ArrayList listarTodos(Object idCliente) {
        ArticulosAsignados articulo;
        Clientes cliente=new Clientes();
        cliente=(Clientes)idCliente;
        ArrayList listado=new ArrayList();
        String sql="select articulos.id,articulos.nombre,articulos.costo,articulos.precio,articulos.idrubro,articulos.idsubrubro,(select aplicacion.coeficiente from aplicacion where aplicacion.idarticulo=articulos.id and aplicacion.idcliente="+cliente.getCodigoId()+")as coeficienteA,(select aplicacion.observaciones from aplicacion where aplicacion.idarticulo=articulos.id and aplicacion.idcliente="+cliente.getCodigoId()+")as observaciones,(select aplicacion.idlista from aplicacion where aplicacion.idarticulo=articulos.id and aplicacion.idcliente="+cliente.getCodigoId()+")as idlista from articulos order by nombre";
        Transaccionable tra=new Conecciones();
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        Double precio=0.00;
        Double coeficiente=1.00;
        try {
            while(rs.next()){
                articulo=new ArticulosAsignados();
                articulo.setId(rs.getInt("id"));
                
                articulo.setDescripcion(rs.getString("nombre"));
                articulo.setIdCliente(cliente.getCodigoId());
                if(rs.getInt("idlista")==0){
                    articulo.setIdLista(cliente.getListaDePrecios());
                    coeficiente=cliente.getCoeficienteListaDeprecios();
                    articulo.setCoeficiente(cliente.getCoeficienteListaDeprecios());
                }else{
                    articulo.setIdLista(rs.getInt("idlista"));
                    articulo.setCoeficiente(rs.getDouble("coeficienteA"));
                    coeficiente=rs.getDouble("coeficienteA");
                }
                articulo.setIdRubro(rs.getInt("idrubro"));
                articulo.setIdSubRubro(rs.getInt("idsubrubro"));
                articulo.setObservaciones(rs.getString("observaciones"));
                articulo.setPrecioDeCosto(rs.getDouble("costo"));
                precio=rs.getDouble("precio") * coeficiente;
                articulo.setPrecioUnitario(precio);
                listado.add(articulo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticulosAsignados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listado;
        
    }
    
}
