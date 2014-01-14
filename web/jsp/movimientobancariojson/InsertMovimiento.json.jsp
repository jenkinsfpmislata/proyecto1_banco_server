<%@page import="com.fpmislata.banco.modelo.TipoMovimientoBancario"%><%@page import="java.sql.Date"%><%@page import="com.fpmislata.banco.datos.CuentaBancariaDAOImpHibernate"%><%@page import="com.fpmislata.banco.datos.CuentaBancariaDAO"%><%@page import="com.fpmislata.banco.modelo.MovimientoBancario"%><%@page import="com.fpmislata.banco.datos.MovimientoBancarioDAOImpHibernate"%><%@page import="com.fpmislata.banco.datos.MovimientoBancarioDAO"%><%@page import="com.fasterxml.jackson.databind.ObjectMapper"%><%@page import="com.fasterxml.jackson.databind.MappingJsonFactory"%><%
    MovimientoBancarioDAO movimientoBancarioDAO = new MovimientoBancarioDAOImpHibernate();
    CuentaBancariaDAO cuentaBancariaDAO = new CuentaBancariaDAOImpHibernate();
    MovimientoBancario movimientoBancario = new MovimientoBancario();
        
        movimientoBancario.setConcepto(request.getParameter("concepto"));
        movimientoBancario.setCuentaBancaria(cuentaBancariaDAO.read(Integer.parseInt(request.getParameter("cuenta"))));
        movimientoBancario.setFecha(Date.valueOf(request.getParameter("fecha")));
        movimientoBancario.setIdMovimientoBancario(Integer.parseInt(request.getParameter("id")));
        movimientoBancario.setImporte(Double.parseDouble(request.getParameter("importe")));
        movimientoBancario.setSaldoTotal(Double.parseDouble(request.getParameter("saldototal")));
        movimientoBancario.setTipoMovimientoBancario(TipoMovimientoBancario.valueOf(request.getParameter("tipo")));
    
        movimientoBancarioDAO.insert(movimientoBancario);
        ObjectMapper jackson = new ObjectMapper();
        String json = jackson.writeValueAsString(null);
    response.setContentType("aplication/json; charset=UTF-8");
    out.print(json);
%>