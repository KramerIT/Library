package by.it.academy.services;

import by.it.academy.dao.GenreDao;
import by.it.academy.pojos.Genre;
import by.it.academy.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GenreService extends BaseService<Genre> {

    private GenreDao genreDao;

    public GenreService(){}

    @Autowired
    public GenreService( GenreDao genreDao) {
        super(genreDao);
        this.genreDao = genreDao;
    }

    public List<Genre> getAll() {
        return genreDao.getAll();
    }
}