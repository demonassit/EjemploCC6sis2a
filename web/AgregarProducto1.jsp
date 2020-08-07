<%-- 
    Document   : AgregarProducto1
    Created on : 6/08/2020, 11:53:57 AM
    Author     : demon
--%>

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
        <title>Agregar Productos</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <%   

    //obtener la lista de todos los productos
    Vector<Producto> vecPro = new Producto().listaProductos();

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
                    <h4> <a href="MostrarProductos.jsp" >Consultar Productos</a> | <a href="AgregarProducto1.jsp" >Agregar al Carrito</a> | <a href="CerrarSesion" >Cerrar Sesion</a>        </h4>        
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
                                <h4><span class="Estilo3" >Stock</span></h4>
                            </td>
                            <td width="16%" align="right" valing="top" >
                                <h4><span class="Estilo3" >Precio</span></h4>
                            </td>
                            <td width="16%" align="right" valing="top" >
                                <h4><span class="Estilo3" >Proceso</span></h4>
                            </td>
                        </tr>
                        <% //recorrer la lista de productos para mostrarla 
                            for(Producto prod : vecPro){
                                String direccion = "AgregarProducto2.jsp?cod="+prod.getProducto_Codigo();
                        %>
                        <tr>
                            <td> <%=prod.getProducto_Nombre() %> </td>
                            <td align="right" valing="top" > <%=prod.getProducto_Stock()%> </td>
                            <td align="right" valing="top" > <%=prod.getProducto_Precio()%> </td>
                            <td align="right" valing="top" > <%=direccion%> </td>
                        </tr>
                        <% } %>
                    </table>
                </td> 
            </tr>
            <tr>
                <td colspan="2" ></td>
            </tr>
        </table>
    </body>
</html>
