/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import com.fpmislata.banco.modelo.CredencialesUsuario;
import com.fpmislata.banco.modelo.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alumno
 */
public class UsuarioDAOImplHibernate extends GenericDAOImpHibernate<Usuario, Integer> implements UsuarioDAO {

    @Override
    public Usuario readByUsername(String username) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT usuario FROM Usuario usuario WHERE username = ?");
        query.setString(0, username);

        List<Usuario> loginList = query.list();
        if (loginList.isEmpty()) {
            return null;
        } else {
            if (loginList.size() == 1) {
                Usuario usuario = loginList.get(0);
                return usuario;
            } else {
                return null;
            }
        }
    }
}
