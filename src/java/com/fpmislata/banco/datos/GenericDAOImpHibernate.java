/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author alumno
 */
public class GenericDAOImpHibernate<T, ID> implements GenericDAO<T, ID> {
    
     SessionFactory sessionFactory;

    public GenericDAOImpHibernate() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T read(ID id) {

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        T object = (T) session.get(getEntityClass(), (Serializable) id);
        session.getTransaction().commit();
        return object;
    }

    @Override
    public void insert(T tipo) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        session.save(tipo); //<|--- Aqui guardamos el objeto en la base de datos.

        session.getTransaction().commit();
    }

    @Override
    public void update(T tipo) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        session.update(tipo); //<|--- Aqui guardamos el objeto en la base de datos.

        session.getTransaction().commit();
    }

    @Override
    public void delete(ID id) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        T object = (T) session.get(getEntityClass(), (Serializable) id);
        session.delete(object); //<|--- Aqui guardamos el objeto en la base de datos.
        session.getTransaction().commit();
    }

    @Override
    public List<T> findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT t FROM "+getEntityClass().getName()+" t");

        List<T> objectList = query.list();

        session.getTransaction().commit();
        return objectList;
    }
}
