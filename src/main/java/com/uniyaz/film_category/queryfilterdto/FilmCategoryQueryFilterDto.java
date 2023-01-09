package com.uniyaz.film_category.queryfilterdto;

import com.uniyaz.category.domain.Category;
import com.uniyaz.film.domain.Film;

public class FilmCategoryQueryFilterDto {

    private Long id;
    private Film film;
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
