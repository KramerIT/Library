package by.it.academy.pojos;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Table(name = "genre")
public class Genre implements Serializable {

    private static final long serialVersionUID = 3L;

    private long id;
    private String name;
    private Set<Book> books = new HashSet<Book>();

    public Genre() {
    }

    public Genre(String name, Set<Book> books) {
        this.name = name;
        this.books = books;
    }

    public Genre(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @Column(name = "genre_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "name", unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "genre", fetch = FetchType.EAGER)
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}