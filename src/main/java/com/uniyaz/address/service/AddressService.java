package com.uniyaz.address.service;

import com.uniyaz.address.dao.AddressDao;
import com.uniyaz.address.domain.Address;
import com.uniyaz.address.queryfilterdto.AddressQueryFilterDto;
import com.uniyaz.city.dao.CityDao;
import com.uniyaz.city.domain.City;
import com.uniyaz.city.queryfilterdto.CityQueryFilterDto;

import java.util.List;

public class AddressService {

    public List<Address> findAll() {
        AddressDao addressDao = new AddressDao();
        return addressDao.findAll();
    }

    public List<Address> findAllByQueryFilterDto(AddressQueryFilterDto addressQueryFilterDto) {
        AddressDao addressDao = new AddressDao();
        return addressDao.findAllByQueryFilterDto(addressQueryFilterDto);
    }

    public List<Address> findAllByQueryFilterDtoDetachedCriteria(String city) {
        AddressDao addressDao = new AddressDao();
        return addressDao.findAllByQueryFilterDtoDetachedCriteria(city);
    }
}
