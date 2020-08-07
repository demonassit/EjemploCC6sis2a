<%-- 
    Document   : AgregarProducto2
    Created on : 6/08/2020, 12:00:17 PM
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
        <title>Agregar Producto</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <%   

    //obtener la busqueda de un solo producto para agregarlo al carrito
    Producto prod = new Producto().buscarProducto(Integer.parseInt(request.getParameter("cod")));

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
                    <form method="post" name="agregarcarrito" action="AgregarCarrito" >
                        <table width="100%" border="0" >
                            <tr>
                                <td width="17%" bgcolor="#FF0000" >
                                    <span class="Estilo3" >Codigo:</span>
                                </td>
                                <td width="83%" bgcolor="#FF0000" >
                                    <label><input type="text" name="txtCodigo" id="txtCodigo"
                                                  readonly size="10" value="<%=prod.getProducto_Codigo() %>" ></label>
                                </td>
                                <td width="17%" bgcolor="#FF0000" >
                                    <span class="Estilo3" >Producto:</span>
                                </td>
                                <td width="83%" bgcolor="#FF0000" >
                                    <label><input type="text" name="txtProducto" id="txtProducto"
                                                  readonly size="60" value="<%=prod.getProducto_Nombre()%>" ></label>
                                </td>
                                <td width="17%" bgcolor="#FF0000" >
                                    <span class="Estilo3" >Precio:</span>
                                </td>
                                <td width="83%" bgcolor="#FF0000" >
                                    <label><input type="text" name="txtPrecio" id="txtPrecio"
                                                  readonly size="15" value="<%=prod.getProducto_Precio()%>" ></label>
                                </td>
                                <td width="17%" bgcolor="#FF0000" >
                                    <span class="Estilo3" >Stock:</span>
                                </td>
                                <td width="83%" bgcolor="#FF0000" >
                                    <label><input type="text" name="txtStock" id="txtStock"
                                                  readonly size="15" value="<%=prod.getProducto_Stock()%>" ></label>
                                </td>
                                <td width="17%" bgcolor="#FF0000" >
                                    <span class="Estilo3" >Cantidad:</span>
                                </td>
                                <td width="83%" bgcolor="#FF0000" >
                                    <label><input type="text" name="txtCantidad" id="txtCantidad"
                                                  readonly size="15" value="1" ></label>
                                </td>
                                
                            </tr>
                            <tr>
                                <td></td>
                                <td> <input type="submit" name="button" value="Registrar Compra" > </td>
                            </tr>
                        </table>
                    </form>
                </td> 
            </tr>
            <tr>
                <td colspan="2" ></td>
            </tr>
        </table>
    </body>
</html>
