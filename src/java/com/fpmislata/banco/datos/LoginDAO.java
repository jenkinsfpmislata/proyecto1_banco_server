/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import com.fpmislata.banco.modelo.Login;

/**
 *
 * @author alumno
 */
public interface LoginDAO extends GenericDAO<Login,Integer>{
    public boolean verificarLogin(Login login);
}
