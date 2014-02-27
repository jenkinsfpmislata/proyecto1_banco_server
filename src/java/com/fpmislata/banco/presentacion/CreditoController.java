/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fpmislata.banco.datos.CreditoDAO;
import com.fpmislata.banco.datos.CreditoDAOImpHibernate;
import com.fpmislata.banco.datos.CuentaBancariaDAO;
import com.fpmislata.banco.datos.CuentaBancariaDAOImpHibernate;
import com.fpmislata.banco.datos.MovimientoBancarioDAO;
import com.fpmislata.banco.datos.MovimientoBancarioDAOImpHibernate;
import com.fpmislata.banco.modelo.BussinesMessage;
import com.fpmislata.banco.modelo.Credito;
import com.fpmislata.banco.modelo.CuentaBancaria;
import com.fpmislata.banco.modelo.MovimientoBancario;
import com.fpmislata.banco.modelo.TipoMovimientoBancario;
import java.util.ArrayList;
import java.util.Date;
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
 * @author iSidous
 */
@Controller
public class CreditoController {

    @RequestMapping(value = {"/Credito/{idCuentaBancaria}"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idCuentaBancaria") int idCuentaBancaria, @RequestBody String json) throws JsonProcessingException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            Credito credito = (Credito) objectMapper.readValue(json, Credito.class);

            CuentaBancariaDAO cuentaBancariaDAO = new CuentaBancariaDAOImpHibernate();
            CuentaBancaria cuentaBancaria = cuentaBancariaDAO.read(idCuentaBancaria);
            credito.setCuentaBancaria(cuentaBancaria);
            credito.setFecha(new Date());

            CreditoDAO creditoDAO = new CreditoDAOImpHibernate();
            boolean ok = creditoDAO.comprobarCredito(credito.getCuentaBancaria().getUsuario());

            if (ok) {
                // ======================= Credito ============================= //

                creditoDAO.insert(credito);

                // ======================= Movimiento ============================= //
                MovimientoBancarioDAO movimientoBancarioDAO = new MovimientoBancarioDAOImpHibernate();
                MovimientoBancario movimientoBancario = new MovimientoBancario();

                movimientoBancario.setConcepto("Credito Bitbank");
                movimientoBancario.setFecha(new Date());
                movimientoBancario.setImporte(credito.getImporte());
                movimientoBancario.setTipoMovimientoBancario(TipoMovimientoBancario.Haber);
                movimientoBancario.setCuentaBancaria(credito.getCuentaBancaria());

                movimientoBancarioDAO.insert(movimientoBancario);
                noCache(httpServletResponse);
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            } else {
                noCache(httpServletResponse);
                httpServletResponse.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
            }

        } catch (ConstraintViolationException cve) {
            List<BussinesMessage> errorList = new ArrayList();
            ObjectMapper jackson = new ObjectMapper();
            System.out.println("No se ha podido insertar la Cuenta Bancaria debido a los siguientes errores:");
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

    private void noCache(HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Cache-Control", "no-cache");
    }
}
