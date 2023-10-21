package com.spring_peerfit_project.peerfit.repository;

import com.spring_peerfit_project.peerfit.model.Event;
import com.spring_peerfit_project.peerfit.model.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.sql.Time;

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
}
