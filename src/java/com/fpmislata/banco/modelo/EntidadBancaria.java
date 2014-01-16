/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author alumno
 */
@JsonIgnoreProperties({ "handler" ,"hibernateLazyInitializer"})
public class EntidadBancaria implements Serializable{

    private int idEntidad;
    @NotNull
    @Size(min = 4, max = 4)
    private String codigoEntidadBancaria;
    private String nombre;
    @NotNull
    @Size(min = 4, max = 9)
    private String cif;
    private TipoEntidadBancaria tipo;
    private List<SucursalBancaria> ListaSucursalBancaria = new ArrayList();

    public EntidadBancaria() {
    }

    public EntidadBancaria(int idEntidad, String codigoEntidadBancaria, String nombre, String cif, TipoEntidadBancaria tipo) {
        this.idEntidad = idEntidad;
        this.codigoEntidadBancaria = codigoEntidadBancaria;
        this.nombre = nombre;
        this.cif = cif;
        this.tipo = tipo;
    }

    public int getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public TipoEntidadBancaria getTipo() {
        return tipo;
    }

    public void setTipo(TipoEntidadBancaria tipo) {
        this.tipo = tipo;
    }

    public String getCodigoEntidadBancaria() {
        return codigoEntidadBancaria;
    }

    public void setCodigoEntidadBancaria(String codigoEntidadBancaria) {
        this.codigoEntidadBancaria = codigoEntidadBancaria;
    }

    public List<SucursalBancaria> getListaSucursalBancaria() {
        return ListaSucursalBancaria;
    }

    public void setListaSucursalBancaria(List<SucursalBancaria> ListaSucursalBancaria) {
        this.ListaSucursalBancaria = ListaSucursalBancaria;
    }
    
}
