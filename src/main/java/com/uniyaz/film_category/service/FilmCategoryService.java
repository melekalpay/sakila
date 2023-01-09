package com.uniyaz.film_category.service;

import com.uniyaz.film_actor.dao.FilmActorDao;
import com.uniyaz.film_actor.domain.FilmActor;
import com.uniyaz.film_category.dao.FilmCategoryDao;
import com.uniyaz.film_category.domain.FilmCategory;

import java.util.List;

public class FilmCategoryService {
    public List<FilmCategory> findAll() {
        FilmCategoryDao filmCategoryDao = new FilmCategoryDao();
        return filmCategoryDao.findAll();
    }
}
