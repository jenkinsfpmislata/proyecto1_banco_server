/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import com.fpmislata.banco.modelo.CuentaBancaria;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface CuentaBancariaDAO extends GenericDAO<CuentaBancaria, Integer> {

    public CuentaBancaria findByCodigo(String idCuentaBancaria);

    public List<CuentaBancaria> findByUser(int idUsuario);
}
