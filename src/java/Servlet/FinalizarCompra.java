/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.DetalleVenta;
import Controlador.Producto;
import Controlador.Usuario;
import Controlador.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author demon
 */
public class FinalizarCompra extends HttpServlet {

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
            HttpSession sessionok = request.getSession();
            //vamos a hacer un objeto de fecha
            Date dia = new Date();
            //el objeto del vector del detalle de la venta
            Vector<DetalleVenta> vectorDetalle = (Vector<DetalleVenta>)sessionok.getAttribute("detalleVenta");
            Vector<Producto> stockProducto = (Vector<Producto>)sessionok.getAttribute("stockProducto");
            //creamos el objeto del producto
            Producto prod = new Producto();
            double totalPagar = 0;
            
            //para saber cuanto vamos a pagar hay que recorrer toda la lista del detalle de la venta de los productos
            for(DetalleVenta dv : vectorDetalle){
                totalPagar += dv.getDetVenta_Subtotal();
            }
            
            //obtenemos al usuario
            Usuario usuario = new Usuario();
            //obtenemos la venta
            Venta venta = new Venta();
            
            //enviamos los parametros del usuario y de la venta
            venta.setUsuario_Codigo(usuario.getUsuario_Codigo());
            venta.setVenta_Fecha(dia.toString());
            venta.setVenta_TotalPagar(totalPagar);
            
            //ahora verificamos que se registre la venta y actualizamos el stock al final
            boolean registrarVenta = venta.registrarVenta(venta, vectorDetalle);
            boolean actualizarVenta = prod.actualizarStock(stockProducto);
            
            if(registrarVenta != actualizarVenta){
                response.sendRedirect("Mensaje.jsp");
            }else{
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
