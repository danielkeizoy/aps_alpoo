package View;

import Controller.BooksController;
import Model.Books;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class FrmBooks extends JFrame {

    JLabel lblSearchBook = new JLabel();
    JLabel lblSearchAuthor = new JLabel();
    JLabel lblSearchPublisher = new JLabel();
    JLabel lblSegN = new JLabel();
    JLabel lblBook = new JLabel();
    JLabel lblIsbn = new JLabel();
    JLabel lblPrice = new JLabel();
    JLabel lblPublisher = new JLabel();
    JLabel lblUrl = new JLabel();
    JLabel lblAuthor = new JLabel();
    JButton btnSearch = new JButton();
    JButton btnClear = new JButton();
    JButton btnNew = new JButton();
    JButton btnEdit = new JButton();
    JButton btnDelete = new JButton();
    JTextField txtSearchBook = new JTextField();
    JTextField txtSearchAuthor = new JTextField();
    JTextField txtSearchPublisher = new JTextField();
    JTextField txtSeqN = new JTextField();
    JTextField txtBook = new JTextField();
    JTextField txtIsbn = new JTextField();
    JTextField txtPrice = new JTextField();
    JTextField txtPublisher = new JTextField();
    JTextField txtUrl = new JTextField();
    JTextArea txtAuthor = new JTextArea(5, 10);
    DefaultTableModel dtm = new DefaultTableModel();
    JTable table;
    JPanel panelSearch = new JPanel();//
    JMenuBar menuBar = new JMenuBar();
    JMenu menuCadastrar = new JMenu();
    JMenu menuSearch = new JMenu();
    JMenuItem menuCadastrarBook = new JMenuItem();
    JMenuItem menuCadastrarAuthor = new JMenuItem();
    JMenuItem menuCadastrarPublisher = new JMenuItem();
    JMenuItem menuSearchBook = new JMenuItem();
    JMenuItem menuSearhAuthor = new JMenuItem();
    JMenuItem menuSearchPublisher = new JMenuItem();
    

    public static void main(String[] args) {

        new Controller.BooksController();

    }

    public FrmBooks() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1024, 768));
        setVisible(true);
        setTitle("Livraria");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //Menu
        menuCadastrar.setText("Cadastrar");

        menuCadastrarBook.setText("Livro");
        menuCadastrar.add(menuCadastrarBook);
        menuCadastrarAuthor.setText("Autor");
        menuCadastrar.add(menuCadastrarAuthor);
        menuCadastrarPublisher.setText("Editora");
        menuCadastrar.add(menuCadastrarPublisher);

        menuBar.add(menuCadastrar);

        menuSearch.setText("Buscar");
        menuSearchBook.setText("Livro");
        menuSearch.add(menuSearchBook);
        menuSearhAuthor.setText("Autor");
        menuSearch.add(menuSearhAuthor);
        menuSearchPublisher.setText("Editora");
        menuSearch.add(menuSearchPublisher);

        menuBar.add(menuSearch);
        setJMenuBar(menuBar);

        //Painel Filtro  
        JPanel panelFilter = new JPanel();
        panelFilter.setLayout(new GridLayout(2, 1));
        //panelFilter.setBackground(Color.yellow);

        panelSearch.setBorder(BorderFactory.createTitledBorder("Buscar Livro"));
        panelSearch.setLayout(new GridLayout(2, 3));
        lblSearchBook.setText("Livro");
        lblSearchAuthor.setText("Autor");
        lblSearchPublisher.setText("Editora");
        panelSearch.add(lblSearchBook);
        panelSearch.add(lblSearchAuthor);
        panelSearch.add(lblSearchPublisher);
        panelSearch.add(txtSearchBook);
        panelSearch.add(txtSearchAuthor);
        panelSearch.add(txtSearchPublisher);
        panelFilter.add(panelSearch);
