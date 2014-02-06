/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fpmislata.banco.datos.CuentaBancariaDAO;
import com.fpmislata.banco.datos.CuentaBancariaDAOImpHibernate;
import com.fpmislata.banco.datos.MovimientoBancarioDAO;
import com.fpmislata.banco.modelo.BussinesMessage;
import com.fpmislata.banco.modelo.CuentaBancaria;
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
    CuentaBancaria cuentaBancaria;
    CuentaBancariaDAO cuentaBancariaDAO = new CuentaBancariaDAOImpHibernate();

    @RequestMapping(value = {"/MovimientoBancario/{idMovimientoBancario}"}, method = RequestMethod.GET)
    public void read(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idMovimientoBancario") int idMovimientoBancario) {
        try {
            ObjectMapper jackson = new ObjectMapper();
            String json = jackson.writeValueAsString(movimientoBancarioDAO.read(idMovimientoBancario));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            noCache(httpServletResponse);
            httpServletResponse.getWriter().println(json);

        } catch (Exception ex) {
            noCache(httpServletResponse);
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                noCache(httpServletResponse);
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception ex1) {
                noCache(httpServletResponse);
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
            noCache(httpServletResponse);
            httpServletResponse.getWriter().println(json);

        } catch (Exception ex) {
            noCache(httpServletResponse);
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                noCache(httpServletResponse);
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception ex1) {
                noCache(httpServletResponse);
            }
        }


    }

    @RequestMapping(value = {"/MovimientoBancario/{idMovimientoBancario}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idMovimientoBancario") int idMovimientoBancario) {
        try {
            movimientoBancarioDAO.delete(idMovimientoBancario);
            noCache(httpServletResponse);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception ex) {
            noCache(httpServletResponse);
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                noCache(httpServletResponse);
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception ex1) {
                noCache(httpServletResponse);
            }
        }
    }

    @RequestMapping(value = {"/MovimientoBancario/{idCuentaBancaria}"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idCuentaBancaria") int idCuentaBancaria, @RequestBody String json) throws JsonProcessingException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

            MovimientoBancario movimientoBancario = (MovimientoBancario) objectMapper.readValue(json, MovimientoBancario.class);

            cuentaBancaria = cuentaBancariaDAO.read(idCuentaBancaria);
            movimientoBancario.setCuentaBancaria(cuentaBancaria);

            movimientoBancarioDAO.actualizarSaldo(cuentaBancaria, movimientoBancario);
            movimientoBancarioDAO.insert(movimientoBancario);

            noCache(httpServletResponse);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (ConstraintViolationException cve) {
            List<BussinesMessage> errorList = new ArrayList();
            ObjectMapper jackson = new ObjectMapper();
            System.out.println("No se ha podido insertar el movimiento bancario debido a los siguientes errores:");
            for (ConstraintViolation constraintViolation : cve.getConstraintViolations()) {
                String datos = constraintViolation.getPropertyPath().toString();
                String mensage = constraintViolation.getMessage();

                BussinesMessage bussinesMessage = new BussinesMessage(datos, mensage);
                errorList.add(bussinesMessage);
            }
            String jsonInsert = jackson.writeValueAsString(errorList);
            noCache(httpServletResponse);
            httpServletResponse.setStatus(httpServletResponse.SC_BAD_REQUEST);
        } catch (Exception ex) {
            noCache(httpServletResponse);
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                noCache(httpServletResponse);
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception ex1) {
                noCache(httpServletResponse);
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
            movimientoBancarioUpdate.setTipoMovimientoBancario(movimientoBancario.getTipoMovimientoBancario());

            movimientoBancarioDAO.update(movimientoBancarioUpdate);
            noCache(httpServletResponse);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(json);
        } catch (Exception ex) {
            noCache(httpServletResponse);
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                noCache(httpServletResponse);
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception ex1) {
                noCache(httpServletResponse);
            }
        }
    }

    @RequestMapping(value = {"/CuentaBancaria/{idCuentaBancaria}/MovimientosBancarios"}, method = RequestMethod.GET)
    public void readMovimientosPorCuenta(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idCuentaBancaria") String idCuentaBancaria) {
        try {
            ObjectMapper jackson = new ObjectMapper();
            String json = jackson.writeValueAsString(movimientoBancarioDAO.findByCuenta(idCuentaBancaria));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            noCache(httpServletResponse);
            httpServletResponse.getWriter().println(json);

        } catch (Exception ex) {
            noCache(httpServletResponse);
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                noCache(httpServletResponse);
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception ex1) {
                noCache(httpServletResponse);
            }
        }
    }

    private void noCache(HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Cache-Control", "no-cache");
    }
}