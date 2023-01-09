package com.uniyaz.store.service;

import com.uniyaz.city.dao.CityDao;
import com.uniyaz.city.domain.City;
import com.uniyaz.store.dao.StoreDao;
import com.uniyaz.store.domain.Store;
import com.uniyaz.store.queryfilterdto.StoreQueryFilterDto;

import java.util.List;

public class StoreService {
    public List<Store> findAll() {
        StoreDao storeDao = new StoreDao();
        return storeDao.findAll();
    }
    public Store save(Store store) {
        StoreDao storeDao = new StoreDao();
        return storeDao.save(store);
    }

    public void delete(Store store) {
        StoreDao storeDao = new StoreDao();
        storeDao.delete(store);
    }

    public List<Store> findAllByQueryFilterDto(StoreQueryFilterDto storeQueryFilterDto) {
        StoreDao storeDao = new StoreDao();
        return storeDao.findAllByQueryFilterDto(storeQueryFilterDto);
    }

    public List<Store> findAllByQueryFilterDtoCriteria(StoreQueryFilterDto storeQueryFilterDto) {
        StoreDao storeDao = new StoreDao();
        return storeDao.findAllByQueryFilterDtoCriteria(storeQueryFilterDto);
    }
}
