/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fpmislata.banco.datos.MovimientoBancarioDAO;
import com.fpmislata.banco.modelo.BussinesMessage;
import com.fpmislata.banco.modelo.MovimientoBancario;
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
public class MovimientosBancariosController {

    @Autowired
    private MovimientoBancarioDAO movimientoBancarioDAO;

    @RequestMapping(value = {"/MovimientoBancario/{idMovimientoBancario}"}, method = RequestMethod.GET)
    public void read(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idMovimientoBancario") int idMovimientoBancario) {
        try {
            ObjectMapper jackson = new ObjectMapper();
            String json = jackson.writeValueAsString(movimientoBancarioDAO.read(idMovimientoBancario));
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
    @RequestMapping(value = {"/MovimientosBancarios"}, method = RequestMethod.GET)
    public void readAll(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) {
        try {
            ObjectMapper jackson = new ObjectMapper();
            String json = jackson.writeValueAsString(movimientoBancarioDAO.findAll());
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

    @RequestMapping(value = {"/MovimientoBancario/{idMovimientoBancario}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idMovimientoBancario") int idMovimientoBancario) {
        try {
            movimientoBancarioDAO.delete(idMovimientoBancario);
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

    @RequestMapping(value = {"/MovimientoBancario/"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @RequestBody String json) throws JsonProcessingException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            MovimientoBancario movimientoBancario = (MovimientoBancario) objectMapper.readValue(json, MovimientoBancario.class);
            movimientoBancarioDAO.insert(movimientoBancario);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (ConstraintViolationException cve) {
            List<BussinesMessage> errorList = new ArrayList();
            ObjectMapper jackson = new ObjectMapper();
            System.out.println("No se ha podido insertar el movimiento bancario debido a los siguientes errores:");
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

    @RequestMapping(value = {"/MovimientoBancario/{idMovimientoBancario}"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idMovimientoBancario") int idMovimientoBancario, @RequestBody String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

            MovimientoBancario movimientoBancarioUpdate = movimientoBancarioDAO.read(idMovimientoBancario);
            MovimientoBancario movimientoBancario = (MovimientoBancario) objectMapper.readValue(json, MovimientoBancario.class);

            movimientoBancarioUpdate.setIdMovimientoBancario(movimientoBancario.getIdMovimientoBancario());
            movimientoBancarioUpdate.setConcepto(movimientoBancario.getConcepto());
            movimientoBancarioUpdate.setCuentaBancaria(movimientoBancario.getCuentaBancaria());
            movimientoBancarioUpdate.setFecha(movimientoBancario.getFecha());
            movimientoBancarioUpdate.setImporte(movimientoBancario.getImporte());
            movimientoBancarioUpdate.setSaldoTotal(movimientoBancario.getSaldoTotal());
            movimientoBancarioUpdate.setTipoMovimientoBancario(movimientoBancario.getTipoMovimientoBancario());

            movimientoBancarioDAO.update(movimientoBancarioUpdate);

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