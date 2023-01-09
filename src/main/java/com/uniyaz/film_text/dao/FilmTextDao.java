package com.uniyaz.film_text.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.film.domain.Film;
import com.uniyaz.film_text.domain.FilmText;
import com.uniyaz.film_text.queryfilterdto.FilmTextQueryFilterDto;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class FilmTextDao {

    public List<FilmText> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select filmText From FilmText filmText");
        List<FilmText> filmTextList = query.list();
        return filmTextList;
    }

    public FilmText save(FilmText filmText) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        filmText = (FilmText) currentSession.merge(filmText);
        transaction.commit();
        return filmText;
    }

    public void delete(FilmText filmText) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(filmText);
        transaction.commit();
    }

    public List<FilmText> findAllByQueryFilterDto(FilmTextQueryFilterDto filmTextQueryFilterDto) {
        String hql =
                "Select filmText " +
                        "From FilmText filmText " +
                        "where 1=1 ";

        if (filmTextQueryFilterDto.getId() != null) hql += " and filmText.id = :filmTextId";
        if (filmTextQueryFilterDto.getTitle() != null) hql += " and filmText.title = :title";


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (filmTextQueryFilterDto.getId() != null) query.setParameter("filmTextId", filmTextQueryFilterDto.getId());
        if (filmTextQueryFilterDto.getTitle() != null) query.setParameter("title", filmTextQueryFilterDto.getTitle());

        List<FilmText> filmTextList = query.list();
        return filmTextList;
    }

    public List<FilmText> findAllByQueryFilterDtoCriteria(FilmTextQueryFilterDto filmTextQueryFilterDto) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Criteria criteria = currentSession.createCriteria(FilmText.class);

        if (filmTextQueryFilterDto.getId() != null) criteria.add(Restrictions.eq("id", filmTextQueryFilterDto.getId()));
        if (filmTextQueryFilterDto.getTitle() != null) criteria.add(Restrictions.eq("title", filmTextQueryFilterDto.getTitle()));

        List<FilmText> filmTextList = criteria.list();
        return filmTextList;
    }
}
