package com.uniyaz.film_text.service;

import com.uniyaz.film.dao.FilmDao;
import com.uniyaz.film.domain.Film;
import com.uniyaz.film_text.dao.FilmTextDao;
import com.uniyaz.film_text.domain.FilmText;

import java.util.List;

public class FilmTextService {
    public List<FilmText> findAll() {
        FilmTextDao filmTextDao = new FilmTextDao();
        return filmTextDao.findAll();
    }
}
