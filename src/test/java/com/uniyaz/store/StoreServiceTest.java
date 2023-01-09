package com.uniyaz.store;

import com.uniyaz.film_actor.domain.FilmActor;
import com.uniyaz.film_actor.service.FilmActorService;
import com.uniyaz.store.domain.Store;
import com.uniyaz.store.service.StoreService;
import org.junit.Test;

import java.util.List;

public class StoreServiceTest {

    @Test
    public void findAllTest() {

        StoreService storeService = new StoreService();
        List<Store> stores = storeService.findAll();
        for (Store store : stores) {
            System.out.println(store);
        }

    }
}
