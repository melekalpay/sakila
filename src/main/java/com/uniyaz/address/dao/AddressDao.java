package com.uniyaz.address.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.actor.domain.Actor;
import com.uniyaz.actor.queryfilterdto.ActorQueryFilterDto;
import com.uniyaz.address.domain.Address;
import com.uniyaz.address.queryfilterdto.AddressQueryFilterDto;
import com.uniyaz.city.domain.City;
import com.uniyaz.city.queryfilterdto.CityQueryFilterDto;
import com.uniyaz.country.domain.Country;
import org.hibernate.*;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class AddressDao {

    public List<Address> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        String hql =
                "Select adres " +
                        "From Address adres " +
                        "Left Join fetch adres.city city"
                ;
        Query query = currentSession.createQuery(hql);
        List<Address> addresses = query.list();
        return addresses;
    }

    public List<Address> findAllByQueryFilterDto(AddressQueryFilterDto addressQueryFilterDto) {

        String hql =
                "Select adres " +
                        "From Address adres " +
                        "Left Join fetch adres.city city " +
                        "where 1=1 ";

        if (addressQueryFilterDto.getId() != null) {
            hql += " and adres.id = :adresId";
        }

        if (addressQueryFilterDto.getCity() != null) {
            hql += " and adres.city.city = :city";
        }

        if (addressQueryFilterDto.getDistrict() != null) {
            hql += " and adres.district = :district ";
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (addressQueryFilterDto.getId() != null) {
            query.setParameter("adresId", addressQueryFilterDto.getId());
        }

        if (addressQueryFilterDto.getCity() != null) {
            query.setParameter("city", addressQueryFilterDto.getCity().getCity());
        }

        if (addressQueryFilterDto.getDistrict() != null) {
            query.setParameter("district", addressQueryFilterDto.getDistrict());
        }

        List<Address> addresses = query.list();
        return addresses;
    }

    public List<Address> findAllByQueryFilterDtoDetachedCriteria(String cityName) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Criteria criteria = currentSession.createCriteria(Address.class);
        //criteria.createAlias("country", "countryAlias", JoinType.LEFT_OUTER_JOIN);
        //criteria.add(Restrictions.eq("cityAlias.city", cityName));

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(City.class);
        detachedCriteria.add(Restrictions.eq("city", cityName));
        detachedCriteria.setProjection(Projections.property("id"));

        criteria.add(Property.forName("city.id").in(detachedCriteria));

        List<Address> addresses = criteria.list();
        return addresses;
    }




}
