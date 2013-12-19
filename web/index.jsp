<%@page import="com.fpmislata.banco.datos.HibernateUtil"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpHibernate"%>
<%@page import="com.fpmislata.banco.modelo.TipoEntidadBancaria"%>
<%@page import="org.hibernate.service.ServiceRegistryBuilder"%>
<%@page import="org.hibernate.service.ServiceRegistry"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpJDBC"%>
<%@page import="java.util.List"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAO"%>
<%@page import="com.fpmislata.banco.modelo.EntidadBancaria"%>
<%@page import="com.fpmislata.banco.datos.ConnectionFactoryJDBC"%>
<%@page import="com.fpmislata.banco.datos.ConnectionFactory"%>
<%
    HibernateUtil hibernateUtil = new HibernateUtil();

        
    EntidadBancariaDAO entidadBancariaHibernate = new EntidadBancariaDAOImpHibernate();  
%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/bootstrap.css" rel="stylesheet" >
        <title>JSP Page</title>
    </head>
    <body>
        <a href="nuevo.jsp" name="nuevo" class="btn btn-info">Nueva entidad bancaria</a>
        <table class="table table-striped table-hover">
            <tr>
                <%
                    for (EntidadBancaria entidadBancaria : entidadBancariaHibernate.findAll()) {
                        String nombre = entidadBancaria.getNombre();
                        String cif = entidadBancaria.getCif(); 
                        int idEntidadBancaria = entidadBancaria.getIdEntidad();
                        int id = entidadBancaria.getIdEntidad();
                        TipoEntidadBancaria tipo = entidadBancaria.getTipo();
                %> 
                <td> <%=id%> </td>
                <td> <%=nombre%> </td>
                <td> <%=cif%> </td>
                <td> <%=tipo.name()%> </td>
                <td> <a href="actualizar.jsp?idEntidadBancaria=<%=idEntidadBancaria%>" name="actualizar" class="btn btn-success"> Actualizar </a></td>
                <td> <a href="borrar.jsp?idEntidadBancaria=<%=idEntidadBancaria%>" name="borrar" class="btn btn-danger"> Borrar </a>
            </tr>
            <% }%>
        </table>
    </body>
</html>
