package com.uniyaz.inventory.domain;

import com.uniyaz.domain.common.BaseEntity;
import com.uniyaz.film.domain.Film;
import com.uniyaz.store.domain.Store;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "inventory")
public class Inventory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id")
    @ForeignKey(name = "fk_inventory_film")
    private Film film;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    @ForeignKey(name = "fk_inventory_store")
    private Store store;

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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Inverntory{" +
                "id=" + id +
                ", film=" + film +
                ", store=" + store +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
