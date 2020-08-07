<%-- 
    Document   : cerrarsesion
    Created on : 7/08/2020, 12:15:50 PM
    Author     : demon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true"  %>
<%HttpSession sessionok = request.getSession(); sessionok.invalidate();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cerrar sesion</title>
    </head>
    <body>
        <jsp:forward page="index.html" />
    </body>
</html>
