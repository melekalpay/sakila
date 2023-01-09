package com.uniyaz.category.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.category.domain.Category;
import com.uniyaz.category.queryfilterdto.CategoryQueryFilterDto;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CategoryDao {
    public List<Category> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select category From Category category");
        List<Category> categories = query.list();
        return categories;
    }

    public Category save(com.uniyaz.category.domain.Category category) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        category = (Category) currentSession.merge(category);
        transaction.commit();
        return category;
    }

    public void delete(Category category) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(category);
        transaction.commit();
    }

    public List<Category> findAllByName(String name) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select category From Category category where category.categoryName = :name ");
        query.setParameter("name", name);
        List<Category> categories = query.list();
        return categories;
    }

    public List<Category> findAllByQueryFilterDto(CategoryQueryFilterDto categoryQueryFilterDto) {

        String hql =
                "Select category " +
                        "From Category category " +
                        "where 1=1 ";

        if (categoryQueryFilterDto.getId() != null) {
            hql += " and category.id = :categoryId";
        }

        if (categoryQueryFilterDto.getCategoryName()!= null) {
            hql += " and category.categoryName = :categoryName";
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (categoryQueryFilterDto.getId() != null) {
            query.setParameter("categoryId", categoryQueryFilterDto.getId());
        }

        if (categoryQueryFilterDto.getCategoryName() != null) {
            query.setParameter("categoryName", categoryQueryFilterDto.getCategoryName());
        }

        List<Category> categories = query.list();
        return categories;
    }

    public List<Category> findAllByQueryFilterDtoCriteria(CategoryQueryFilterDto categoryQueryFilterDto) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Criteria criteria = currentSession.createCriteria(Category.class);

        if (categoryQueryFilterDto.getId() != null) {
            criteria.add(Restrictions.eq("id", categoryQueryFilterDto.getId()));
        }

        if (categoryQueryFilterDto.getCategoryName() != null) {
            criteria.add(Restrictions.eq("categoryName", categoryQueryFilterDto.getCategoryName()));
        }

        List<Category> categories = criteria.list();
        return categories;
    }
}
