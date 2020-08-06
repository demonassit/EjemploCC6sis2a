<%-- 
    Document   : Error
    Created on : 3/08/2020, 12:47:02 PM
    Author     : demon
--%>

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
        <link rel="stylesheet" href="css/style.css"/>
        <title>Pagina de errores</title>
    </head>
    <body>
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
                    <h4> <a href="MostrarProductos.jsp" >Consultar Productos</a> | <a>Agregar al Carrito</a> | <a>Cerrar Sesion</a>        </h4>        
                </td>
            </tr>
            <tr>
                
            </tr>
            <tr>
                <td colspan="2" ></td> 
            </tr>
        </table>
    <center><h1>Vuelva pronto</h1></center>
    </body>
</html>
