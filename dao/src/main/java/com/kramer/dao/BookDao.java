package com.kramer.dao;

import com.kramer.pojos.Book;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDao extends BaseDao<Book> {

    private static final Logger logger = LoggerFactory.getLogger(BookDao.class);

    public BookDao( ) {
    }

    @Autowired
    public BookDao(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Book> getAll(){
        List<Book> books = getSession().createQuery("from Book").list();
        for (Book book : books){
            logger.info("user: " + book);
        }
        return books;
    }
}
