package com.uniyaz.film_actor.service;


import com.uniyaz.film.dao.FilmDao;
import com.uniyaz.film.domain.Film;
import com.uniyaz.film.queryfilterdto.FilmQueryFilterDto;
import com.uniyaz.film_actor.dao.FilmActorDao;
import com.uniyaz.film_actor.domain.FilmActor;
import com.uniyaz.film_actor.queryfilterdto.FilmActorQueryFilterDto;

import java.util.List;

public class FilmActorService {

    public List<FilmActor> findAll() {
        FilmActorDao filmActorDao = new FilmActorDao();
        return filmActorDao.findAll();
    }

    public FilmActor save(FilmActor filmActor) {
        FilmActorDao filmActorDao = new FilmActorDao();
        return filmActorDao.save(filmActor);
    }

    public void delete(FilmActor filmActor) {
        FilmActorDao filmActorDao = new FilmActorDao();
        filmActorDao.delete(filmActor);
    }
    public List<FilmActor> findAllByQueryFilterDto(FilmActorQueryFilterDto filmActorQueryFilterDto) {
        FilmActorDao filmActorDao = new FilmActorDao();
        return filmActorDao.findAllByQueryFilterDto(filmActorQueryFilterDto);
    }
    public List<FilmActor> findAllByQueryFilterDtoCriteria(FilmActorQueryFilterDto filmActorQueryFilterDto) {
        FilmActorDao filmActorDao = new FilmActorDao();
        return filmActorDao.findAllByQueryFilterDtoCriteria(filmActorQueryFilterDto);
    }
}