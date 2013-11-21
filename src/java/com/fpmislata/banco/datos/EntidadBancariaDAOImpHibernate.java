/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import com.fpmislata.banco.modelo.EntidadBancaria;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author alumno
 */
public class EntidadBancariaDAOImpHibernate extends GenericDAOImpHibernate<EntidadBancaria,Integer> implements EntidadBancariaDAO{

    @Override
            public List<EntidadBancaria> findByCodigo(String codigo) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT entidadBancaria FROM EntidadBancaria entidadBancaria WHERE codigoEntidadBancaria = ?");
        query.setString(0, codigo);
        
        List<EntidadBancaria> entidadesBancarias = query.list();
        
        session.getTransaction().commit();
        return entidadesBancarias;
    }

    @Override
        public List<EntidadBancaria> findByNombre(String nombre) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT entidadBancaria FROM EntidadBancaria entidadBancaria WHERE nombre LIKE ?");
        query.setString(0, "%"+nombre+"%");
        
        List<EntidadBancaria> entidadesBancarias = query.list();
        
        session.getTransaction().commit();
        return entidadesBancarias;
    }
}
