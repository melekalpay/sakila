package com.uniyaz.inventory;

import com.uniyaz.film_category.domain.FilmCategory;
import com.uniyaz.film_category.service.FilmCategoryService;
import com.uniyaz.inventory.domain.Inventory;
import com.uniyaz.inventory.service.InventoryService;
import org.junit.Test;

import java.util.List;

public class InventoryServiceTest {
    @Test
    public void findAllTest() {

        InventoryService inventoryService = new InventoryService();
        List<Inventory> inventories = inventoryService.findAll();
        for (Inventory inventory : inventories) {
            System.out.println(inventory);
        }

    }
}
