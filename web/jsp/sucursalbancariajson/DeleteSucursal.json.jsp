<%@page import="com.fpmislata.banco.datos.SucursalBancariaDAOImpHibernate"%><%@page import="com.fpmislata.banco.datos.SucursalBancariaDAO"%><%@page import="com.fpmislata.banco.modelo.SucursalBancaria"%><%@page import="com.fasterxml.jackson.databind.ObjectMapper"%><%
    SucursalBancariaDAO sucursalBancariaDAO = new SucursalBancariaDAOImpHibernate();
    sucursalBancariaDAO.delete(Integer.parseInt(request.getParameter("id")));
    ObjectMapper jackson = new ObjectMapper();
    String json = jackson.writeValueAsString(null);
    response.setContentType("aplication/json; charset=UTF-8");
    out.print(json);
%>
