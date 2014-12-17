package by.it.academy.dao;

import by.it.academy.pojos.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AuthorDao extends BaseDao<Author> {

    private static final Logger logger = LoggerFactory.getLogger(AuthorDao.class);

    public AuthorDao( ) {
    }

    @Autowired
    public AuthorDao(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Author> getAll(){
        List<Author> authors = getSession().createQuery("from Author").list();
        for (Author author : authors){
            logger.info("user: " + author);
        }
        return authors;
    }
}