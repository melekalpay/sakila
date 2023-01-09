package com.uniyaz.inventory.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.inventory.domain.Inventory;
import com.uniyaz.inventory.queryfilterdto.InventoryQueryFilterDto;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import java.util.List;

public class InventoryDao {

    public List<Inventory> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery
                ("Select inventory" + " " +
                        "From Inventory inventory" + " "+
                        "Left join fetch inventory.film title" + " "+
                        "Left join fetch inventory.store id");
        List<Inventory> inventories = query.list();
        return inventories;
    }



    public List<Inventory> findAllByQueryFilterDto(InventoryQueryFilterDto inventoryQueryFilterDto) {
        String hql =
                "Select inventory " +
                        "From Inventory inventory " +
                        "Left Join fetch inventory.film title " +
                        "Left Join fetch inventory.store id " +
                        "where 1=1 ";

        if (inventoryQueryFilterDto.getId() != null) hql += " and inventory.id = :inventoryId";
        if (inventoryQueryFilterDto.getFilm() != null) hql += " and inventory.film.title = :film";
        if (inventoryQueryFilterDto.getStore() != null) hql += " and inventory.store.id = :store";

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (inventoryQueryFilterDto.getId() != null) query.setParameter("inventoryId", inventoryQueryFilterDto.getId());

        if (inventoryQueryFilterDto.getFilm() != null) query.setParameter("film", inventoryQueryFilterDto.getFilm().getTitle());

        if (inventoryQueryFilterDto.getStore() != null) query.setParameter("store", inventoryQueryFilterDto.getStore().getId());

        List<Inventory> inventoryList = query.list();
        return inventoryList;
    }

    public List<Inventory> findAllByQueryFilterDtoCriteria(InventoryQueryFilterDto inventoryQueryFilterDto) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Criteria criteria = currentSession.createCriteria(Inventory.class);
        criteria.createAlias("film", "filmAlias", JoinType.LEFT_OUTER_JOIN);
        criteria.createAlias("store", "storeAlias", JoinType.LEFT_OUTER_JOIN);

        if (inventoryQueryFilterDto.getId() != null)
            criteria.add(Restrictions.eq("id", inventoryQueryFilterDto.getId()));
        if (inventoryQueryFilterDto.getFilm() != null)
            criteria.add(Restrictions.eq("filmAlias.title", inventoryQueryFilterDto.getFilm().getTitle()));
        if (inventoryQueryFilterDto.getStore() != null)
            criteria.add(Restrictions.eq("storeAlias.id", inventoryQueryFilterDto.getStore().getId()));

        List<Inventory> inventoryList = criteria.list();
        return inventoryList;
    }
}
