package by.it.academy.controller;

import by.it.academy.pojos.Author;
import by.it.academy.pojos.Book;
import by.it.academy.pojos.Genre;
import by.it.academy.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
public class MainController {

    @Autowired
    private GenreService genreService;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    public void DoIt(String name, int index) throws SQLException {
        Book book = new Book("Book" + name, 123456 + index, "About Book"  + index);
        Set<Book> books = new HashSet<Book>();
        books.add(book);
        Author author = new Author("AuthorName" + index,"AuthorSurName" + index, "AuthorDescription" + index, books);
        Set<Author> authors = new HashSet<Author>();
        authors.add(author);
        book.setAuthors(authors);
        Genre genre = new Genre(name);
        genre.setBooks(books);
        authorService.add(author);
        bookService.add(book);
        genreService.add(genre);
    }


    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) throws SQLException {

        DoIt("Comedy1", 1);
        DoIt("Comedy1", 2);
        DoIt("Comedy1", 3);
        DoIt("asdfasdf", 4);
        DoIt("Comedy1", 5);
        DoIt("asdfas", 1);
        DoIt("Tragedy1", 2);
        DoIt("Tragedy1", 3);
        DoIt("asdfa", 4);
        DoIt("Tragedy1", 5);
        DoIt("Drama1", 1);
        DoIt("adfadf", 2);
        DoIt("Drama1", 3);
        DoIt("Drama1", 4);
        DoIt("Drama1", 5);

        Book book = bookService.get(new Long(1));

        System.out.print(book.getTitle());

        List<Genre> genres = genreService.getAll();
        model.addAttribute("genre", new Genre());
        model.addAttribute("allGenre", genres);
        model.addAttribute("book", book);

        return "main";
    }

}
