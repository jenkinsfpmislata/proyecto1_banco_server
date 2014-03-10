/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fpmislata.banco.datos.CuentaBancariaDAO;
import com.fpmislata.banco.datos.MovimientoBancarioDAO;
import com.fpmislata.banco.datos.MovimientoBancarioDAOImpHibernate;
import com.fpmislata.banco.modelo.BussinesMessage;
import com.fpmislata.banco.modelo.CuentaBancaria;
import com.fpmislata.banco.modelo.MovimientoBancario;
import com.fpmislata.banco.modelo.TipoMovimientoBancario;
import com.fpmislata.banco.modelo.TransaccionBancaria;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author alumno
 */
@Controller
public class TrasaccionesBancariasController {

    @Autowired
    private CuentaBancariaDAO cuentaBancariaDAO;
    
    @Autowired
    private MovimientoBancarioDAO movimientoBancarioDAO;
    
   

@RequestMapping(value = {"/TransaccionBancaria"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @RequestBody String json) throws JsonProcessingException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            TransaccionBancaria transaccionBancaria = (TransaccionBancaria) objectMapper.readValue(json, TransaccionBancaria.class);
            
            
            CuentaBancaria cuentaBancariaOrigen = cuentaBancariaDAO.findByCodigo(transaccionBancaria.getCodigoCuentaClienteOrigen());
            CuentaBancaria cuentaBancariaDestino = cuentaBancariaDAO.findByCodigo(transaccionBancaria.getCodigoCuentaClienteDestino());
           
            /*-----------------------Origen---------------------------*/
            MovimientoBancario movimientoBancarioOrigen = new MovimientoBancario();
            
            movimientoBancarioOrigen.setCuentaBancaria(cuentaBancariaOrigen);
            movimientoBancarioOrigen.setTipoMovimientoBancario(TipoMovimientoBancario.Debe);
            movimientoBancarioOrigen.setImporte(transaccionBancaria.getTotal());
            movimientoBancarioOrigen.setFecha(new Date());
            movimientoBancarioOrigen.setConcepto(transaccionBancaria.getConcepto());
            
            movimientoBancarioDAO.insert(movimientoBancarioOrigen);
            
            /*-----------------------Destino---------------------------*/
            MovimientoBancario movimientoBancarioDestino = new MovimientoBancario();
            
            movimientoBancarioDestino.setCuentaBancaria(cuentaBancariaDestino);
            movimientoBancarioDestino.setTipoMovimientoBancario(TipoMovimientoBancario.Haber);
            movimientoBancarioDestino.setImporte(transaccionBancaria.getTotal());
            movimientoBancarioDestino.setFecha(new Date());
            movimientoBancarioDestino.setConcepto(transaccionBancaria.getConcepto());
            
            movimientoBancarioDAO.insert(movimientoBancarioDestino);
            
            noCache(httpServletResponse);
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
            jackson.writeValueAsString(errorList);
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
private void noCache(HttpServletResponse httpServletResponse){
      httpServletResponse.setHeader("Cache-Control", "no-cache");
  }
}
