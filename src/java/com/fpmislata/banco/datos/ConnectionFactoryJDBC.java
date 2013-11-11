/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author alumno
 */
public class ConnectionFactoryJDBC implements ConnectionFactory {

    private Connection connection;
    @Override
    public Connection getConnection(){
        try{
        Class.forName("com.mysql.jdbc.Driver");        
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "root");
        return connection;
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
