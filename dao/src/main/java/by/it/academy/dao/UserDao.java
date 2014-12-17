package by.it.academy.dao;

import by.it.academy.pojos.User;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDao extends BaseDao<User> {

    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    public UserDao( ) {
    }

    @Autowired
    public UserDao(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<User> getAll(){
        List<User> users = getSession().createQuery("from User").list();
        for (User user : users){
            logger.info("user: " + user);
        }
        return users;
    }
}
