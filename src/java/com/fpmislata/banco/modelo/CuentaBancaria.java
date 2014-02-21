/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class CuentaBancaria {
    private int idCuentaBancaria;
    private SucursalBancaria sucursalBancaria;
    private Usuario usuario;
    private String numeroCuenta;
    private String dc;
    private double saldo;
    private String cif;
    private List <MovimientoBancario> ListaMovimientoBancario = new ArrayList();
    
    public CuentaBancaria(){
        
    }

    public int getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public void setIdCuentaBancaria(int idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public SucursalBancaria getSucursalBancaria() {
        return sucursalBancaria;
    }

    public void setSucursalBancaria(SucursalBancaria sucursalBancaria) {
        this.sucursalBancaria = sucursalBancaria;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public List<MovimientoBancario> getListaMovimientoBancario() {
        return ListaMovimientoBancario;
    }

    public void setListaMovimientoBancario(List<MovimientoBancario> ListaMovimientoBancario) {
        this.ListaMovimientoBancario = ListaMovimientoBancario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
