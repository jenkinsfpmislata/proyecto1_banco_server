<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpHibernate"%><%@page import="com.fpmislata.banco.datos.EntidadBancariaDAO"%><%@page import="com.fpmislata.banco.modelo.SucursalBancaria"%><%@page import="com.fpmislata.banco.datos.SucursalBancariaDAOImpHibernate"%><%@page import="com.fpmislata.banco.datos.SucursalBancariaDAO"%><%@page import="com.fasterxml.jackson.databind.ObjectMapper"%><%@page import="com.fasterxml.jackson.databind.MappingJsonFactory"%><%
    SucursalBancariaDAO sucursalBancariaDAO = new SucursalBancariaDAOImpHibernate();
    EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImpHibernate();
    SucursalBancaria sucursalBancaria = new SucursalBancaria();
    
        sucursalBancaria.setCodigoSucursal(request.getParameter("codigo"));
        sucursalBancaria.setEntidadBancaria(entidadBancariaDAO.read(Integer.parseInt(request.getParameter("id"))));
        sucursalBancaria.setIdSucursalBancaria(Integer.parseInt(request.getParameter("id")));
        sucursalBancaria.setNombreSucursal(request.getParameter("nombre"));
        
        sucursalBancariaDAO.insert(sucursalBancaria);
        ObjectMapper jackson = new ObjectMapper();
        String json = jackson.writeValueAsString(null);
    response.setContentType("aplication/json; charset=UTF-8");
    out.print(json);
%>