package by.it.academy.services;

import by.it.academy.dao.BookDao;
import by.it.academy.dao.UserDao;
import by.it.academy.pojos.Book;
import by.it.academy.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService extends BaseService<Book> {

    private BookDao bookDao;

    public BookService(){}

    @Autowired
    public BookService( BookDao bookDao) {
        super(bookDao);
        this.bookDao = bookDao;
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }
}