package com.uniyaz.film_actor.queryfilterdto;

import com.uniyaz.actor.domain.Actor;
import com.uniyaz.film.domain.Film;

public class FilmActorQueryFilterDto {
    private Long id;
    private Film film;
    private Actor actor;

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

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
