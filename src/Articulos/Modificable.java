/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Articulos;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauro di
 */
public interface Modificable {
    public ArrayList buscar(Integer rubro,Integer subRubro,String criterio);
    public Integer nuevoArticulo(Object objeto);
    public Boolean modificarArticulo(Object objeto);
    public ArrayList modificarPrecios(ArrayList listado,Double porcPrecio,Double porcCosto);
    public DefaultTableModel mostrarListado(ArrayList listado);
    public DefaultListModel mostrarListadoBusqueda(ArrayList listado);
    public ArrayList buscarParaFacturar(Integer rubro,Integer subRubro,String criterio,Integer idCliente);
    public ArrayList filtrador(ArrayList rubro1, ArrayList subRubro);
}