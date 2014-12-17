package by.it.academy.services;

import by.it.academy.dao.Dao;
import by.it.academy.dao.UserDao;
import by.it.academy.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService extends BaseService<User> {

    private UserDao userDao;

    public UserService(){}

    @Autowired
    public UserService( UserDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

}
