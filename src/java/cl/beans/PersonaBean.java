/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.model.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author betomedin
 */
@Singleton
public class PersonaBean implements PersonaBeanLocal {

    private List<Persona> list = new ArrayList();

    public PersonaBean() {
        list.add(new Persona("1-1", "Perico", "Administrador", "juan@gmail.com", "123", true));
        list.add(new Persona("2-2", "Pedro", "Persona", "persona@gmail.com", "123", true));
        list.add(new Persona("3-3", "Maria", "Persona", "maria@gmail.com", "123", true));
    }

    @Override
    public Persona buscar(String rut) {
        for (Persona p : list) {
            if (p.getRut().equals(rut)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Persona loguear(String rut, String clave) {
        for (Persona p : list) {
            if (p.getRut().equals(rut) && p.getClave().equals(clave)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void editar(String rut, boolean activo) {
        for (Persona p : list) {
            if (p.getRut().equals(rut)) {
                p.setActivo(activo);
            }
        }
    }

    @Override
    public List<Persona> getPersonaList() {
        return list;
    }

    @Override
    public String agregar(Persona persona) {
        Persona p = buscar(persona.getRut());
        if (p == null) {
            list.add(persona);
            return "Persona agregada correctamente";
        } else {
            return "La persona ya se encuentra registrada";
        }

    }
}
