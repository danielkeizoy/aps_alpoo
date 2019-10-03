package Controller;

import DAO.AuthorsDAO;
import Model.Authors;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;

public class AuthorsController {

    public void save(String nameAuthor, String fNameAuthor) throws SQLException, ParseException{
        
        Authors author = new Authors();
        author.setNameAuthor(nameAuthor);
        author.setfNameAuthor(fNameAuthor);
        
        new AuthorsDAO().saveAuthor(author);
    }
    
    public void update(Integer id, String nameAuthor, String fNameAuthor) throws ParseException, SQLException {
        
        Authors author = new Authors();
        author.setAuthorId(id);
        author.setNameAuthor(nameAuthor);
        author.setfNameAuthor(fNameAuthor);
        
        new AuthorsDAO().updateAuthor(author);
    } 
    
    public List authorsList(){
        
        AuthorsDAO dao = new AuthorsDAO();
        
        try {
            return dao.findAuthors();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "We have got some error trying to find authors" + ex.getLocalizedMessage());
        }
        
        return null;
    }
    
    public void delete(Integer id) throws SQLException {
        new AuthorsDAO().deleteAuthor(id);
    }
    
    public Authors findAuthorsByName(String aName) throws SQLException {
        AuthorsDAO dao = new AuthorsDAO();
        return dao.findByName(aName);
    }
    
}
