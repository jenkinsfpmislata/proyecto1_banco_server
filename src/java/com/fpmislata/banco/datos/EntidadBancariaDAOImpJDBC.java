/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import com.fpmislata.banco.modelo.EntidadBancaria;
import com.fpmislata.banco.modelo.TipoEntidadBancaria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author alumno
 */
public class EntidadBancariaDAOImpJDBC{

    ConnectionFactory connectionFactory = new ConnectionFactoryImplDataSoruce();

    public EntidadBancariaDAOImpJDBC(){
    }

    public EntidadBancaria read(int idEntidadBancaria){
       try{
        String selectEntidad = "SELECT * FROM entidadbancaria where identidad = ?;";
        EntidadBancaria entidadBancaria;
        Connection connection = connectionFactory.getConnection();

        PreparedStatement prepared = connection.prepareStatement(selectEntidad);
        prepared.setInt(1, idEntidadBancaria);
        ResultSet result = prepared.executeQuery();
        if (result.next() == true) {
            int idEntidad = result.getInt("idEntidad");
            String codigoEntidad = result.getString("codigoEntidad");
            String nombre = result.getString("nombre");
            String cif = result.getString("cif");
            String tipoEntidadBancaria = result.getString("tipoEntidadBancaria");

            entidadBancaria = new EntidadBancaria();

            entidadBancaria.setIdEntidad(idEntidad);
            entidadBancaria.setNombre(nombre);
            entidadBancaria.setCodigoEntidadBancaria(codigoEntidad);
            entidadBancaria.setCif(cif);
            entidadBancaria.setTipo(TipoEntidadBancaria.valueOf(tipoEntidadBancaria));
            if (result.next() == true) {
                throw new RuntimeException("Hay mas de una sucursal con ese ID");
            }
        } else {
            entidadBancaria = null;
        }
        return entidadBancaria;
       }catch(Exception ex){
           throw new RuntimeException(ex);
       }
    }

    public void insert(EntidadBancaria entidadBancaria){
        try{
            String insertEntidad = "INSERT INTO entidadBancaria values(?,?,?,?,?)";
        
        Connection connection = connectionFactory.getConnection();
        PreparedStatement prepared = null;
        prepared = connection.prepareStatement(insertEntidad);
        prepared.setInt(1, entidadBancaria.getIdEntidad());
        prepared.setString(2, entidadBancaria.getCodigoEntidadBancaria());
        prepared.setString(3, entidadBancaria.getNombre());
        prepared.setString(4, entidadBancaria.getCif());
        prepared.setString(5, entidadBancaria.getTipo().name());
        prepared.executeUpdate();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public void update(EntidadBancaria entidadBancaria){
        try{
        String updateEntidad = "UPDATE entidadbancaria set codigoEntidad = ?, nombre = ?, cif = ?, tipoEntidadBancaria = ? where idEntidad = ?";
        Connection connection = connectionFactory.getConnection();
        PreparedStatement prepared = null;
        prepared = connection.prepareStatement(updateEntidad);
        prepared.setString(1, entidadBancaria.getCodigoEntidadBancaria());
        prepared.setString(2, entidadBancaria.getNombre());
        prepared.setString(3, entidadBancaria.getCif());
        prepared.setString(4, entidadBancaria.getTipo().name());
        prepared.setInt(5, entidadBancaria.getIdEntidad());
        prepared.executeUpdate();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public void delete(int idEntidadBancaria){
        try{
        String deleteEntidad = "DELETE FROM entidadBancaria where idEntidad = ?";
        Connection connection = connectionFactory.getConnection();
        PreparedStatement prepared = null;
        prepared = connection.prepareStatement(deleteEntidad);
        prepared.setInt(1, idEntidadBancaria);
        int afectadas = prepared.executeUpdate();
        if (afectadas > 1) {
            throw new RuntimeException("Se ha eliminado mas de una fila");
        }
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public List<EntidadBancaria> findAll(){
        try{
        List<EntidadBancaria> ListaEntidades;

        Connection connection = connectionFactory.getConnection();
        ListaEntidades = new ArrayList();
        String selectTodasEntidades = "SELECT * from EntidadBancaria";
        PreparedStatement prepared = null;
        prepared = connection.prepareStatement(selectTodasEntidades);

        ResultSet result = prepared.executeQuery();
        while (result.next()) {
            EntidadBancaria entidadBancaria = new EntidadBancaria();

            entidadBancaria.setIdEntidad(result.getInt("idEntidad"));
            entidadBancaria.setCodigoEntidadBancaria(result.getString("codigoEntidad"));
            entidadBancaria.setNombre(result.getString("nombre"));
            entidadBancaria.setCif(result.getString("cif"));
            entidadBancaria.setTipo(TipoEntidadBancaria.valueOf(result.getString("tipoEntidadBancaria")));

            ListaEntidades.add(entidadBancaria);
        }
        return ListaEntidades;
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }

    }

    public List<EntidadBancaria> findByCodigo(String codigo){
       try{
        List<EntidadBancaria> ListaEntidades;
        Connection connection = connectionFactory.getConnection();
        ListaEntidades = new ArrayList();
        String buscarPorCodigo = "SELECT * FROM entidadbancaria where codigoEntidad = ?";
        PreparedStatement prepared = null;
        prepared = connection.prepareStatement(buscarPorCodigo);
        prepared.setString(1, codigo);
        ResultSet result = prepared.executeQuery();
        while (result.next()) {
            EntidadBancaria entidadBancaria = new EntidadBancaria();

            entidadBancaria.setIdEntidad(result.getInt("idEntidad"));
            entidadBancaria.setCodigoEntidadBancaria(result.getString("codigoEntidad"));
            entidadBancaria.setNombre(result.getString("nombre"));
            entidadBancaria.setCif(result.getString("cif"));
            entidadBancaria.setTipo(TipoEntidadBancaria.valueOf(result.getString("tipoEntidad")));


            ListaEntidades.add(entidadBancaria);

        }
        return ListaEntidades;
       }catch(Exception ex){
           throw new RuntimeException(ex);
       }
    }

    public List<EntidadBancaria> findByNombre(String nombre) {  
      try{  
          List<EntidadBancaria> listaEntidades;
          listaEntidades = new ArrayList();
        String selectEntidades = "SELECT * FROM entidadbancaria WHERE nombre LIKE ?";
        EntidadBancaria entidadBancaria;
        Connection connection = connectionFactory.getConnection();

        PreparedStatement prepared = connection.prepareStatement(selectEntidades);
        prepared.setString(1, "%"+nombre+"%");
        ResultSet result = prepared.executeQuery();
         while (result.next()) {
            entidadBancaria = new EntidadBancaria();
            
            entidadBancaria.setIdEntidad(result.getInt("idEntidad"));
            entidadBancaria.setCodigoEntidadBancaria(result.getString("codigoEntidad"));
            entidadBancaria.setNombre(result.getString("nombre"));
            entidadBancaria.setCif(result.getString("cif"));
            entidadBancaria.setTipo(TipoEntidadBancaria.valueOf(result.getString("tipoEntidadBancaria")));

            listaEntidades.add(entidadBancaria);
        }
        return listaEntidades;
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
