package com.uniyaz.film.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.address.domain.Address;
import com.uniyaz.address.queryfilterdto.AddressQueryFilterDto;
import com.uniyaz.film.domain.Film;
import com.uniyaz.film.queryfilterdto.FilmQueryFilterDto;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class FilmDao {

    public List<Film> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select film From Film film ");
        List<Film> filmList = query.list();
        return filmList;
    }

    public Film save(Film film) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        film = (Film) currentSession.merge(film);
        transaction.commit();
        return film;
    }

    public void delete(Film film) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(film);
        transaction.commit();
    }

    public List<Film> findAllByQueryFilterDto(FilmQueryFilterDto filmQueryFilterDto) {

        String hql =
                "Select film " +
                        "From Film film " +
                        "Left Join fetch film.language languageName " +
                        "where 1=1 ";

        if (filmQueryFilterDto.getId() != null) {
            hql += " and film.id = :filmId";
        }

        if (filmQueryFilterDto.getTitle()!= null) {
            hql += " and film.title = :title";
        }

        if (filmQueryFilterDto.getLanguage() != null) {
            hql += " and film.language.languageName = :name ";
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (filmQueryFilterDto.getId() != null) {
            query.setParameter("filmId", filmQueryFilterDto.getId());
        }

        if (filmQueryFilterDto.getTitle() != null) {
            query.setParameter("title", filmQueryFilterDto.getTitle());
        }

        if (filmQueryFilterDto.getLanguage() != null) {
            query.setParameter("name", filmQueryFilterDto.getLanguage().getLanguageName());
        }

        List<Film> films = query.list();
        return films;
    }
}