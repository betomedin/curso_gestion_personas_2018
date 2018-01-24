/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.model.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author betomedin
 */
@Local
public interface PersonaBeanLocal {
    
    Persona buscar(String rut);
    
    Persona loguear(String rut, String clave);
    
    void editar(String rut, boolean activo);
    
    List<Persona> getPersonaList();
    
    String agregar(Persona persona );
}
