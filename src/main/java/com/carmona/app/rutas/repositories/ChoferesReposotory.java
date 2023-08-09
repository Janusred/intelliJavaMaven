package com.carmona.app.rutas.repositories;

import com.carmona.app.rutas.models.Chofer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ChoferesReposotory implements IRepository<Chofer>{


    private Connection conn;

    public ChoferesReposotory(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Chofer> lista() throws SQLException {
       List<Chofer> choferes = new ArrayList<>();
       try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CHOFERES")){
           while (rs.next()){
               Chofer a = this.getChofer(rs);
               choferes.add(a);
           }
       }catch (SQLException e){
           throw  new RuntimeException(e);
       }
       return choferes;
    }

    @Override
    public Chofer getById(Long id) throws SQLException {
        return null;
    }

    @Override
    public void guardar(Chofer chofer) throws SQLException {

    }

    @Override
    public void eliminar(Long id) throws SQLException {

    }
    private Chofer getChofer(ResultSet rs ) throws SQLException{
        Chofer a = new Chofer();
        a.setId(rs.getLong("ID_CHOFER"));
        a.setNombre(rs.getString("NOMBRE"));
        a.setApPaterno(rs.getString("AP_PATERNO"));
        a.setApMaterno(rs.getString("AP_MATERNO"));
        a.setLicencia(rs.getString("LICENCIA"));
        a.setFechaNacimiento(rs.getDate("FECHA?NACIMIENTO").toLocalDate());
        a.setDisponibilidad(rs.getBoolean("DISPONIBILIDAD"));
        return a;
    }
}
