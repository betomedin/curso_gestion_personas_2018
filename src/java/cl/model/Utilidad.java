/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.model;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author betomedin
 */
@ApplicationScoped
public class Utilidad implements IUtilidad {

    @Override
    public Persona loguear(String rut, String clave, List<Persona> list) {
        for (Persona p : list) {
            if (p.getRut().equals(rut) && p.getClave().equals(clave) && p.isActivo()) {
                return p;
            }
        }
        return null;
    }
    
    public Persona buscar(String rut, List<Persona> lista){        
        for (Persona p : lista) {
            if (p.getRut().equals(rut) ) {
                return p;
            }
        }
        return null;
    }

}
