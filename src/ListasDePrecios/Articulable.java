/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasDePrecios;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauro di
 */
public interface Articulable {
    public ArrayList filtrador(ArrayList rubro,ArrayList subRubro,Object cli);
    public void guardar(ArrayList listado);
    public DefaultTableModel mostrarListado(ArrayList lista);
    public ArrayList listarTodos(Object idCliente);
}
