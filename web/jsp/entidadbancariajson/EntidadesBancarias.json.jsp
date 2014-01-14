<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAO"%><%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpHibernate"%><%@page import="com.fpmislata.banco.modelo.TipoEntidadBancaria"%><%@page import="com.fasterxml.jackson.databind.ObjectMapper"%><%@page import="com.fasterxml.jackson.databind.MappingJsonFactory"%><%@page import="com.fpmislata.banco.modelo.EntidadBancaria"%><%
    EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImpHibernate();
    ObjectMapper jackson = new ObjectMapper();
    String json = jackson.writeValueAsString(entidadBancariaDAO.findAll());
    response.setContentType("aplication/json; charset=UTF-8");
    out.print(json);
%>