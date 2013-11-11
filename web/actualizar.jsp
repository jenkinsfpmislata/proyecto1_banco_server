<%@page import="com.fpmislata.banco.modelo.TipoEntidadBancaria"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAO"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpHibernate"%>
<%@page import="com.fpmislata.banco.modelo.EntidadBancaria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    EntidadBancaria entidadBancaria;
    EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImpHibernate();
    int idEntidadBancaria = Integer.parseInt(request.getParameter("idEntidadBancaria"));
    entidadBancaria = entidadBancariaDAO.read(idEntidadBancaria);

    String nombre = entidadBancaria.getNombre();
    String codigo = entidadBancaria.getCodigoEntidadBancaria();
    String cif = entidadBancaria.getCif();
    String tipo = entidadBancaria.getTipo().toString();
    
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2> Inserta los datos de la entidad bancaria que quieras modificar </h2>
        <form action="update.jsp?idEntidadBancaria=<%=idEntidadBancaria%>">
            Nombre: <input type="text" name="nombre" value="<%=nombre%>"><br/>        
            Codigo: <input type="text" name="codigo" value="<%=codigo%>"><br/>
            CIF: <input type="text" name="cif" value="<%=cif%>"><br/>   
            Tipo de entidad: 
           <select name="tipo">
                <option value="cooperativaCredito"> cooperativaCredito </option>
                <option value="banco"> banco </option>
                <option value="cajaAhorro"> cajaAhorro </option>
                <option value="establecimientoFinancierodecredito"> establecimientoFinancierodecredito </option>
            </select><br/> 
            <input type="submit" value="Insertar" name="subir"/>
        </form>
    </body>
</html>
