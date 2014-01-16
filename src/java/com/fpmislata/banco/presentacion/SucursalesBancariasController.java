/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fpmislata.banco.datos.SucursalBancariaDAO;
import com.fpmislata.banco.modelo.BussinesMessage;
import com.fpmislata.banco.modelo.SucursalBancaria;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author alumno
 */
@Controller
public class SucursalesBancariasController {

    @Autowired
    private SucursalBancariaDAO sucursalBancariaDAO;

    @RequestMapping(value = {"/SucursalBancaria/{idSucursalBancaria}"}, method = RequestMethod.GET)
    public void read(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idSucursalBancaria") int idSucursalBancaria) {
        try {
            ObjectMapper jackson = new ObjectMapper();
            String json = jackson.writeValueAsString(sucursalBancariaDAO.read(idSucursalBancaria));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");

            httpServletResponse.getWriter().println(json);

        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception ex1) {
            }
        }


    }

    @RequestMapping(value = {"/SucursalBancaria/{idSucursalBancaria}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idSucursalBancaria") int idSucursalBancaria) {
        try {
            sucursalBancariaDAO.delete(idSucursalBancaria);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception ex1) {
            }
        }
    }

    @RequestMapping(value = {"/SucursalBancaria/"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @RequestBody String json) throws JsonProcessingException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            SucursalBancaria sucursalBancaria = (SucursalBancaria) objectMapper.readValue(json, SucursalBancaria.class);
            sucursalBancariaDAO.insert(sucursalBancaria);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (ConstraintViolationException cve) {
            List<BussinesMessage> errorList = new ArrayList();
            ObjectMapper jackson = new ObjectMapper();
            System.out.println("No se ha podido insertar la Sucursal Bancaria debido a los siguientes errores:");
            for (ConstraintViolation constraintViolation : cve.getConstraintViolations()) {
               String datos = constraintViolation.getPropertyPath().toString();
               String mensage = constraintViolation.getMessage();
               
               BussinesMessage bussinesMessage = new BussinesMessage(datos,mensage);
               errorList.add(bussinesMessage);
            }
            String jsonInsert = jackson.writeValueAsString(errorList);
            httpServletResponse.setStatus(httpServletResponse.SC_BAD_REQUEST);
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception ex1) {
            }
        }
    }

    @RequestMapping(value = {"/SucursalBancaria/{idSucursalBancaria}"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idSucursalBancaria") int idSucursalBancaria, @RequestBody String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

            SucursalBancaria SucursalBancariaUpdate = sucursalBancariaDAO.read(idSucursalBancaria);
            SucursalBancaria sucursalBancaria = (SucursalBancaria) objectMapper.readValue(json, SucursalBancaria.class);

            SucursalBancariaUpdate.setIdSucursalBancaria(sucursalBancaria.getIdSucursalBancaria());
            SucursalBancariaUpdate.setCodigoSucursal(sucursalBancaria.getCodigoSucursal());
            SucursalBancariaUpdate.setEntidadBancaria(sucursalBancaria.getEntidadBancaria());
            SucursalBancariaUpdate.setNombreSucursal(sucursalBancaria.getNombreSucursal());
            SucursalBancariaUpdate.setListaCuentaBancaria(sucursalBancaria.getListaCuentaBancaria());

            sucursalBancariaDAO.update(SucursalBancariaUpdate);

            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(json);
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception ex1) {
            }
        }
    }
}