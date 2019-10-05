/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.FrmBooks;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DAO.BooksDAO;
import Model.Books;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kivia
 */
public class BooksController {

    FrmBooks principal;
    BooksDAO booksDao;

    public BooksController() {
        this.principal = new FrmBooks();
        this.booksDao = new BooksDAO();
        principal.buscaComportamento(new ComportamentoBtnSearch());      
        principal.buscaEnter(new BotaoEnter());
    }

    public class ComportamentoBtnSearch implements ActionListener {       
                
        @Override
        public void actionPerformed(ActionEvent ae) {
            String titulo = principal.getTitle();
            List<Books> searchResult = null;
            System.out.println("TESTE PROCUROU click!");
            try {
                searchResult = booksDao.findByTitle(titulo);
            } catch (SQLException ex) {
                Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            principal.showBooks(searchResult);
        }
    }
    public class BotaoEnter implements KeyListener {        

        @Override
        public void keyTyped(KeyEvent ke) {
            if(ke.getKeyCode()== KeyEvent.VK_ENTER){
                String titulo = principal.getTitle();
            List<Books> searchResult = null;
                System.out.println("TESTE PROCUROU enter!");
            try {
                searchResult = booksDao.findByTitle(titulo);
            } catch (SQLException ex) {
                Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            principal.showBooks(searchResult);
            }
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
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
}
