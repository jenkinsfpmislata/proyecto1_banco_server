<%@page import="com.fpmislata.banco.modelo.MovimientoBancario"%><%@page import="com.fpmislata.banco.datos.MovimientoBancarioDAOImpHibernate"%><%@page import="com.fpmislata.banco.datos.MovimientoBancarioDAO"%><%@page import="com.fasterxml.jackson.databind.ObjectMapper"%><%@page import="com.fasterxml.jackson.databind.MappingJsonFactory"%><%
    MovimientoBancarioDAO movimientoBancarioDAO = new MovimientoBancarioDAOImpHibernate();
    MovimientoBancario movimientoBancario = movimientoBancarioDAO.read(Integer.parseInt(request.getParameter("id")));
    ObjectMapper jackson = new ObjectMapper();
    String json = jackson.writeValueAsString(movimientoBancario);
    response.setContentType("aplication/json; charset=UTF-8");
    out.print(json);
%>