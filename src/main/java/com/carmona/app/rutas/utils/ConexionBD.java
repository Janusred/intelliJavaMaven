package com.carmona.app.rutas.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static String url = "jdbc:oracle:thin:@//it-globalsolutions.com/VIS";

    private static String username = "apps";

    private  static String password = "apps";

    private Connection conn = null;

    //metodos
    public  Connection getInstance(){
        try{
            if(this.conn == null){
                ConexionBD c = new ConexionBD();
                c.conn = DriverManager.getConnection(url,username,password);
            }
            else {
                return  this.conn;
            }
            return  DriverManager.getConnection(url, username, password);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


}

