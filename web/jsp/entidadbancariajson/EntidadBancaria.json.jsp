<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAO"%><%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpHibernate"%><%@page import="com.fpmislata.banco.modelo.TipoEntidadBancaria"%><%@page import="com.fasterxml.jackson.databind.ObjectMapper"%><%@page import="com.fasterxml.jackson.databind.MappingJsonFactory"%><%@page import="com.fpmislata.banco.modelo.EntidadBancaria"%><%
    EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImpHibernate();
    EntidadBancaria entidadBancaria = entidadBancariaDAO.read(Integer.parseInt(request.getParameter("id")));
    ObjectMapper jackson = new ObjectMapper();
    String json = jackson.writeValueAsString(entidadBancaria);
    response.setContentType("aplication/json; charset=UTF-8");
    out.print(json);
%>