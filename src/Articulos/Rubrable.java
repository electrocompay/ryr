/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Articulos;

import java.util.ArrayList;

/**
 *
 * @author mauro di
 */
public interface Rubrable {
    public Integer nuevo(Object rubro);
    public Boolean modificar(Object rubro);
    public void modificarPrecioRubro(Integer idRubro,Double precio);
    public ArrayList listarPorRubro(Integer idRubro);
    public ArrayList listarPorSubRubro(Integer idSubRubro);
    public void eliminar(Integer idRubro);
    public void modificarCostoPorRubro(Integer idRubro,Double precio);
}
