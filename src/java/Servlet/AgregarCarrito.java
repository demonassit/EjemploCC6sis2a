/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.DetalleVenta;
import Controlador.Producto;
import java.io.IOException;
import java.io.PrintWriter;
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
public class AgregarCarrito extends HttpServlet {

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
            
            //primero obtener la sesion
            HttpSession sesion = request.getSession();
            //realizar las instancias del producto y detalle de la venta
            Vector<Producto> stockProducto = null;
            Vector<DetalleVenta> vectorDetalle = null;
            
            //verificar si la sesion ya tiene algo para comprar
            if(sesion.getAttribute("detalleVenta")!=null){
                //si exite una sesion con algo en el cc
                vectorDetalle = (Vector<DetalleVenta>)sesion.getAttribute("detalleVenta");
                stockProducto = (Vector<Producto>)sesion.getAttribute("stockProducto");
            }else{
                //carrito vacio
                vectorDetalle = new Vector<DetalleVenta>();
                stockProducto = new Vector<Producto>();
            }  
            
            //obtenemos los parametro del formulario
            int codigo, cantidad;
            codigo = Integer.parseInt(request.getParameter("txtCodigo").trim());
            cantidad = Integer.parseInt(request.getParameter("txtCantidad").trim());
            
            Producto prod = new Producto();
            
            prod = prod.buscarProducto(codigo);
            
            double subtotal = cantidad*prod.getProducto_Precio();
            
            //creo el detalle de la venta
            DetalleVenta detalle = new DetalleVenta();
            
            detalle.setDetVenta_Item(vectorDetalle.size()+1);
            detalle.setProducto_Codigo(codigo);
            detalle.setDetVenta_Subtotal(subtotal);
            detalle.setDetVenta_Cantidad(cantidad);
            //lo agrego al vector
            vectorDetalle.add(detalle);
            
            //lo voy a enviar a la sesion
            sesion.setAttribute("detalleVenta", vectorDetalle);
            
            //actualizo el stock
            prod.setProducto_Stock(prod.getProducto_Stock()-cantidad);
            stockProducto.add(prod);
            sesion.setAttribute("stockProducto", stockProducto);
            response.sendRedirect("MostrarCarrito.jsp");
            
            
            
            
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
