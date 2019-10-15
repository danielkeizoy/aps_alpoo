package Controller;

import DAO.BooksDAO;
import Model.Books;
import View.FrmBooks;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_BACK_SPACE;
import java.awt.event.KeyListener;
import static java.lang.Character.isLetter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BooksController {

    FrmBooks principal;
    BooksDAO booksDao;

    public BooksController() {
        this.principal = new FrmBooks();
        this.booksDao = new BooksDAO();
        principal.buscaComportamento(new ComportamentoBtnSearch());
        principal.AutoBusca(new AutoBusca());
    }

    public class ComportamentoBtnSearch implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println("TESTE PROCUROU click!");
            String titulo = principal.getTitle();
            List<Books> books;
            books = booksDao.findByTitle(titulo);

            principal.showBooks(books);

            /*
            try {
                searchResult = booksDao.findByTitle(titulo);
            } catch (SQLException ex) {
                Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }
    }

    public class AutoBusca implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) {
            if (isLetter(ke.getKeyChar())) {
                String titulo = principal.getTitle();
                List<Books> books;
                books = booksDao.findByTitle(titulo);

                principal.showBooks(books);
            }
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == VK_BACK_SPACE) {                
                String titulo = principal.getTitle();
                List<Books> books;
                books = booksDao.findByTitle(titulo);

                principal.showBooks(books);
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            
        }

        private class ComportamentoBtnClear implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        }

        private class ComportamentoBtnNew implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        }

        private class ComportamentoBtnEdit implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        }

        private class ComportamentoBtnDelete implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        }

        public void save(String aTitle, String anISBN, Double aPrice) throws SQLException, ParseException {

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
//    
//    public List booksList(){
//        
//        BooksDAO dao = new BooksDAO();
//        
//        try {
//            return dao.findBooks();
//        } catch (SQLException ex){
//            JOptionPane.showMessageDialog(null, "We have got some error trying to find books" + ex.getLocalizedMessage());
//        }
//        
//        return null;
//    }

        public void delete(String anISBN) throws SQLException {
            new BooksDAO().deleteBook(anISBN);
        }

        /* public List findBooksByName(String aName) throws SQLException {
//        BooksDAO dao = new BooksDAO();
//        return dao.findByTitle(aName);

        BooksDAO dao = new BooksDAO();
        
        try {
            return dao.findByTitle(aName);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "We have got some error trying to find books" + ex.getLocalizedMessage());
        }
        
        return null;
    }*/
    }
}
