/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controller;

import cl.beans.PersonaBeanLocal;
import cl.model.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author betomedin
 */
@WebServlet(name = "loginController", urlPatterns = {"/control.do"})
public class loginController extends HttpServlet {

    @EJB
    private PersonaBeanLocal service;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "ingresar":
                ingresar(request, response);
                break;
            case "formRegistro":
                formRegistro(request, response);
                break;
            case "registrar":
                registrar(request, response);
                break;
            case "modificar":
                modificar(request, response);
                break;
            case "modificarForm":
                modificarForm(request, response);
                break;
        }

    }

    protected void ingresar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rut = request.getParameter("rut");
        String clave = request.getParameter("clave");        
        Persona persona = service.loguear(rut, clave);        
        if (persona == null) {
            request.setAttribute("msg", "Usuario y/o clave incorrecta<br>");
        } else {
            request.getSession().setAttribute("persona", persona);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    protected void formRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("registro.jsp").forward(request, response);
    }
    
    protected void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rut = request.getParameter("rut");
        String nombre = request.getParameter("nombre");
        String perfil = request.getParameter("perfil");
        String clave = request.getParameter("clave");
        String correo = request.getParameter("correo");
        
        List<Persona> lista = (List<Persona>) getServletContext().getAttribute("lista");
        lista.add(new Persona(rut, nombre, perfil, correo, clave, true));
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    // Este es modificarForm que hizo Roman
    protected void procesaRut(HttpServletRequest request, HttpServletResponse response, String boton)
            throws ServletException, IOException {
        Persona p = service.buscar(boton);
        request.setAttribute("persona", p);
        request.getRequestDispatcher("registro.jsp").forward(request, response);
    }
    
    protected void modificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rut = request.getParameter("rut");               
        String activo = request.getParameter("activo");       
                
        service.editar(rut, activo.equalsIgnoreCase("si"));
        request.getRequestDispatcher("usuarios.jsp").forward(request, response);
    }
    
    protected void modificarForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rut = request.getParameter("rut");                          
        List<Persona> lista = service.getPersonaList();
        for(Persona p : lista){
            if (p.getRut().equals(rut)) {
                request.setAttribute("persona", p);
                request.getRequestDispatcher("registro.jsp").forward(request, response);
            }
        }              
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
