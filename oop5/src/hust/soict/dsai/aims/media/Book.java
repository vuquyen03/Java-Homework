package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

    private List<String> authors = new ArrayList<String>();

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName){
        if (!authors.contains(authorName)){
            authors.add(authorName);
        }
        else{
            System.out.println("This author already exist in list");
        }
    }

    public void removeAuthor(String authorName){
        if (authors.contains(authorName)){
            authors.remove(authorName);
        }
        else{
            System.out.println("This author doesn't exist in list");
        }
    }
    public Book(int id, String title, String category, float cost, List<String> authors){
        super(id, title, category, cost);
        this.authors = authors;
    }

    public Book(int id, String title, String category, float cost){
        super(id, title, category, cost);
    }

    public Book(String title, String category, float cost){
        super(title, category,cost);
    }

}
