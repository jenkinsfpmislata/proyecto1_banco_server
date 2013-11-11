/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class CuentaBancaria {
    private int idCuentaBancaria;
    private SucursalBancaria sucursalBancaria;
    private String numeroCuenta;
    private String dc;
    private BigDecimal saldo;
    private String cif;
    private List <MovimientoBancario> ListaMovimientoBancario = new ArrayList();
    
    public CuentaBancaria(){
        
    }

    public int getCuentaBancaria() {
        return idCuentaBancaria;
    }

    public void setCuentaBancaria(int CuentaBancaria) {
        this.idCuentaBancaria = CuentaBancaria;
    }

    public SucursalBancaria getSucursal() {
        return sucursalBancaria;
    }

    public void setSucursal(SucursalBancaria sucursal) {
        this.sucursalBancaria = sucursal;
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

    public String getCifCuenta() {
        return cif;
    }

    public void setCifCuenta(String cifCuenta) {
        this.cif = cifCuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public SucursalBancaria getSucursalBancaria() {
        return sucursalBancaria;
    }

    public void setSucursalBancaria(SucursalBancaria sucursalBancaria) {
        this.sucursalBancaria = sucursalBancaria;
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

    public void setMovimientoBancario(List<MovimientoBancario> ListaMovimientoBancario) {
        this.ListaMovimientoBancario = ListaMovimientoBancario;
    }
    
}
