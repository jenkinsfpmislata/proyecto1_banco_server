<%@page import="com.fpmislata.banco.datos.CuentaBancariaDAOImpHibernate"%><%@page import="com.fpmislata.banco.datos.CuentaBancariaDAO"%><%@page import="com.fasterxml.jackson.databind.ObjectMapper"%><%
    CuentaBancariaDAO cuentaBancariaDAO = new CuentaBancariaDAOImpHibernate();
    cuentaBancariaDAO.delete(Integer.parseInt(request.getParameter("id")));
    ObjectMapper jackson = new ObjectMapper();
    String json = jackson.writeValueAsString(null);
    response.setContentType("aplication/json; charset=UTF-8");
    out.print(json);
%>
