package edu.b11.tp.tax.qs.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL_Connector {
    String host = "jdbc:mariadb://mysql-davidvillegas.alwaysdata.net:3306/";
    String dbname = "davidvillegas_canada_tax";
    String username = "356323";
    String password = "EpDeBdes34%";

    Connection con = null;

    // Singleton creation step 1 create instance
    private static SQL_Connector instance;

    // Singleton creation step 2 create constructor
    private SQL_Connector(){
        String url = host + dbname;
        try {
            con = DriverManager.getConnection(url, username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } // end constructor

    // Singleton creation step 3 create getInstance method
    public static SQL_Connector getInstance(){
        if (instance == null){
            instance = new SQL_Connector();
        }
        return instance;
    } // end getInstance

    public Connection getConnection(){
        return this.con;
    }
}
