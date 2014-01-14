<%@page import="com.fpmislata.banco.modelo.CuentaBancaria"%><%@page import="com.fpmislata.banco.datos.CuentaBancariaDAOImpHibernate"%><%@page import="com.fpmislata.banco.datos.CuentaBancariaDAO"%><%@page import="com.fasterxml.jackson.databind.ObjectMapper"%><%@page import="com.fasterxml.jackson.databind.MappingJsonFactory"%><%
    CuentaBancariaDAO cuentaBancariaDAO = new CuentaBancariaDAOImpHibernate();
    CuentaBancaria cuentaBancaria = cuentaBancariaDAO.read(Integer.parseInt(request.getParameter("id")));
    ObjectMapper jackson = new ObjectMapper();
    String json = jackson.writeValueAsString(cuentaBancaria);
    response.setContentType("aplication/json; charset=UTF-8");
    out.print(json);
%>