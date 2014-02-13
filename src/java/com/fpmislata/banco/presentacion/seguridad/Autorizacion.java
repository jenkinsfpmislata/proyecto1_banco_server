/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion.seguridad;

import com.fpmislata.banco.modelo.Usuario;
import java.net.URI;

/**
 *
 * @author alumno
 */
public interface Autorizacion {
    public boolean allowURL(URI uri, Usuario usuario, String metodo);
}
