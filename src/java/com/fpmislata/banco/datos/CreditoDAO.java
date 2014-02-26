/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpmislata.banco.datos;

import com.fpmislata.banco.modelo.Credito;
import com.fpmislata.banco.modelo.Usuario;

/**
 *
 * @author iSidous
 */
public interface CreditoDAO extends GenericDAO<Credito, Integer>{
    public boolean comprobarCredito(Usuario usuario);
}
