package app.model;


import com.google.gson.annotations.SerializedName;
import org.hibernate.annotations.CollectionType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    private String title;

    @SerializedName("author")
    @ElementCollection
    private List<String> authors;

    private String published_at;

    @ElementCollection
    private List<String> isbn;

    @Id
    private String asin;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthor(List<String> authors) {
        this.authors = authors;
    }

    public String getPublished_at() {
        return published_at;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
    }

    public List<String> getIsbn() {
        return isbn;
    }

    public void setIsbn(List<String> isbn) {
        this.isbn = isbn;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors=" + authors.toString() +
                ", published_at='" + published_at + '\'' +
                ", isbn=" + isbn.toString() +
                ", asin='" + asin + '\'' +
                '}';
    }
}
