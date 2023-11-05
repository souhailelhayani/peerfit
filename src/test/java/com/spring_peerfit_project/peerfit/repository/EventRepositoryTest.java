package com.spring_peerfit_project.peerfit.repository;

import com.spring_peerfit_project.peerfit.model.Event;
import com.spring_peerfit_project.peerfit.model.Person;
import com.spring_peerfit_project.peerfit.model.Sport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class EventRepositoryTest {
    @Autowired
    EventRepository repo;

    @AfterEach
    public void clearDatabase() {
        this.repo.deleteAll();
    }
    @Test
    public void createAndRetrieveEventById() {
        Event event = new Event(Date.valueOf("2023-09-09"), Time.valueOf("09:00:00"), 120, 10, 20.0f, null);
        event = repo.save(event);

        Event test = repo.findEventById(event.getId());

        assertNotNull(test);
        assertEquals(event.getId(), test.getId());
        assertEquals(event.getDuration(), test.getDuration());
        assertEquals(event.getStartDate(), test.getStartDate());
        assertEquals(event.getStartTime(), test.getStartTime());
        assertEquals(event.getPrice(), test.getPrice());
        assertEquals(event.getNumOfPlayers(), test.getNumOfPlayers());
        assertEquals(event.getGroup(), test.getGroup());
    }

    @Test
    public void createAndRetrieveEventBySport() {
        Event event = new Event(Date.valueOf("2023-09-09"), Time.valueOf("09:00:00"), 120, "aad", 10, null,null, Sport.basket, 20.0f, false);
        event = repo.save(event);

        Event event1 = new Event(Date.valueOf("2023-09-09"), Time.valueOf("09:00:00"), 120,"ada", 10,null,null, Sport.foot, 20.0f, true);
        event1 = repo.save(event1);

        List<Event> test = repo.findEventsBySport(event.getSport());

        assertEquals(1, test.size());
        assertEquals(Sport.basket, test.get(0).getSport());

        test = repo.findEventsBySport(event1.getSport());

        assertEquals(1, test.size());
        assertEquals(Sport.foot, test.get(0).getSport());
//
//        assertNotNull(test);
//        assertEquals(event.getId(), test.getId());
//        assertEquals(event.getDuration(), test.getDuration());
//        assertEquals(event.getStartDate(), test.getStartDate());
//        assertEquals(event.getStartTime(), test.getStartTime());
//        assertEquals(event.getPrice(), test.getPrice());
//        assertEquals(event.getNumOfPlayers(), test.getNumOfPlayers());
//        assertEquals(event.getGroup(), test.getGroup());
    }
}
