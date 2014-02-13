/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author alumno
 */
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class TransaccionBancaria {

    private String userTienda;
    private String passwordTienda;
    private Double total;
    private String codigoCuentaClienteOrigen;
    private String codigoCuentaClienteDestino;
    private String concepto;

    public TransaccionBancaria() {
    }

    public TransaccionBancaria(String userTienda, String passwordTienda, Double total, String codigoCuentaClienteOrigen, String codigoCuentaClienteDestino) {
        this.userTienda = userTienda;
        this.passwordTienda = passwordTienda;
        this.total = total;
        this.codigoCuentaClienteOrigen = codigoCuentaClienteOrigen;
        this.codigoCuentaClienteDestino = codigoCuentaClienteDestino;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getUserTienda() {
        return userTienda;
    }

    public void setUserTienda(String userTienda) {
        this.userTienda = userTienda;
    }

    public String getPasswordTienda() {
        return passwordTienda;
    }

    public void setPasswordTienda(String passwordTienda) {
        this.passwordTienda = passwordTienda;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getCodigoCuentaClienteOrigen() {
        return codigoCuentaClienteOrigen;
    }

    public void setCodigoCuentaClienteOrigen(String codigoCuentaClienteOrigen) {
        this.codigoCuentaClienteOrigen = codigoCuentaClienteOrigen;
    }

    public String getCodigoCuentaClienteDestino() {
        return codigoCuentaClienteDestino;
    }

    public void setCodigoCuentaClienteDestino(String codigoCuentaClienteDestino) {
        this.codigoCuentaClienteDestino = codigoCuentaClienteDestino;
    }
}
