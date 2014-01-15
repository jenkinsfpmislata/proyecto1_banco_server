<%@page import="com.fpmislata.banco.datos.CuentaBancariaDAOImpHibernate"%><%@page import="com.fpmislata.banco.datos.CuentaBancariaDAO"%><%@page import="com.fasterxml.jackson.databind.ObjectMapper"%><%@page import="com.fasterxml.jackson.databind.MappingJsonFactory"%><%
    CuentaBancariaDAO cuentaBancariaDAO = new CuentaBancariaDAOImpHibernate();
    ObjectMapper jackson = new ObjectMapper();
    String json = jackson.writeValueAsString(cuentaBancariaDAO.findAll());
    response.setContentType("aplication/json; charset=UTF-8");
    out.print(json);
%>