<%-- 
    Document   : MostrarCarrito
    Created on : 7/08/2020, 11:36:42 AM
    Author     : demon
--%>

<%@page import="Controlador.DetalleVenta"%>
<%@page import="Controlador.Producto"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<% 
    String usuario = "";
    HttpSession sessionok = request.getSession();
    if(sessionok.getAttribute("usuario")==null){
%>

<jsp:forward page="index.html">
    <jsp:param name="error" 
               value="Es obligatorio autenticarse con un usuario valido" />
</jsp:forward> 

<% 
    }else{
        usuario=(String)sessionok.getAttribute("usuario");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Productos</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <%   

    //obtener la busqueda detalle de la venta
    Vector<DetalleVenta> vectorDetalle = (Vector<DetalleVenta>)session.getAttribute("detalleVenta");
    Vector<Producto> vectorStock = null;

%>
    <table width="800" border="0" align="center"  >
            <tr>
                <td width="84" bgcolor="#FF0000"  > <img src="img/imagen01.jpg" width="84" height="77" > </td>
                <td width="716" bgcolor="#FF0000" ><h1 style="color:#FFFFFF" >Upsss lo siento :P</h1></td>
            </tr>
            <tr align="center" >
                <td colspan="2" ></td>        
            </tr>
            <tr align="center" >
                <td colspan="2" >
                    <h4> <a href="MostrarProductos.jsp" >Consultar Productos</a> | <a href="AgregarProducto1.jsp" >Agregar al Carrito</a> | <a>Cerrar Sesion</a>        </h4>        
                </td>
            </tr>
            <tr>
                
            </tr>
            <tr>
                <td colspan="2" >
                    <table border="0" width="100%" >
                        <tr bgcolor="#FF6600" style="color:#FFFFFFF" >
                            <td width="68%" align="right" valing="top" >
                                <h4><span class="Estilo3" >Nombre</span></h4>
                            </td>
                            <td width="16%" align="right" valing="top" >
                                <h4><span class="Estilo3" >Cantidad</span></h4>
                            </td>
                            <td width="16%" align="right" valing="top" >
                                <h4><span class="Estilo3" >Sub Total</span></h4>
                            </td>
                            
                        </tr>
                        <% //recorrer la lista del detalle de productos para mostrarla 
                            for(DetalleVenta det : vectorDetalle){
                                //objeto de producto, para buscar cada producto su detalle
                                Producto prod = new Producto().buscarProducto(det.getProducto_Codigo());
                        %>
                        <tr>
                            <td> <%=prod.getProducto_Nombre() %> </td>
                            <td align="right" valing="top" > <%=det.getDetVenta_Cantidad() %> </td>
                            <td align="right" valing="top" > <%=det.getDetVenta_Subtotal() %> </td>
                            
                        </tr>
                        <% } %>
                    </table>
                </td> 
            </tr>
            <tr>
                <td colspan="2" >
                    <a href="FinalizarCompra" >Finalizar la compra</a>
                </td>
            </tr>
        </table>

    </body>
</html>
