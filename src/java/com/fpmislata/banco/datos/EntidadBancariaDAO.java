/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import com.fpmislata.banco.modelo.EntidadBancaria;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author alumno
 */
public interface EntidadBancariaDAO extends GenericDAO<EntidadBancaria,Integer>{

    public List<EntidadBancaria> findByCodigo(String codigo);
    
    public List<EntidadBancaria> findByNombre(String nombre);
}
