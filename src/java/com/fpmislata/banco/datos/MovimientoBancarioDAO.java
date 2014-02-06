/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import com.fpmislata.banco.modelo.CuentaBancaria;
import com.fpmislata.banco.modelo.MovimientoBancario;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface MovimientoBancarioDAO extends GenericDAO<MovimientoBancario, Integer>{

    public List<MovimientoBancario> findByCuenta(String idCuentaBancaria);
    
    public void actualizarSaldo(CuentaBancaria cuentaBancaria, MovimientoBancario movimientoBancario);
    
}
