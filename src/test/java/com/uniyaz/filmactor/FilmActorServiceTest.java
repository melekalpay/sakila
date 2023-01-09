package com.uniyaz.filmactor;

import com.uniyaz.film.domain.Film;
import com.uniyaz.film.queryfilterdto.FilmQueryFilterDto;
import com.uniyaz.film.service.FilmService;
import com.uniyaz.film_actor.dao.FilmActorDao;
import com.uniyaz.film_actor.domain.FilmActor;
import com.uniyaz.film_actor.queryfilterdto.FilmActorQueryFilterDto;
import com.uniyaz.film_actor.service.FilmActorService;

import com.uniyaz.film_category.dao.FilmCategoryDao;
import com.uniyaz.film_category.domain.FilmCategory;
import org.junit.Test;

import javax.persistence.Table;
import java.util.List;

public class FilmActorServiceTest {

    @Test
    public void findAllTest() {

        FilmActorService filmActorService = new FilmActorService();
        List<FilmActor> filmActorList = filmActorService.findAll();
        for (FilmActor filmActor : filmActorList) {
            System.out.println(filmActor);
        }
    }
    @Test
    public void findAllByQueryFilterDto(){
        FilmActorQueryFilterDto filmActorQueryFilterDto = new FilmActorQueryFilterDto();
        FilmActorService filmActorService = new FilmActorService();
        filmActorQueryFilterDto.setId(1L);

        List<FilmActor> filmActors = filmActorService.findAllByQueryFilterDto(filmActorQueryFilterDto);
        for (FilmActor filmActor : filmActors) {
            System.out.println(filmActor);
        }
    }

    @Test
    public void findAllByQueryFilterDtoCriteria(){
        FilmActorQueryFilterDto filmActorQueryFilterDto = new FilmActorQueryFilterDto();
        FilmActorService filmActorService = new FilmActorService();
        filmActorQueryFilterDto.setId(1L);

        List<FilmActor> filmActors = filmActorService.findAllByQueryFilterDtoCriteria(filmActorQueryFilterDto);
        for (FilmActor filmActor : filmActors) {
            System.out.println(filmActor);
        }
    }
    @Test
    public void findAllByActorName () {

        FilmActorDao filmActorDao=new FilmActorDao();
        String name= "NICK";
        List<FilmActor> filmActors =filmActorDao.findAllByActorName(name);
        for (FilmActor filmActor : filmActors) {
            System.out.println(filmActor);
        }


    }

}