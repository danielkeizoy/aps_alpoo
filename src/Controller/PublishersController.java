package Controller;

import DAO.PublishersDAO;
import Model.Publishers;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;


public class PublishersController {
    
    
    public void save(String aPublisherName, String anURL) throws SQLException, ParseException{
        
        Publishers publisher = new Publishers();
        publisher.setNamePublisher(aPublisherName);
        publisher.setUrl(anURL);
        
        new PublishersDAO().savePublisher(publisher);
    }
    
    public void update(Integer id, String namePublisher, String anURL) throws ParseException, SQLException {
        
        Publishers publisher = new Publishers();
        publisher.setPublisherId(id);
        publisher.setNamePublisher(namePublisher);
        publisher.setUrl(anURL);
        
        new PublishersDAO().updatePublisher(publisher);
    } 
    
    public List publishersList(){
        
        PublishersDAO dao = new PublishersDAO();
        
        try {
            return dao.findPublishers();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "We have got some error trying to find publishers" + ex.getLocalizedMessage());
        }
        
        return null;
    }
    
    public void delete(Integer aPublisherID) throws SQLException {
        new PublishersDAO().deletePublisher(aPublisherID);
    }
    
    public Publishers findPublishersByName(String aName) throws SQLException {
        PublishersDAO dao = new PublishersDAO();
        return dao.findByPublisher(aName);
    }
    
}
