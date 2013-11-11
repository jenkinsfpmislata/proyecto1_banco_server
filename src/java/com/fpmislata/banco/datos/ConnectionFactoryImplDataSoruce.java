/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;
import javax.naming.InitialContext;
import java.sql.*;
import javax.sql.*;
/**
 *
 * @author alumno
 */
public class ConnectionFactoryImplDataSoruce implements ConnectionFactory{

    private static DataSource datasource = null;
    
    @Override
    public Connection getConnection(){
        try{
            InitialContext initialContext = new InitialContext();          
            datasource = (DataSource) initialContext.lookup("java:/comp/env/jdbc/banco");           

        return datasource.getConnection();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
