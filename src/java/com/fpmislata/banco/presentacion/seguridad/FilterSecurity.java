/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion.seguridad;

import com.fpmislata.banco.datos.UsuarioDAO;
import com.fpmislata.banco.modelo.Usuario;
import java.io.IOException;
import java.net.URI;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author alumno
 */
public class FilterSecurity implements Filter {

    @Autowired
    UsuarioDAO usuarioDAO;
    
    @Autowired
    Autorizacion autorizacionCutre;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        
        URI uri = URI.create(httpServletRequest.getRequestURI());
        String username = (String)httpServletRequest.getSession().getAttribute("usuario");
        Usuario user = usuarioDAO.readByUsername(username);

        if (autorizacionCutre.allowURL(uri, user, httpServletRequest.getMethod())) {
            chain.doFilter(request, response);
        }else{
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.setStatus(httpServletResponse.SC_FORBIDDEN);
        }
    }

    @Override
    public void destroy() {
    }
}
