package DAO;

import Model.Authors;
import Model.Books;
import Model.Publishers;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
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
        
        String select = "SELECT books.isbn, books.publisher_id, books.price, books.title, publishers.name FROM books INNER JOIN publishers ON books.publisher_id = publishers.publisher_id  "
					+ " WHERE LOWER(books.title) LIKE LOWER(?) ";
        
        
            try ( // Books book = null;
                    PreparedStatement pstm = c.prepareStatement(select)) {
                pstm.setString(1, "%" + aTitle + "%");
                
                ResultSet rs = pstm.executeQuery();
                
                while (rs.next()){
                    
                    Books book = new Books();
                    book.setPublisherId(rs.getInt("publisher_id"));
                    book.setTitle(rs.getString("title"));
                    book.setIsbn(rs.getString("isbn"));
                    book.setPrice(rs.getDouble("price"));
                    book.publisher = new Publishers();
                    book.publisher.setNamePublisher(rs.getString("name"));
                    books.add(book);
                    
                }
                
                rs.close();
            }
        getConnection().close();
        }catch(SQLException e) {
            e.printStackTrace();
        
        }
        return books;
    }
    
    public Books findByIsbn (String isbn){
        
        Books book = new Books();
        try(
    
        Connection c = DBConnection.getConnection())
        {
        
        String select = "SELECT books.isbn, books.title, books.price, publishers.name, publishers.url "
                + " FROM books "
                + " INNER JOIN publishers ON books.publisher_id = publishers.publisher_id "
                + " WHERE books.isbn = ? ";
        
        // Books book = null;
        PreparedStatement pstm = c.prepareStatement(select);
        pstm.setString(1,isbn);
        ResultSet rs = pstm.executeQuery();
        
        while (rs.next()){
            
            
            //book.setPublisherId(rs.getInt("publisher_id"));
            book.setIsbn(rs.getString("isbn"));
            book.setTitle(rs.getString("title"));
            
            book.setPrice(rs.getDouble("price"));
            book.publisher = new Publishers();
            book.publisher.setNamePublisher(rs.getString("name"));
            book.publisher.setUrl(rs.getString("url"));
            List<Authors> authors = getAuthorByIsbn(isbn);
            book.setAuthors(authors);
            
            
            
        }
        
        rs.close();
        pstm.close();
        getConnection().close();
        }catch(SQLException e) {
            e.printStackTrace();
        
        }
        return book;
    }
    
    public List<Authors> getAuthorByIsbn (String isbn){
        
        List<Authors> authors = new ArrayList<>();
        try(
    
        Connection c = DBConnection.getConnection())
        {
        
        String select = "SELECT  authors.name ||' '|| authors.fname fullName, booksauthors.seq_no "
                + " FROM books "
                + " INNER JOIN booksauthorS ON books.isbn = booksauthors.isbn "
                + " INNER JOIN authors ON booksauthors.author_id = authors.author_id "
                + " WHERE books.isbn = ? ";
        
        // Books book = null;
        PreparedStatement pstm = c.prepareStatement(select);
        pstm.setString(1, isbn);
        ResultSet rs = pstm.executeQuery();
        
        while (rs.next()){
            
            
            //book.setPublisherId(rs.getInt("publisher_id"));
            Authors author = new Authors();
            author.setNameAuthor(rs.getString("fullName"));
            authors.add(author);
            
        }
        
        rs.close();
        pstm.close();
        getConnection().close();
        }catch(SQLException e) {
            e.printStackTrace();
        
        }
        return authors;
    }
}
