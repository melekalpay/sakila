package com.uniyaz.language.domain;

import com.uniyaz.domain.common.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "language")
public class Language extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private  Long id;

    @Column(name = "name")
    private String languageName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date lastUapdate;

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public Date getLastUapdate() {
        return lastUapdate;
    }

    public void setLastUapdate(Date lastUapdate) {
        this.lastUapdate = lastUapdate;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Language{" +
                "languageName='" + languageName + '\'' +
                '}';
    }
}
