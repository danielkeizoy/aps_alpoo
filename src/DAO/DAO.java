
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DAO {
    
    private Connection connection;
    
    protected DAO(){
        this.connection = DBConnection.getConnection();
    }
    
    protected Connection getConnection(){
        return connection;
    }
    
    protected void save(String insertSQLquery, Object... params) throws SQLException{
        
        try (PreparedStatement pstmt = getConnection().prepareStatement(insertSQLquery)) {
            for (int i = 0; i < params.length; i++){
                pstmt.setObject(i+1, params[i]);
            }
            
            pstmt.execute();
        }
        connection.close();
                
    }
    
    protected void update(String updateSQLquery, Object id, Object... parametros) throws SQLException {
        try (PreparedStatement pstmt = getConnection().prepareStatement(updateSQLquery)) {
            for (int i = 0; i < parametros.length; i++) {
                pstmt.setObject(i+1, parametros[i]);
            }
            pstmt.setObject(parametros.length + 1, id);
            pstmt.execute();
        }
        connection.close();
    }
    
    protected void delete(String deleteSQLquery, Object... parametros) throws SQLException {
        try (PreparedStatement pstmt = getConnection().prepareStatement(deleteSQLquery)) {
            for (int i = 0; i < parametros.length; i++) {
                pstmt.setObject(i+1, parametros[i]);
            }
            
            pstmt.execute();
        }
        connection.close();
    }
}
