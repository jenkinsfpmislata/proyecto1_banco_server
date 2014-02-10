/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 *
 * @author alumno
 */
@WebFilter(filterName = "FilterSecurity", urlPatterns = {"/*"})
@Component(value = "FilterSecurity")
public class FilterSecurity implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        System.out.println("Estoy filtrando la URI " + httpServletRequest.getRequestURL());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
   
}
