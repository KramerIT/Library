package by.it.academy.services;

import by.it.academy.dao.AuthorDao;
import by.it.academy.dao.UserDao;
import by.it.academy.pojos.Author;
import by.it.academy.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorService extends BaseService<Author> {

    private AuthorDao authorDao;

    public AuthorService(){}

    @Autowired
    public AuthorService( AuthorDao authorDao) {
        super(authorDao);
        this.authorDao = authorDao;
    }

    public List<Author> getAll() {
        return authorDao.getAll();
    }

}
