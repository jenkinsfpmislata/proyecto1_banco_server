/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import com.fpmislata.banco.modelo.Usuario;

/**
 *
 * @author alumno
 */
public interface UsuarioDAO extends GenericDAO<Usuario,Integer>{
    public Usuario readByUsername(String username);
}
