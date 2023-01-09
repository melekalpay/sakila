package com.uniyaz.filmcategory;

import com.uniyaz.category.domain.Category;
import com.uniyaz.film_actor.domain.FilmActor;
import com.uniyaz.film_actor.service.FilmActorService;
import com.uniyaz.film_category.dao.FilmCategoryDao;
import com.uniyaz.film_category.domain.FilmCategory;
import com.uniyaz.film_category.service.FilmCategoryService;
import org.junit.Test;

import java.util.List;

public class FilmCategoryServiceTest {

    @Test
    public void findAllByCategoryName () {

        FilmCategoryDao filmCategoryDao = new FilmCategoryDao();
        String name= "Comedy";
        List<FilmCategory> filmCategories =filmCategoryDao.findAllByCategoryName(name);
        for (FilmCategory filmCategory : filmCategories) {
            System.out.println(filmCategory);
        }
    }

    @Test
    public void findAllByFilmName() {

        FilmCategoryDao filmCategoryDao = new FilmCategoryDao();
         String harf = "A";
        List<FilmCategory> filmCategories =filmCategoryDao.findAllByFilmName(harf);
        for (FilmCategory filmCategory : filmCategories) {
            System.out.println(filmCategory);
        }
    }

    @Test
    public void findAllTest() {

        FilmCategoryService filmCategoryService = new FilmCategoryService();
        List<FilmCategory> filmCategories = filmCategoryService.findAll();
        for (FilmCategory filmCategory : filmCategories) {
            System.out.println(filmCategory);
        }




}}

