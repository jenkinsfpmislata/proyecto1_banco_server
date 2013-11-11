/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import com.fpmislata.banco.modelo.EntidadBancaria;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface GenericDAO<T, ID> {

    public T read(ID id);

    public void insert(T tipo);

    public void update(T Tipo);

    public void delete(ID id);

    public List<T> findAll();
}
