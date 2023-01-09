package com.uniyaz.customer.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.city.domain.City;
import com.uniyaz.city.queryfilterdto.CityQueryFilterDto;
import com.uniyaz.customer.domain.Customer;
import com.uniyaz.customer.queryfilterdto.CustomerQueryFilterDto;
import com.uniyaz.film_category.domain.FilmCategory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import java.util.List;

public class CustomerDao {
    public List<Customer> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        String hql =
                "Select customer " +
                        "From Customer customer " +
                        "Left Join fetch customer.address address " +
                        "Left Join fetch customer.store id" +
                        " "
                ;
        Query query = currentSession.createQuery(hql);
        List<Customer> customers = query.list();
        return customers;
    }

    public List<Customer> findAllByQueryFilterDto(CustomerQueryFilterDto customerQueryFilterDto) {

        String hql =
                "Select customer " +
                        "From Customer customer " +
                        "Left Join fetch customer.address district " +
                        "Left Join fetch customer.store id " +
                        "where 1=1 ";

        if (customerQueryFilterDto.getFirstName() != null) {
            hql += " and customer.firstName = :name";
        }

        if (customerQueryFilterDto.getAddress() != null) {
            hql += " and customer.address.district = :district";
        }

        if (customerQueryFilterDto.getStore() != null) {
            hql += " and customer.store.id = :id ";
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (customerQueryFilterDto.getFirstName() != null) {
            query.setParameter("name", customerQueryFilterDto.getFirstName());
        }
        if (customerQueryFilterDto.getAddress() != null) {
            query.setParameter("district", customerQueryFilterDto.getAddress().getDistrict());
        }

        if (customerQueryFilterDto.getStore() != null) {
            query.setParameter("id", customerQueryFilterDto.getStore().getId());
        }

        List<Customer> customers = query.list();
        return customers;
    }
    public List<Customer> findAllByQueryFilterDtoCriteria(CustomerQueryFilterDto customerQueryFilterDto) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Criteria criteria = currentSession.createCriteria(Customer.class);
        criteria.createAlias("address", "addressAlias", JoinType.LEFT_OUTER_JOIN);
        criteria.createAlias("store", "storeAlias", JoinType.LEFT_OUTER_JOIN);

        if (customerQueryFilterDto.getFirstName() != null) {
            criteria.add(Restrictions.eq("firstName", customerQueryFilterDto.getFirstName()));
        }

        if (customerQueryFilterDto.getAddress() != null) {
            criteria.add(Restrictions.eq("addressAlias.district", customerQueryFilterDto.getAddress().getDistrict()));
        }

        if (customerQueryFilterDto.getStore() != null) {
            criteria.add(Restrictions.eq("storeAlias.id", customerQueryFilterDto.getStore().getId()));
        }

        List<Customer> customers = criteria.list();
        return customers;
    }

}
