package com.uniyaz.inventory.service;

import com.uniyaz.city.dao.CityDao;
import com.uniyaz.city.domain.City;
import com.uniyaz.inventory.dao.InventoryDao;
import com.uniyaz.inventory.domain.Inventory;
import com.uniyaz.inventory.queryfilterdto.InventoryQueryFilterDto;

import java.util.List;

public class InventoryService {
    public List<Inventory> findAll() {
        InventoryDao inventoryDao = new InventoryDao();
        return inventoryDao.findAll();
    }
    public List<Inventory> findAllByQueryFilterDto(InventoryQueryFilterDto inventoryQueryFilterDto) {
        InventoryDao inventoryDao = new InventoryDao();
        return inventoryDao.findAllByQueryFilterDto(inventoryQueryFilterDto);
    }

    public List<Inventory> findAllByQueryFilterDtoCriteria(InventoryQueryFilterDto inventoryQueryFilterDto) {
        InventoryDao inventoryDao = new InventoryDao();
        return inventoryDao.findAllByQueryFilterDtoCriteria(inventoryQueryFilterDto);
    }
}
