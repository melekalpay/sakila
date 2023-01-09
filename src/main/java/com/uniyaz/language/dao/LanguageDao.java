package com.uniyaz.language.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.actor.domain.Actor;
import com.uniyaz.actor.queryfilterdto.ActorQueryFilterDto;
import com.uniyaz.language.domain.Language;
import com.uniyaz.language.queryfilterdto.LanguageQueryFilterDto;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class LanguageDao {

    public List<Language> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select lang From Language lang");
        List<Language> languages = query.list();
        return languages;
    }
    public Language save(Language language) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        language = (Language) currentSession.merge(language);
        transaction.commit();
        return language;
    }

    public void delete(Language language) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(language);
        transaction.commit();
    }

    public List<Language> findAllByName(String name) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select lang From Language lang where lang.languageName = :name ");
        query.setParameter("name", name);
        List<Language> languages = query.list();
        return languages;
    }

    public List<Language> findAllByQueryFilterDto(LanguageQueryFilterDto languageQueryFilterDto) {

        String hql =
                "Select lang " +
                        "From Language lang " +
                        "where 1=1 ";

        if (languageQueryFilterDto.getId() != null) {
            hql += " and lang.id = :langId";
        }

        if (languageQueryFilterDto.getLanguageName() != null) {
            hql += " and lang.languageName = :langName";
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (languageQueryFilterDto.getId() != null) {
            query.setParameter("langId", languageQueryFilterDto.getId());
        }

        if (languageQueryFilterDto.getLanguageName() != null) {
            query.setParameter("langName", languageQueryFilterDto.getLanguageName());
        }

        List<Language> languages = query.list();
        return languages;
    }


    public List<Language> findAllByQueryFilterDtoCriteria(LanguageQueryFilterDto languageQueryFilterDto) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Criteria criteria = currentSession.createCriteria(Language.class);

        if (languageQueryFilterDto.getId() != null) {
            criteria.add(Restrictions.eq("id", languageQueryFilterDto.getId()));
        }

        if (languageQueryFilterDto.getLanguageName() != null) {
            criteria.add(Restrictions.eq("languageName", languageQueryFilterDto.getLanguageName()));
        }

        List<Language> languages = criteria.list();
        return languages;
    }
}
