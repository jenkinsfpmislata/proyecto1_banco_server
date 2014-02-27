/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author alumno
 */
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class TransaccionBancaria implements Serializable{
    @NotNull
    private String userTienda;
    @NotNull
    private String passwordTienda;
    private Double total;
    @NotNull
    @Size(min = 20, max = 20)
    private String codigoCuentaClienteOrigen;
    @NotNull
    @Size(min = 20, max = 20)
    private String codigoCuentaClienteDestino;
    @NotNull
    @Size(min = 10, max = 200)
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