//        panelSearch.setBackground(Color.pink);

        JPanel panelBtn = new JPanel();
        panelBtn.setLayout(new GridLayout(1, 2, 15, 20));
        btnSearch.setText("BUSCAR");
        btnClear.setText("LIMPAR");
        panelBtn.add(btnSearch);
        panelBtn.add(btnClear);
        // panelFilter.add(panelBtn);

        //Tabela
        Object[] colNames = {"isbn", "title", "editora"};
        Object[][] data = new Object[0][3];
        dtm = new DefaultTableModel(data, colNames);
           
        table = new JTable(dtm){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
            
        };
       
        JScrollPane jScrollPane1 = new JScrollPane(table);

        // Infos
        lblSegN.setText("Seq. Nº");
        lblBook.setText("Book");
        lblIsbn.setText("ISBN");
        lblPrice.setText("Price");
        lblPublisher.setText("Publisher");
        lblUrl.setText("URL");
        lblAuthor.setText("Autor");
        btnNew.setText("NOVO");
        btnEdit.setText("EDITAR");
        btnDelete.setText("EXCLUIR");

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.ipadx = 500;
        gbc.ipady = 13;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(24, 12, 0, 0);
        add(panelSearch, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.gridheight = 15;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipadx = 628;
        gbc.ipady = 512;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(7, 12, 67, 0);
        add(jScrollPane1, gbc);

        lblSegN.setText("Seq Nº");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(10, 73, 0, 0);
        add(lblSegN, gbc);

        lblBook.setText("Book");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(21, 86, 0, 0);
        add(lblBook, gbc);

        lblIsbn.setText("ISBN");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(21, 86, 0, 0);
        add(lblIsbn, gbc);

        lblPrice.setText("Price");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(21, 85, 0, 0);
        add(lblPrice, gbc);

        lblPublisher.setText("Publisher");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(21, 61, 0, 0);
        add(lblPublisher, gbc);

        lblUrl.setText("URL");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(21, 91, 0, 0);
        add(lblUrl, gbc);

        lblAuthor.setText("Author");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 14;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(18, 61, 0, 0);
        add(lblAuthor, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 2;
        gbc.gridheight = 2;
        gbc.ipadx = 63;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(7, 7, 0, 0);
        add(txtSeqN, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 4;
        gbc.gridheight = 2;
        gbc.ipadx = 63;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(18, 7, 0, 0);
        add(txtBook, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 6;
        gbc.gridheight = 2;
        gbc.ipadx = 63;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(18, 7, 0, 0);
        add(txtIsbn, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 8;
        gbc.gridheight = 2;
        gbc.ipadx = 63;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(18, 7, 0, 0);
        add(txtPrice, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 10;
        gbc.gridheight = 2;
        gbc.ipadx = 63;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(18, 7, 0, 0);
        add(txtPublisher, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 12;
        gbc.gridheight = 2;
        gbc.ipadx = 63;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(18, 7, 0, 0);
        add(txtUrl, gbc);

        btnNew.setText("NOVO");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 16;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(16, 61, 67, 0);
        add(btnNew, gbc);

        btnEdit.setText("EDITAR");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 16;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(16, 25, 67, 0);
        add(btnEdit, gbc);

        btnDelete.setText("EXCLUIR");
        gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy = 16;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(16, 18, 67, 0);
        add(btnDelete, gbc);

        JScrollPane jScrollPane2 = new JScrollPane();
        txtAuthor.setColumns(1);
        txtAuthor.setRows(10);
        jScrollPane2.setViewportView(txtAuthor);

        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 14;
        gbc.gridwidth = 4;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipadx = 307;
        gbc.ipady = 235;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(18, 7, 0, 50);
        add(jScrollPane2, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 14;
        gbc.ipady = 13;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(7, 35, 0, 0);
        add(panelBtn, gbc);

        pack();

    }

    public String getTitle() {
        return txtSearchBook.getText();
    }

    public void showBooks(List<Books> resultado) {
        dtm.setNumRows(0);
        for (Books book : resultado) {
            Object[] data = new Object[3];
            data[0] = book.isbn;
            data[1] = book.title;
            data[2] = book.publisher.namePublisher;
            dtm.addRow(data);
        }
    }

    /*public void buscaComportamento(BooksController.ComportamentoBtnSearch comportamentoBtnSearch) {
        btnSearch.addActionListener(comportamentoBtnSearch);       
    }*/
    public void buscaComportamento(ActionListener al) {
        btnSearch.addActionListener(al);
        txtSearchBook.addActionListener(al);
    }

    
    
}
