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
//@Table(name = "author")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Author implements Serializable {
    private static final long serialVersionUID = 4L;

    private long id;
    private String name;
    private String surname;
    private String description;
    private Set<Book> books = new HashSet<Book>();

    public Author() {
    }

    public Author(String name, String surname, String description, Set<Book> books) {
        this.name = name;
        this.surname = surname;
        this.description = description;
        this.books = books;
    }

    @Id
    @GeneratedValue
    @Column(name = "author_id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }


}