/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import com.fpmislata.banco.modelo.MovimientoBancario;
import com.fpmislata.banco.modelo.SucursalBancaria;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alumno
 */
public class MovimientoBancarioDAOImpHibernate extends GenericDAOImpHibernate<MovimientoBancario, Integer> implements MovimientoBancarioDAO {

    @Override
    public List<MovimientoBancario> findByCuenta(String idCuentaBancaria) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT movimientoBancario FROM MovimientoBancario movimientoBancario WHERE idCuentaBancaria = ?");
        query.setString(0, idCuentaBancaria);

        List<MovimientoBancario> movimientosBancarios = query.list();

        session.getTransaction().commit();
        return movimientosBancarios;
    }

}
