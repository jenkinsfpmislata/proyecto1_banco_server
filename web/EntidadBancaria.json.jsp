<%@page import="com.fpmislata.banco.modelo.TipoEntidadBancaria"%><%@page import="com.fasterxml.jackson.databind.ObjectMapper"%><%@page import="com.fasterxml.jackson.databind.MappingJsonFactory"%><%@page import="com.fpmislata.banco.modelo.EntidadBancaria"%><%
    EntidadBancaria entidadBancaria = new EntidadBancaria(4,"4864","Krusty","4403",TipoEntidadBancaria.banco);
    ObjectMapper jackson = new ObjectMapper();
    String json = jackson.writeValueAsString(entidadBancaria);
    response.setContentType("aplication/json; charset=UTF-8");
    out.print(json);
%>