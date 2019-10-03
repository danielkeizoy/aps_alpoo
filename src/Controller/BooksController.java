
package Controller;

import DAO.BooksDAO;
import Model.Books;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;


public class BooksController {


    public void save(String aTitle, String anISBN, Double aPrice) throws SQLException, ParseException{
        
        Books book = new Books();
        book.setTitle(aTitle);
        book.setIsbn(anISBN);
        book.setPrice(aPrice);
        
        new BooksDAO().saveBook(book);
    }
    
    public void update(String aTitle, String anISBN, Double aPrice) throws ParseException, SQLException {
        
        Books book = new Books();
        book.setTitle(aTitle);
        book.setIsbn(anISBN);
        book.setPrice(aPrice);
        
        new BooksDAO().updateBook(book);
    } 
    
    public List booksList(){
        
        BooksDAO dao = new BooksDAO();
        
        try {
            return dao.findBooks();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "We have got some error trying to find books" + ex.getLocalizedMessage());
        }
        
        return null;
    }
    
    public void delete(String anISBN) throws SQLException {
        new BooksDAO().deleteBook(anISBN);
    }
    
    public Books findBooksByName(String aName) throws SQLException {
        BooksDAO dao = new BooksDAO();
        return dao.findByTitle(aName);
    }
    
}
