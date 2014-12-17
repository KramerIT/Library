package by.it.academy.pojos;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Table(name = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String title;
    private int isbn;
    private String description;
    private Genre genre;
    private Set<Author> authors = new HashSet<Author>();

    public Book() {
    }

    public Book(String title, int isbn, String description){
        this.title = title;
        this.isbn = isbn;
        this.description = description;
    }

    @Id
    @GeneratedValue
    @Column(name = "book_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})/*(fetch = FetchType.EAGER)*/
    @JoinColumn(name = "genre_id")
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "book_author", joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
