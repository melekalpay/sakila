package com.uniyaz.film;

import com.uniyaz.category.domain.Category;
import com.uniyaz.category.service.CategoryService;
import com.uniyaz.customer.domain.Customer;
import com.uniyaz.customer.queryfilterdto.CustomerQueryFilterDto;
import com.uniyaz.customer.service.CustomerService;
import com.uniyaz.film.domain.Film;
import com.uniyaz.film.queryfilterdto.FilmQueryFilterDto;
import com.uniyaz.film.service.FilmService;
import com.uniyaz.store.domain.Store;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class FilmServiceTest {

    @Test
    public void findAllTest() {

        FilmService filmService= new FilmService();
        List<Film> films = filmService.findAll();
        for (Film film : films) {
            System.out.println(film);
        }
    }
    @Test
    public void insertTest(){
        FilmService filmService= new FilmService();
        Film film = new Film();
        Date date = new Date();
        film.setLastUpdate(date);
        film.setTitle("Hababam Sınıfı");
        filmService.save(film);
    }

    @Test
    public void deleteTest(){
        CategoryService categoryService = new CategoryService();
        Category category = new Category();
        category.setId((long) 17);
        categoryService.delete(category);
    }

    @Test
    public void findAllByQueryFilterDto(){
        FilmQueryFilterDto filmQueryFilterDto = new FilmQueryFilterDto();
        FilmService filmService = new FilmService();
        filmQueryFilterDto.setId(1L);

        List<Film> films = filmService.findAllByQueryFilterDto(filmQueryFilterDto);
        for (Film film : films) {
            System.out.println(film);
        }

    }
}
