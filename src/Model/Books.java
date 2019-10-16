package Model;

import java.util.List;
import Model.Authors;

public class Books {
    
    public String title;
    public String isbn;
    private int publisherId;
    public Publishers publisher;
    private double price;
    public List<Authors> authors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    public List<Authors> getAuthors() {
        return authors;
    }

    
    public void setAuthors(List<Authors> authors) {
        this.authors = authors;
    }
//    @Override
    public String autores(List<Authors> authors){
        String toString = "";
        //para pular linha em linux eh \n, mas em windows eh \r\n
        String enter = System.getProperty("line.separator");
        for(Authors autores: authors){
            toString += autores.getNameAuthor();
            toString += " " + enter;
        }
        return toString;
    }
   
    
}
