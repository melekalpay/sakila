package com.uniyaz.film_category.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.actor.domain.Actor;
import com.uniyaz.category.domain.Category;
import com.uniyaz.film_actor.domain.FilmActor;
import com.uniyaz.film_category.domain.FilmCategory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class FilmCategoryDao {

    public List<FilmCategory> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        String hql =
                "Select filmcategory " +
                        "From FilmCategory filmcategory " +
                        "Left Join fetch filmcategory.category categoryName" +
                        "Left Join fetch filmcategory.film title" +
                        " "
                ;
        Query query = currentSession.createQuery(hql);
        List<FilmCategory> filmCategories = query.list();
        return filmCategories;
    }

    public List<FilmCategory> findAllByCategoryName(String name) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        String hql =
                "Select filmcategory " +
                        "From FilmCategory filmcategory " +
                        "Left Join fetch filmcategory.category categoryName" +
                        "Left Join fetch filmcategory.film title" + " " +
                        "where filmcategory.category.categoryName  = :categoryName "
                ;
        Query query = currentSession.createQuery(hql);
        query.setParameter("categoryName", name);
        List<FilmCategory> filmCategories = query.list();
        return filmCategories;
    }

    public List<FilmCategory> findAllByFilmName(String harf) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        String hql =
                "Select filmcategory " +
                        "From FilmCategory filmcategory " +
                        "Left Join fetch filmcategory.category categoryName" +
                        "Left Join fetch filmcategory.film title" + " " +
                        "where filmcategory.film.title like :name "
                ;
        Query query = currentSession.createQuery(hql);
        query.setParameter("name", harf + "%");
        List<FilmCategory> filmCategories = query.list();
        return filmCategories;
    }

}
