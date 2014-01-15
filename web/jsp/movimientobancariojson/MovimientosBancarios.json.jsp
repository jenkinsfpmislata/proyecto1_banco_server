<%@page import="com.fpmislata.banco.datos.MovimientoBancarioDAOImpHibernate"%><%@page import="com.fpmislata.banco.datos.MovimientoBancarioDAO"%><%@page import="com.fasterxml.jackson.databind.ObjectMapper"%><%@page import="com.fasterxml.jackson.databind.MappingJsonFactory"%><%
    MovimientoBancarioDAO movimientoBancarioDAO = new MovimientoBancarioDAOImpHibernate();
    ObjectMapper jackson = new ObjectMapper();
    String json = jackson.writeValueAsString(movimientoBancarioDAO.findAll());
    response.setContentType("aplication/json; charset=UTF-8");
    out.print(json);
%>