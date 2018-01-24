/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.web;

import cl.model.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author betomedin
 */
@WebListener
public class CargaInicio implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<Persona> lista = new ArrayList();
        lista.add(new Persona("1111", "Perico", "estudiante", "perico@inacap.cl", "hola", true));
        lista.add(new Persona("2222", "Maria", "docente", "mariapetunias@inacap.cl", "hola", false));
        lista.add(new Persona("3333", "Juancho", "administrador", "juancho@inacap.cl", "hola", true));
        
        sce.getServletContext().setAttribute("lista", lista);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
