/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import java.io.IOException;
import javax.servlet.*;

/**
 *
 * @author alumno
 */
public class HibernateContextListenerAndFilter implements Filter,ServletContextListener {

     @Override
     public void contextInitialized(ServletContextEvent sce) {
         HibernateUtil.buildSessionFactory();
     }

     @Override
     public void init(FilterConfig filterConfig) throws ServletException {
     }

     @Override
     public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            HibernateUtil.openSessionAndBindToThread();
            filterChain.doFilter(servletRequest, servletResponse);
         } finally {
             HibernateUtil.closeSessionAndUnbindFromThread();
         }
     }

     @Override
     public void destroy() {
     }

     @Override
     public void contextDestroyed(ServletContextEvent sce) {
         HibernateUtil.closeSessionAndUnbindFromThread();
     }
     
 }
