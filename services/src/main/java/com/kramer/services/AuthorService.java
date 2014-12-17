package com.kramer.services;

import com.kramer.dao.AuthorDao;
import com.kramer.pojos.Author;
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
