/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author demon
 */
public class VerificarUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //primero obtener los parametros del formulario
            String user, clave;
            
            user = request.getParameter("txtUsuario");
            clave = request.getParameter("txtClave");
            
            //la instancia del usuario
            Usuario u = new Usuario();
            u = u.verificarUsuario(user, clave);
            
            //ahora falta verificar si es cliente o administrador
            
            if(u!=null){
                //el usuario existe en la bd y solo falta verificar si es cliente o admin
                //manejo de sesiones
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("Usuario", u);
                
                //manejar una segunda sesion para saber quien es
                HttpSession sesionok = request.getSession();
                sesionok.setAttribute("Usuario", user);
                
                //ahora vamos a reconocerlo
                if(u.getUsuario_Privilegio()==0){
                    //el usuario es un cliente
                    response.sendRedirect("MostrarProductos.jsp");
                }else{
                    //el usuario es un administrador
                    response.sendRedirect("MostrarProductosEmpleado.jsp");
                }
            }else{
                //si el usuario no existe o la clave es erronea
                response.sendRedirect("Error.jsp");
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
