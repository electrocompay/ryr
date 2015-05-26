/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasDePrecios;

import java.util.ArrayList;

/**
 *
 * @author mauro di
 */
public interface Articulable {
    public ArrayList filtrador(Integer rubro,Integer subRubro);
    public void guardar(ArrayList listado);
    
}
