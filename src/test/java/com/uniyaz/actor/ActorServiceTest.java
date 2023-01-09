package com.uniyaz.actor;

import com.uniyaz.actor.dao.ActorDao;
import com.uniyaz.actor.domain.Actor;
import com.uniyaz.actor.queryfilterdto.ActorQueryFilterDto;
import com.uniyaz.actor.service.ActorService;

import org.junit.Test;

import java.util.Date;
import java.util.List;

public class ActorServiceTest {
   @Test
    public void findAllTest() {

        ActorService actorService = new ActorService();
        List<Actor> actors = actorService.findAll();
        for (Actor actor : actors) {
            System.out.println(actor);
        }


    }
    @Test
    public void insertTest(){
        ActorService actorService = new ActorService();
        Actor actor= new Actor();
        Date date = new Date();
        actor.setLastUpdate(date);
        actor.setFirstName("Melek");
        actor.setLastName("Alpay");
        actorService.save(actor);
    }

    @Test
    public void deleteTest(){
        ActorService actorService = new ActorService();
        Actor actor= new Actor();
        actor.setId(205L);
        actorService.delete(actor);
    }

    @Test
    public void findByName(){
        String name="Penelope";
        ActorService actorService = new ActorService();
        List<Actor> actors = actorService.findAllByName(name);
        for (Actor actor : actors) {
            System.out.println(actor);
        }
    }

    @Test
    public void findAllQueryFilterDto(){
        ActorQueryFilterDto actorQueryFilterDto = new ActorQueryFilterDto();
        actorQueryFilterDto.setFirstName("Penelope");
        ActorDao actorDao = new ActorDao();
        List<Actor> actors= actorDao.findAllByQueryFilterDto(actorQueryFilterDto);
        for (Actor actor : actors) {
            System.out.println(actor);
        }

    }
}
