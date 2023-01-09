package com.uniyaz.film_category.domain;

import com.uniyaz.category.domain.Category;
import com.uniyaz.domain.common.BaseEntity;
import com.uniyaz.film.domain.Film;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.util.Date;
import java.util.Locale;

@Entity
@Table(name="film_category")

public class FilmCategory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "filmcategory_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id")
    @ForeignKey(name = "fk_film_category_film")
    private Film film;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @ForeignKey(name = "fk_film_category_category")
    private Category category;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date lastUpdate;

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

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "FilmCategory{" +
                "id=" + id +
                ", film=" + film +
                ", category=" + category +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
