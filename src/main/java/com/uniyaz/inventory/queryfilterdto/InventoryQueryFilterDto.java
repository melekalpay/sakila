package com.uniyaz.inventory.queryfilterdto;

import com.uniyaz.film.domain.Film;
import com.uniyaz.store.domain.Store;

public class InventoryQueryFilterDto {

    private Long id;
    private Film film;
    private Store store;

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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
