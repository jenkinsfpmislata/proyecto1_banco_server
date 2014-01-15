<%@page import="com.fpmislata.banco.datos.SucursalBancariaDAOImpHibernate"%>
<%@page import="com.fpmislata.banco.datos.SucursalBancariaDAO"%>
<%@page import="com.fpmislata.banco.modelo.CuentaBancaria"%>
<%@page import="com.fpmislata.banco.datos.CuentaBancariaDAOImpHibernate"%>
<%@page import="com.fpmislata.banco.datos.CuentaBancariaDAO"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%><%@page import="com.fasterxml.jackson.databind.MappingJsonFactory"%><%
    CuentaBancariaDAO cuentaBancariaDAO = new CuentaBancariaDAOImpHibernate();
    SucursalBancariaDAO sucursalBancariaDAO = new SucursalBancariaDAOImpHibernate();
    CuentaBancaria cuentaBancaria = new CuentaBancaria();
    
        cuentaBancaria.setCif(request.getParameter("cif"));
        cuentaBancaria.setDc(request.getParameter("dc"));
        cuentaBancaria.setIdCuentaBancaria(Integer.parseInt(request.getParameter("id")));
        cuentaBancaria.setNumeroCuenta(request.getParameter("numeroCuenta"));
        cuentaBancaria.setSaldo(Double.parseDouble(request.getParameter("saldo")));
        cuentaBancaria.setSucursalBancaria(sucursalBancariaDAO.read(Integer.parseInt(request.getParameter("sucursal"))));
        
        cuentaBancariaDAO.insert(cuentaBancaria);
        ObjectMapper jackson = new ObjectMapper();
        String json = jackson.writeValueAsString(null);
    response.setContentType("aplication/json; charset=UTF-8");
    out.print(json);
%>