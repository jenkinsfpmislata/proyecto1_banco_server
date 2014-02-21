/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fpmislata.banco.datos.CuentaBancariaDAO;
import com.fpmislata.banco.datos.CuentaBancariaDAOImpHibernate;
import java.io.Serializable;
import java.util.List;
import org.jasypt.util.password.BasicPasswordEncryptor;

/**
 *
 * @author alumno
 */
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Usuario implements Serializable {

    private int idUsuario;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String correoElectronico;
    private String direccion;
    private TipoUsuario tipoUsuario;
    private String username;
    private String password;

    public Usuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPassword(String unEncryptedPassword) {
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        if (passwordEncryptor.checkPassword(unEncryptedPassword, password)) {
            return true;
        } else {
            return false;
        }
    }
    
    public Double totalSaldoCuentas(){
        CuentaBancariaDAO cuentaBancariaDAO = new CuentaBancariaDAOImpHibernate();
        List<CuentaBancaria> listaCuentas = cuentaBancariaDAO.findByUser(idUsuario);
        Double saldoTotal = 0.0;
        for (CuentaBancaria cuentaBancaria : listaCuentas) {
            saldoTotal = saldoTotal + cuentaBancaria.getSaldo();
        }
        return saldoTotal;
    }
}
