/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import com.fpmislata.banco.modelo.EntidadBancaria;
import com.fpmislata.banco.modelo.Login;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alumno
 */
public class LoginDAOImplHibernate extends GenericDAOImpHibernate<Login, Integer> implements LoginDAO {

    @Override
    public boolean verificarLogin(Login login) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT login FROM Login login WHERE username = ? AND password = ?");
        query.setString(0, login.getUsername());
        query.setString(1, login.getPassword());
        
        List<Login> loginList = query.list();
        Login loginUser = loginList.get(0);
        session.getTransaction().commit();
        
        if (loginUser != null) {
            return true;
        }else{
            return false;
        }
        
    }
    
}
