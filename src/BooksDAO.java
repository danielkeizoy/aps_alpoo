package DAO;

import Model.Books;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BooksDAO extends DAO {

    public void saveBook(Books aBook) throws SQLException {
        
        String insert = "INSERT INTO books (title, isbn, publisher_id, price) VALUES (?,?,?,?)";
        save(insert, aBook.getTitle(), aBook.getIsbn(), aBook.getPublisherId(), aBook.getPrice());
    
    }
    
    public void updateBook(Books aBook) throws SQLException{
        
        String update = "UPDATE books " + "SET title = ?, publisher_id = ?, price = ? " +
                "WHERE isbn = ?";
        update(update, aBook.getTitle(), aBook.getPublisherId(), aBook.getPrice(), aBook.getIsbn());
    }
    
    public void deleteBook(int isbn) throws SQLException{
        
        String delete = "DELETE FROM books WHERE isbn = ?";
        
        delete(delete, isbn);
    }
    
//    public List findBooks() throws SQLException{
//        
//        List books = new ArrayList();
//        
//        String select = "SELECT * FROM books";
//        
//        PreparedStatement stmt = getConnection().prepareStatement(select);
//        
//        ResultSet rs = stmt.executeQuery();
//        
//        while (rs.next()){
//            Books book = new Books();
//            book.setPublisherId(rs.getInt("publisher_id"));
//            book.setTitle(rs.getString("title"));
//            book.setIsbn(rs.getString("isbn"));
//            book.setPrice(rs.getDouble("price"));
//            books.add(book);
//        }
//        
//        rs.close();
//        stmt.close();
//        getConnection().close();
//        
//        return books;
//    }
    
    public List findByTitle (String aTitle) throws SQLException{
        
        List books = new ArrayList();
        
        String select = "SELECT * FROM books WHERE title = ?";

        PreparedStatement stmt = getConnection().prepareStatement(select);
        
        stmt.setString(1, aTitle);
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()){
            Books book = new Books();
            book.setPublisherId(rs.getInt("publisher_id"));
            book.setTitle(rs.getString("title"));
            book.setIsbn(rs.getString("isbn"));
            book.setPrice(rs.getDouble("price"));
            books.add(book);
        }
        
        rs.close();
        stmt.close();
        getConnection().close();
        
        return books;
    }
}