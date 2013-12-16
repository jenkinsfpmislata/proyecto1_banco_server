package com.fpmislata.banco.presentacion;

import com.fpmislata.banco.datos.EntidadBancariaDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
 public class PruebaController {

    @Autowired
    private EntidadBancariaDAO entidadBancariaDAO;

    @RequestMapping({"/prueba.json"})
     public void read(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().println("Hola mundo");
        } catch (IOException ex) {
            Logger.getLogger(PruebaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    };
}