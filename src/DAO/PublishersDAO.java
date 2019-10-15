package DAO;

import Model.Publishers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PublishersDAO extends DAO {
    
    public void savePublisher(Publishers aPublisher) throws SQLException{
        
        String insert = "INSERT INTO publishers (name, url) VALUES (?,?)";
        save(insert, aPublisher.getNamePublisher(), aPublisher.getUrl());
        
    }
    
    public void updatePublisher(Publishers aPublisher) throws SQLException{
        
        String update = "UPDATE publishers " + "SET name = ?, url = ? " +
                "WHERE publisher_id = ?";
        update(update, aPublisher.getNamePublisher(), aPublisher.getUrl(), aPublisher.getPublisherId());
    }
    
    public void deletePublisher(Integer id) throws SQLException{
        
        String delete = "DELETE FROM publisher WHERE publisher_id = ?";
        
        delete(delete, id);
    }
    
    public List findPublishers() throws SQLException{
        
        List publishers = new ArrayList();
        
        String select = "SELECT * FROM publisher";
        
        try (PreparedStatement stmt = getConnection().prepareStatement(select)) {
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Publishers publisher = new Publishers();
                publisher.setPublisherId(rs.getInt("publisher_id"));
                publisher.setNamePublisher(rs.getString("name"));
                publisher.setUrl(rs.getString("url"));
                publishers.add(publisher);
            }
            
            rs.close();
        }
        getConnection().close();
        
        return publishers;
    }
    
    public Publishers findByPublisher (String aPublisher) throws SQLException{
        
        String select = "SELECT * FROM publishers WHERE name = ?";
        Publishers publisher = null;
        try (PreparedStatement stmt = getConnection().prepareStatement(select)) {
            stmt.setString(1, aPublisher);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                publisher = new Publishers();
                publisher.setPublisherId(rs.getInt("publisher_id"));
                publisher.setNamePublisher(rs.getString("name"));
                publisher.setUrl(rs.getString("url"));
                
            }
            
            rs.close();
        }
        getConnection().close();
        
        return publisher;
    }
    
    
}
