package by.it.academy.dao;

import by.it.academy.pojos.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class GenreDao extends BaseDao<Genre> {

    private static final Logger logger = LoggerFactory.getLogger(GenreDao.class);

    public GenreDao( ) {
    }

    @Autowired
    public GenreDao(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Genre> getAll(){
        List<Genre> genres = getSession().createQuery("from Genre").list();
        for (Genre genre : genres){
            logger.info("user: " + genre);
        }
        return genres;
    }

    @Override
    public void add(Genre genre) {
/*            List<Genre> genreTemp = getSession().createQuery("FROM Genre WHERE name = " +
                    "'" + genre.getName() + "'").list();
            if(genreTemp.isEmpty()){
                getSession().save(genre);
            }*/

        List genreTemp = getSession().createQuery("FROM Genre WHERE name = " +
                "'" + genre.getName() + "'").list();
        if(genreTemp.isEmpty()){
            getSession().save(genre);
        }

    }
}
