package com.kramer.services;

import com.kramer.dao.GenreDao;
import com.kramer.pojos.Genre;
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