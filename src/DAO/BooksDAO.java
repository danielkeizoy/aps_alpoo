package DAO;

import Model.Books;
import Model.Publishers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BooksDAO extends DAO {

    public void saveBook(Books aBook) throws SQLException {
        
        String insert = "INSERT INTO books (title, isbn, price) VALUES (?,?,?)";
        save(insert, aBook.getTitle(), aBook.getIsbn(), aBook.getPrice());
    
    }
    
    public void updateBook(Books aBook) throws SQLException{
        
        String update = "UPDATE books " + "SET title = ?, price = ? " +
                "WHERE isbn = ?";
        update(update, aBook.getTitle(), aBook.getPrice(), aBook.getIsbn());
    }
    
    public void deleteBook(String isbn) throws SQLException{
        
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
//    
    public List<Books> findByTitle (String aTitle){
        
        List <Books> books = new ArrayList();
        try(
    
        Connection c = DBConnection.getConnection())
        {
        
        String select = "SELECT books.isbn, books.title, publishers.name FROM books INNER JOIN publishers ON books.publisher_id = publishers.publisher_id  "
					+ " WHERE LOWER(books.title) LIKE LOWER(?) ";
        
        
        // Books book = null;
        PreparedStatement pstm = c.prepareStatement(select);
        
        pstm.setString(1, "%" + aTitle + "%");
        
        ResultSet rs = pstm.executeQuery();
        
        while (rs.next()){
            
            Books book = new Books();
            //book.setPublisherId(rs.getInt("publisher_id"));
            book.setTitle(rs.getString("title"));
            book.setIsbn(rs.getString("isbn"));
            //book.setPrice(rs.getDouble("price"));
            book.publisher = new Publishers();
            book.publisher.setNamePublisher(rs.getString("name"));
            books.add(book);
            
        }
        
        rs.close();
        pstm.close();
        getConnection().close();
        }catch(SQLException e) {
            e.printStackTrace();
        
        }
        return books;
    }
}
