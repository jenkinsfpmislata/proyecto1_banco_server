<%-- 
    Document   : insert
    Created on : 08-nov-2013, 10:05:08
    Author     : alumno
--%>

<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAO"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpHibernate"%>
<%@page import="com.fpmislata.banco.modelo.TipoEntidadBancaria"%>
<%@page import="com.fpmislata.banco.modelo.EntidadBancaria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    EntidadBancaria entidadBancaria = new EntidadBancaria();
    EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImpHibernate();
    
    entidadBancaria.setNombre(request.getParameter("nombre"));
    entidadBancaria.setCif(request.getParameter("cif"));
    entidadBancaria.setCodigoEntidadBancaria(request.getParameter("codigo"));
    entidadBancaria.setTipo(TipoEntidadBancaria.valueOf(request.getParameter("tipo")));
    
    entidadBancariaDAO.insert(entidadBancaria);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Entidad bancaria insertada con exito en la BD</h1>
        <a href="index.jsp">Volver</a>
    </body>
</html>
