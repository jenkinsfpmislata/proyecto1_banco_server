<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAO"%><%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpHibernate"%><%@page import="com.fpmislata.banco.modelo.TipoEntidadBancaria"%><%@page import="com.fasterxml.jackson.databind.ObjectMapper"%><%@page import="com.fasterxml.jackson.databind.MappingJsonFactory"%><%@page import="com.fpmislata.banco.modelo.EntidadBancaria"%><%
    EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImpHibernate();
    EntidadBancaria entidadBancaria = new EntidadBancaria();
        entidadBancaria.setNombre(request.getParameter("nombre"));
        entidadBancaria.setCif(request.getParameter("cif"));
        entidadBancaria.setCodigoEntidadBancaria(request.getParameter("codigo"));
        entidadBancaria.setTipo(TipoEntidadBancaria.valueOf(request.getParameter("tipo")));
        entidadBancariaDAO.insert(entidadBancaria);
        ObjectMapper jackson = new ObjectMapper();
        String json = jackson.writeValueAsString(null);
    response.setContentType("aplication/json; charset=UTF-8");
    out.print(json);
%>