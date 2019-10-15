package DAO;

import Model.Authors;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorsDAO extends DAO {
    
    public void saveAuthor(Authors anAuthor) throws SQLException{
        
        String insert = "INSERT INTO authors (name, fname) VALUES (?,?)";
        save(insert, anAuthor.getNameAuthor(), anAuthor.getfNameAuthor());
        
    }
    
    public void updateAuthor(Authors anAuthor) throws SQLException{
        
        String update = "UPDATE authors " + "SET name = ?, fname = ? " +
                "WHERE author_id = ?";
        update(update, anAuthor.getNameAuthor(), anAuthor.getfNameAuthor(), anAuthor.getAuthorId());
    }
    
    public void deleteAuthor(int id) throws SQLException{
        
        String delete = "DELETE FROM authors WHERE author_id = ?";
        
        delete(delete, id);
    }
    
    public List findAuthors() throws SQLException{
        
        List authors = new ArrayList();
        
        String select = "SELECT * FROM authors";
        
        try (PreparedStatement stmt = getConnection().prepareStatement(select)) {
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Authors author = new Authors();
                author.setAuthorId(rs.getInt("author_id"));
                author.setNameAuthor(rs.getString("name"));
                author.setfNameAuthor(rs.getString("fname"));
                authors.add(author);
            }
            
            rs.close();
        }
        getConnection().close();
        
        return authors;
    }
    
    public Authors findByName (String aName) throws SQLException{
        
        String select = "SELECT * FROM authors WHERE name = ?";
        Authors author = null;
        try (PreparedStatement stmt = getConnection().prepareStatement(select)) {
            stmt.setString(1, aName);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                author = new Authors();
                author.setAuthorId(rs.getInt("author_id"));
                author.setNameAuthor(rs.getString("name"));
                author.setfNameAuthor(rs.getString("fname"));
                
            }
            
            rs.close();
        }
        getConnection().close();
        
        return author;
    }
    
}
