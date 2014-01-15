<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%><%@page import="com.fpmislata.banco.datos.EntidadBancariaDAO"%><%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpHibernate"%><%
    EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImpHibernate();
    entidadBancariaDAO.delete(Integer.parseInt(request.getParameter("id")));
    ObjectMapper jackson = new ObjectMapper();
    String json = jackson.writeValueAsString(null);
    response.setContentType("aplication/json; charset=UTF-8");
    out.print(json);
%>
