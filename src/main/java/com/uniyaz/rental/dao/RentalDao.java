package com.uniyaz.rental.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.rental.domain.Rental;
import com.uniyaz.rental.queryfilterdto.RentalQueryFilterDto;
import com.uniyaz.staff.domain.Staff;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import java.util.List;

public class RentalDao {

    public List<Rental> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        String hql =
                "Select rental " +
                        "From Rental rental " +
                        "Left Join fetch rental.staff firstName "+
                        "Left Join fetch rental.customer firstName " +
                        "Left Join fetch rental.inventory id "
                ;
        Query query = currentSession.createQuery(hql);
        List<Rental> rentals = query.list();
        return rentals;
    }

    public List<Rental> findAllByQueryFilterDto(RentalQueryFilterDto rentalQueryFilterDto) {
        String hql =
                "Select rental " +
                        "From Rental rental " +
                        "Left Join fetch rental.customer firstName " +
                        "Left Join fetch rental.staff firstName " +
                        "Left Join fetch rental.inventory id " +
                        "where 1=1 ";

        if (rentalQueryFilterDto.getId() != null) hql += " and rental.id = :rentalId";
        if (rentalQueryFilterDto.getInventory() != null) hql += " and rental.inventory.id = :inventory ";
        if (rentalQueryFilterDto.getCustomer() != null) hql += " and rental.customer.firstName = :customer ";
        if (rentalQueryFilterDto.getStaff() != null) hql += " and rental.staff.firstName = :staff ";

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (rentalQueryFilterDto.getId() != null) query.setParameter("rentalId", rentalQueryFilterDto.getId());
        if (rentalQueryFilterDto.getInventory() != null)
            query.setParameter("inventory", rentalQueryFilterDto.getInventory().getId());
        if (rentalQueryFilterDto.getCustomer() != null)
            query.setParameter("customer", rentalQueryFilterDto.getCustomer().getFirstName());
        if (rentalQueryFilterDto.getStaff() != null) query.setParameter("staff", rentalQueryFilterDto.getStaff().getFirstName());

        List<Rental> rentalList = query.list();
        return rentalList;
    }

    public List<Rental> findAllByQueryFilterDtoCriteria(RentalQueryFilterDto rentalQueryFilterDto) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Criteria criteria = currentSession.createCriteria(Rental.class);
        criteria.createAlias("inventory", "inventoryAlias", JoinType.LEFT_OUTER_JOIN);
        criteria.createAlias("customer", "customerAlias", JoinType.LEFT_OUTER_JOIN);
        criteria.createAlias("staff", "staffAlias", JoinType.LEFT_OUTER_JOIN);

        if (rentalQueryFilterDto.getId() != null) criteria.add(Restrictions.eq("id", rentalQueryFilterDto.getId()));
        if (rentalQueryFilterDto.getInventory() != null) criteria.add(Restrictions.eq("inventoryAlias.id", rentalQueryFilterDto.getInventory().getId()));
        if (rentalQueryFilterDto.getCustomer() != null) criteria.add(Restrictions.eq("customerAlias.firstName", rentalQueryFilterDto.getCustomer().getFirstName()));
        if (rentalQueryFilterDto.getStaff() != null) criteria.add(Restrictions.eq("staffAlias.firstName", rentalQueryFilterDto.getStaff().getFirstName()));

        List<Rental> rentalList = criteria.list();
        return rentalList;
    }
}
