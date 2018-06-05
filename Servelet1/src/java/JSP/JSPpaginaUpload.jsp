<%-- 
    Document   : JSPpaginaUpload
    Created on : 22/05/2018, 16:14:14
    Author     : César
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Inserir Imagem </h1>
        <input type="file" name="Imagem" />
        <form action="./servlet/Upload" method="POST" action="" accept-charset="utf-8">
            
            <img src="<%= request.getParameter("Imagem") %>" alt="">

            <input type="submit" name="enviar" value="Enviar"/>
        </form>
    </body>
</html>
