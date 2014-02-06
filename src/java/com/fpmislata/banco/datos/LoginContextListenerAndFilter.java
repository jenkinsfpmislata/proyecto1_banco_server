/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

//======================= AUN NO FUNCIONAL =============================//
public class LoginContextListenerAndFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

 @Override
     public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {          
            Integer idUsuario=(Integer)((HttpServletRequest)servletRequest).getSession().getAttribute("idUsuario");
            if (checkSeguridad(idUsuario,servletRequest)==true) {         
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                //Prohibido
            }
         }catch(Exception exception){
             exception.printStackTrace();
         }
     }

    private boolean checkSeguridad(Integer idUsuario, ServletRequest servletRequest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
    }
}

//======================= AUN NO FUNCIONAL =============================//
