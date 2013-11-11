/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class SucursalBancaria {

    private int idSucursalBancaria;
    private EntidadBancaria entidad;
    private String codigoSucursal;
    private String nombre;
    private List<CuentaBancaria> ListaCuentaBancaria = new ArrayList();

    public SucursalBancaria() {
    }

    public int getIdSucursalBancaria() {
        return idSucursalBancaria;
    }

    public void setIdSucursalBancaria(int idSucursalBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
    }

    public EntidadBancaria getEntidad() {
        return entidad;
    }

    public void setEntidad(EntidadBancaria entidad) {
        this.entidad = entidad;
    }

    public String getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<CuentaBancaria> getListaCuentaBancaria() {
        return ListaCuentaBancaria;
    }

    public void setListaCuentaBancaria(List<CuentaBancaria> ListaCuentaBancaria) {
        this.ListaCuentaBancaria = ListaCuentaBancaria;
    }
}
