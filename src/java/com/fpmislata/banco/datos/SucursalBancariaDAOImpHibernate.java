/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import com.fpmislata.banco.modelo.EntidadBancaria;
import com.fpmislata.banco.modelo.SucursalBancaria;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alumno
 */
public class SucursalBancariaDAOImpHibernate extends GenericDAOImpHibernate<SucursalBancaria, Integer> implements SucursalBancariaDAO{

    @Override
    public List<SucursalBancaria> findByNombre(String nombreSucursal) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT sucursalBancaria FROM SucursalBancaria sucursalBancaria WHERE nombreSucursal LIKE ?");
        query.setString(0, "%"+nombreSucursal+"%");
        
        List<SucursalBancaria> sucursalesBancarias = query.list();
        
        session.getTransaction().commit();
        return sucursalesBancarias;
    }

    @Override
    public List<SucursalBancaria> findByEntidad(String idEntidad) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT sucursalBancaria FROM SucursalBancaria sucursalBancaria WHERE idEntidadBancaria = ?");
        query.setString(0, idEntidad);
        
        List<SucursalBancaria> sucursalesBancarias = query.list();
        
        session.getTransaction().commit();
        return sucursalesBancarias;    
    }
    
}
