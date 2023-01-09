package com.uniyaz.staff.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.film_category.domain.FilmCategory;
import com.uniyaz.staff.domain.Staff;
import com.uniyaz.staff.queryfilterdto.StaffQueryFilterDto;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import java.util.List;

public class StaffDao {
    public List<Staff> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        String hql =
                "Select s " +
                        "From Staff s " +
                        "Left Join fetch s.address address " +
                        "Left Join fetch staff.store id "
        ;
        Query query = currentSession.createQuery(hql);
        List<Staff> staffList = query.list();
        return staffList;
    }


    public Staff save(Staff staff) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        staff = (Staff) currentSession.merge(staff);
        transaction.commit();
        return staff;
    }

    public void delete(Staff staff) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(staff);
        transaction.commit();
    }


    public List<Staff> findAllByQueryFilterDto(StaffQueryFilterDto staffQueryFilterDto) {

        String hql = "Select staff " +
                "From Staff staff " +
                "Left Join fetch staff.address district " +
                "Left Join fetch staff.store id " +
                "where 1=1 ";

        if (staffQueryFilterDto.getId() != null) {
            hql += " and staff.id = :staffId";
        }

        if (staffQueryFilterDto.getFirstName() != null) {
            hql += " and staff.firstName = :firstName";
        }

        if (staffQueryFilterDto.getAddress() != null) {
            hql += " and staff.address.district = :address ";
        }

        if (staffQueryFilterDto.getStore() != null) {
            hql += " and staff.store.id = :store ";
        }


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (staffQueryFilterDto.getId() != null) {
            query.setParameter("staffId", staffQueryFilterDto.getId());
        }

        if (staffQueryFilterDto.getFirstName() != null) {
            query.setParameter("firstName", staffQueryFilterDto.getFirstName());
        }

        if (staffQueryFilterDto.getAddress() != null) {
            query.setParameter("address", staffQueryFilterDto.getAddress().getDistrict());
        }

        if (staffQueryFilterDto.getStore() != null) {
            query.setParameter("store", staffQueryFilterDto.getStore().getId());
        }


        List<Staff> staffList = query.list();
        return staffList;
    }

    public List<Staff> findAllByQueryFilterDtoCriteria(StaffQueryFilterDto staffQueryFilterDto) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Criteria criteria = currentSession.createCriteria(Staff.class);
        criteria.createAlias("address", "addressAlias", JoinType.LEFT_OUTER_JOIN);
        criteria.createAlias("store", "storeAlias", JoinType.LEFT_OUTER_JOIN);

        if (staffQueryFilterDto.getId() != null) {
            criteria.add(Restrictions.eq("id", staffQueryFilterDto.getId()));
        }

        if (staffQueryFilterDto.getFirstName() != null) {
            criteria.add(Restrictions.eq("firstName", staffQueryFilterDto.getFirstName()));
        }

        if (staffQueryFilterDto.getAddress() != null) {
            criteria.add(Restrictions.eq("addressAlias.district", staffQueryFilterDto.getAddress().getDistrict()));
        }

        if (staffQueryFilterDto.getStore() != null) {
            criteria.add(Restrictions.eq("storeAlias.id", staffQueryFilterDto.getStore().getId()));
        }


        List<Staff> staffList = criteria.list();
        return staffList;
    }
}
