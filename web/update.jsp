<%@page import="com.fpmislata.banco.modelo.TipoEntidadBancaria"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpHibernate"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAO"%>
<%@page import="com.fpmislata.banco.modelo.EntidadBancaria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImpHibernate();
    int idEntidadBancaria = Integer.parseInt(request.getParameter("idEntidadBancaria"));
    EntidadBancaria entidadBancaria = entidadBancariaDAO.read(idEntidadBancaria);
    
    entidadBancaria.setNombre(request.getParameter("nombre"));
    entidadBancaria.setCodigoEntidadBancaria(request.getParameter("codigo"));
    entidadBancaria.setCif(request.getParameter("cif"));
    entidadBancaria.setTipo(TipoEntidadBancaria.valueOf(request.getParameter("tipo")));
    
    entidadBancariaDAO.update(entidadBancaria);
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Exito al actualizar la entidad bancaria en la BD</h1>
        <a href="index.jsp">Volver</a>
    </body>
</html>
