<%@page import="com.fpmislata.banco.datos.MovimientoBancarioDAOImpHibernate"%><%@page import="com.fpmislata.banco.datos.MovimientoBancarioDAO"%><%@page import="com.fasterxml.jackson.databind.ObjectMapper"%><%
    MovimientoBancarioDAO movimientoBancarioDAO = new MovimientoBancarioDAOImpHibernate();
    movimientoBancarioDAO.delete(Integer.parseInt(request.getParameter("id")));
    ObjectMapper jackson = new ObjectMapper();
    String json = jackson.writeValueAsString(null);
    response.setContentType("aplication/json; charset=UTF-8");
    out.print(json);
%>
