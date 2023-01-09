package com.uniyaz.film_actor.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.address.domain.Address;
import com.uniyaz.address.queryfilterdto.AddressQueryFilterDto;
import com.uniyaz.customer.domain.Customer;
import com.uniyaz.customer.queryfilterdto.CustomerQueryFilterDto;
import com.uniyaz.film_actor.domain.FilmActor;
import com.uniyaz.film_actor.queryfilterdto.FilmActorQueryFilterDto;
import com.uniyaz.film_category.domain.FilmCategory;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import java.util.List;

public class
FilmActorDao {

    public List<FilmActor> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        String hql =
                "Select filmactor " +
                        "From FilmActor filmactor " +
                        "Left Join fetch filmactor.actor firstName " +
                        "Left Join fetch filmactor.film title" +
                        " "
                ;
        Query query = currentSession.createQuery(hql);
        List<FilmActor> filmActorList = query.list();
        return filmActorList;
    }

    public FilmActor save(FilmActor filmActor) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        filmActor = (FilmActor) currentSession.merge(filmActor);
        transaction.commit();
        return filmActor;
    }

    public void delete(FilmActor filmActor) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(filmActor);
        transaction.commit();
    }

    public List<FilmActor> findAllByQueryFilterDto(FilmActorQueryFilterDto filmActorQueryFilterDto) {

        String hql =
                "Select fa " +
                        "From FilmActor fa " +
                        "Left Join fetch fa.actor firstName " +
                        "Left Join fetch fa.film id " +
                        "where 1=1 ";

        if (filmActorQueryFilterDto.getId() != null) {
            hql += " and fa.id = :faId";
        }

        if (filmActorQueryFilterDto.getActor() != null) {
            hql += " and fa.actor.firstName = :actor";
        }

        if (filmActorQueryFilterDto.getFilm() != null) {
            hql += " and fa.film.id = :filmId ";
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (filmActorQueryFilterDto.getId() != null) {
            query.setParameter("faId", filmActorQueryFilterDto.getId());
        }

        if (filmActorQueryFilterDto.getActor() != null) {
            query.setParameter("actor", filmActorQueryFilterDto.getActor().getFirstName());
        }

        if (filmActorQueryFilterDto.getFilm() != null) {
            query.setParameter("filmId", filmActorQueryFilterDto.getFilm().getId());
        }

        List<FilmActor> filmActors = query.list();
        return filmActors;
    }

    public List<FilmActor> findAllByQueryFilterDtoCriteria(FilmActorQueryFilterDto filmActorQueryFilterDto) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Criteria criteria = currentSession.createCriteria(FilmActor.class);
        criteria.createAlias("film", "filmAlias", JoinType.LEFT_OUTER_JOIN);
        criteria.createAlias("actor", "actorAlias", JoinType.LEFT_OUTER_JOIN);

        if (filmActorQueryFilterDto.getId() != null) {
            criteria.add(Restrictions.eq("id", filmActorQueryFilterDto.getId()));
        }

        if (filmActorQueryFilterDto.getFilm() != null) {
            criteria.add(Restrictions.eq("filmAlias.id", filmActorQueryFilterDto.getFilm().getId()));
        }

        if (filmActorQueryFilterDto.getActor() != null) {
            criteria.add(Restrictions.eq("actorAlias.firstName", filmActorQueryFilterDto.getActor().getFirstName()));
        }

        List<FilmActor> filmActors = criteria.list();
        return filmActors;
    }
    public List<FilmActor> findAllByActorName(String name) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        String hql =
                "Select filmactor " +
                        "From FilmActor filmactor " +
                        "Left Join fetch filmactor.film title" +
                        "Left Join fetch filmactor.actor firstName" + " " +
                        "where filmactor.actor.firstName  = :firstName "
                ;
        Query query = currentSession.createQuery(hql);
        query.setParameter("firstName", name);
        List<FilmActor> filmActors = query.list();
        return filmActors;
    }
}