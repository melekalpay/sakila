package com.uniyaz.category.domain;

import com.uniyaz.domain.common.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="category")

public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private Long id;

    @Column(name = "name")
    private String categoryName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date lastUpdate;

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return categoryName;
    }
}
