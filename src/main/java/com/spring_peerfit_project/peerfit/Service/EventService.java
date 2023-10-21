package com.spring_peerfit_project.peerfit.Service;

import com.spring_peerfit_project.peerfit.model.*;
import com.spring_peerfit_project.peerfit.repository.EventRepository;
import com.spring_peerfit_project.peerfit.repository.RegistrationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepo;

    @Autowired
    private RegistrationRepository regRepo;

    @Transactional
    public void createEvent(Event event) {
        Event tmp = eventRepo.findEventById(event.getId());
        if(tmp != null) {
            throw new IllegalArgumentException("event with id already exists");
        }

        eventRepo.save(event);
    }

    @Transactional
    public Iterable<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    @Transactional
    public Event getEventById(int id) {
        Event event = eventRepo.findEventById(id);
        if(event == null) {
            throw new IllegalArgumentException("event with id doesn't exist");
        }
        return event;
    }

    @Transactional
    public List<Event> getEventsByPerson(Person person) {
        if (person == null ) {
            throw new IllegalArgumentException("Person cannot be null!");
        }

        List<Event> eventsAttendedByPerson = new ArrayList<>();
        for (Registration r : regRepo.findRegistrationsByPerson(person)) {
            eventsAttendedByPerson.add(r.getEvent());
        }
        return eventsAttendedByPerson;
    }

    @Transactional
    public List<Event> getEventsByPriceLessThan(float price) {
        List<Event> list = eventRepo.findEventsByPriceLessThan(price);
        if(list == null || list.isEmpty()) {
            throw new IllegalArgumentException("no events with specified price condition");
        }

        return list;
    }

    @Transactional
    public List<Event> getEventsByPriceBetween(float price, float price2) {
        List<Event> list = eventRepo.findEventsByPriceBetween(price, price2);
        if(list == null || list.isEmpty()) {
            throw new IllegalArgumentException("no events with specified price condition");
        }

        return list;
    }

    @Transactional
    public List<Event> getEventsBySport(Sport sport) {
        List<Event> list = eventRepo.findEventsBySport(sport);
        if(list == null || list.isEmpty()) {
            throw new IllegalArgumentException("no events with specified price condition");
        }

        return list;
    }

    @Transactional
    public List<Event> getEventsByAtm(Atmosphere atmosphere) {
        List<Event> list = eventRepo.findEventsByAtm(atmosphere);
        if(list == null || list.isEmpty()) {
            throw new IllegalArgumentException("no events with specified price condition");
        }

        return list;
    }

}
