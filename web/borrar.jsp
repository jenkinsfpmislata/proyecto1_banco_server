<%-- 
    Document   : Borrar
    Created on : 07-nov-2013, 9:29:01
    Author     : alumno
--%>

<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpHibernate"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%     
    EntidadBancariaDAO ebh = new EntidadBancariaDAOImpHibernate();
    int idEntidadBancaria = Integer.parseInt(request.getParameter("idEntidadBancaria"));
    
    ebh.delete(idEntidadBancaria);
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1> Tu entidad bancaria ha sido borrada </h1>
    </body>
</html>
