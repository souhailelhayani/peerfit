package com.spring_peerfit_project.peerfit.Service;

import com.spring_peerfit_project.peerfit.model.*;
import com.spring_peerfit_project.peerfit.repository.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepo;

    @Autowired
    private PersonEventRelationService personEventRelationService;

    @Transactional
    public Event createEvent(Event event) {
        //check event is valid
        if(!isValid(event)) {
            throw new IllegalArgumentException("invalid numbers");
        }
        event = eventRepo.save(event);
        return event;
    }

    @Transactional
    public List<Event> getAllEvents() {
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
            throw new IllegalArgumentException("Person cannot be null");
        }

        //person passed from personRequestDto should have an id (maybe from path variable ?)
        return personEventRelationService.getEventsFromPerson(person);
    }

    @Transactional
    public List<Event> getEventsByPriceLessThan(float price) {
        return eventRepo.findEventsByPriceLessThan(price);
    }

    @Transactional
    public List<Event> getEventsByPriceBetween(float price, float price2) {
        return eventRepo.findEventsByPriceBetween(price, price2);
    }

    @Transactional
    public List<Event> getEventsBySport(Sport sport) {
        return eventRepo.findEventsBySport(sport);
    }

    @Transactional
    public List<Event> getEventsByAtm(Atmosphere atmosphere) {
        return eventRepo.findEventsByAtm(atmosphere);
    }

    @Transactional
    public List<Event> getEventsByLevel(Level lvl) {
        return eventRepo.findEventsByLevel(lvl);
    }

    @Transactional
    public void delete(Event event) {
        //get all registrations and delete them all
        List<Registration> list = personEventRelationService.getRegistrationsByEvent(event);
        for(Registration registration: list) {
            personEventRelationService.deleteRegistration(registration);
        }
        eventRepo.delete(event);
    }

    private static boolean isValid(Event event) {
        return !(event.getPrice() < 0 || event.getNumOfPlayers() <= 0 || event.getDuration() <= 0 || event.getAddress().isBlank());
    }

}
