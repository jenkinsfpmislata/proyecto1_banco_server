<%@page import="com.fpmislata.banco.modelo.SucursalBancaria"%><%@page import="com.fpmislata.banco.datos.SucursalBancariaDAOImpHibernate"%><%@page import="com.fpmislata.banco.datos.SucursalBancariaDAO"%><%@page import="com.fasterxml.jackson.databind.ObjectMapper"%><%@page import="com.fasterxml.jackson.databind.MappingJsonFactory"%><%
    SucursalBancariaDAO sucursalBancariaDAO = new SucursalBancariaDAOImpHibernate();
    SucursalBancaria sucursalBancaria = sucursalBancariaDAO.read(Integer.parseInt(request.getParameter("id")));
    ObjectMapper jackson = new ObjectMapper();
    String json = jackson.writeValueAsString(sucursalBancaria);
    response.setContentType("aplication/json; charset=UTF-8");
    out.print(json);
%>