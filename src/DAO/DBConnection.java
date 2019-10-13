package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBConnection {
    
    private static final String URL = "jdbc:postgresql:db_livraria";
    private static final String USER = "postgres";
    private static final String PASS = "123456";
    
    public static Connection getConnection(){
        try{
             
            Connection c = DriverManager.getConnection(URL, USER, PASS);
            
            return c;
            
        } catch(SQLException e){
            throw new RuntimeException(e);
        } 
        
    }
    
}