/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import com.fpmislata.banco.modelo.Credito;
import com.fpmislata.banco.modelo.CuentaBancaria;
import com.fpmislata.banco.modelo.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author iSidous
 */
public class CreditoDAOImpHibernate extends GenericDAOImpHibernate<Credito, Integer> implements CreditoDAO {
    
    CuentaBancariaDAO cuentaBancariaDAO = new CuentaBancariaDAOImpHibernate();
    
    @Override
    public boolean comprobarCredito(Usuario usuario) {
        int idUsuario = usuario.getIdUsuario();
        boolean ok = true;
        List <CuentaBancaria> listaCuentas = cuentaBancariaDAO.findByUser(idUsuario);
        
        if (listaCuentas != null) {
            for (CuentaBancaria cuentaBancaria : listaCuentas) {
                if (cuentaBancaria.getSaldo() < 0) {
                    ok = false;
                }
            }            
        }else{
         ok = false;   
        }      
        return ok;
    }
}
