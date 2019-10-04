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
        //TODO keylistener enter
//        principal.buscaEnter(new ComportamentoBtnSearch());
    }

    public class ComportamentoBtnSearch implements ActionListener {       
                
        @Override
        public void actionPerformed(ActionEvent ae) {
            String titulo = principal.getTitle();
            List<Books> searchResult = null;
            try {
                searchResult = booksDao.findByTitle(titulo);
            } catch (SQLException ex) {
                Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            principal.showBooks(searchResult);
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
