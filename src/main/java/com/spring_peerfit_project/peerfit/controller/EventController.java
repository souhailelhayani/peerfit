package com.spring_peerfit_project.peerfit.controller;

import com.spring_peerfit_project.peerfit.Service.EventService;
import com.spring_peerfit_project.peerfit.Service.PersonEventRelationService;
import com.spring_peerfit_project.peerfit.Service.PersonService;
import com.spring_peerfit_project.peerfit.Service.RegistrationService;
import com.spring_peerfit_project.peerfit.TransferObjects.EventRequestDto;
import com.spring_peerfit_project.peerfit.TransferObjects.EventResponseDto;
import com.spring_peerfit_project.peerfit.TransferObjects.PersonResponseDto;
import com.spring_peerfit_project.peerfit.TransferObjects.RegistrationResponseDto;
import com.spring_peerfit_project.peerfit.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private PersonEventRelationService personEventRelationService;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private PersonService personService;


    @GetMapping("/event")
    public ResponseEntity<List<EventResponseDto>> getAllEvents() {
        List<Event> list = eventService.getAllEvents();
        List<EventResponseDto> dtos = new ArrayList<>();
        for(Event event: list) {
            dtos.add(new EventResponseDto(event));
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/event/{id}")
    public ResponseEntity<EventResponseDto> getEventById(@PathVariable("id") int id) {
        return new ResponseEntity<>(new EventResponseDto(eventService.getEventById(id)), HttpStatus.OK);
    }

    @GetMapping("/event/filerBySport")
    public ResponseEntity<List<EventResponseDto>> getEventBySport(@RequestParam String sport) {
        List<Event> list = eventService.getEventsBySport(Sport.valueOf(sport));
        List<EventResponseDto> dtos = new ArrayList<>();
        for(Event event: list) {
            dtos.add(new EventResponseDto(event));
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/event/filerByAtm")
    public ResponseEntity<List<EventResponseDto>> getEventByAtm(@RequestParam String atm) {
        List<Event> list = eventService.getEventsByAtm(Atmosphere.valueOf(atm));
        List<EventResponseDto> dtos = new ArrayList<>();
        for(Event event: list) {
            dtos.add(new EventResponseDto(event));
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/event/filerByLevel")
    public ResponseEntity<List<EventResponseDto>> getEventByLevel(@RequestParam String level) {
        List<Event> list = eventService.getEventsByLevel(Level.valueOf(level));
        List<EventResponseDto> dtos = new ArrayList<>();
        for(Event event: list) {
            dtos.add(new EventResponseDto(event));
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/event/filerByPrice")
    public ResponseEntity<List<EventResponseDto>> getEventByPriceLessThan(@RequestParam float price) {
        List<Event> list = eventService.getEventsByPriceLessThan(price);
        List<EventResponseDto> dtos = new ArrayList<>();
        for(Event event: list) {
            dtos.add(new EventResponseDto(event));
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/event/{id}/participants")
    public ResponseEntity<List<PersonResponseDto>> getAcceptedPeopleFromEvent(@PathVariable("id") int id) {
        List<Person> list = personEventRelationService.getAcceptedPersonsFromEvent(eventService.getEventById(id));
        List<PersonResponseDto> dtos = new ArrayList<>();
        for(Person person: list) {
            dtos.add(new PersonResponseDto(person));
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/event/{id}/participants/pending")
    public ResponseEntity<List<PersonResponseDto>> getPendingPeopleFromEvent(@PathVariable("id") int id) {
        List<Person> list = personEventRelationService.getPendingPersonsFromEvent(eventService.getEventById(id));
        List<PersonResponseDto> dtos = new ArrayList<>();
        for(Person person: list) {
            dtos.add(new PersonResponseDto(person));
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    //TODO with login can get person id without needing it as a parameter
    @PostMapping("/event/new")
    public ResponseEntity<EventResponseDto> createEvent(@RequestParam int personId, @RequestBody EventRequestDto eventRequested) {
        Event event = eventService.createEvent(eventRequested.toModel());
        registrationService.createRegistration(new Registration(personService.getPersonById(personId), event), true, Status.Accepted, false );
        return new ResponseEntity<>(new EventResponseDto(event), HttpStatus.CREATED);
    }

    //TODO with login can get person id without needing it as a parameter
    @PostMapping("/event/{id}/join")
    public ResponseEntity<EventResponseDto> joinEvent(@PathVariable("id") int id, @RequestParam int personId, @RequestParam boolean paymentByCard) {
        Event event = eventService.getEventById(id);
        registrationService.createRegistration(new Registration(personService.getPersonById(personId), event), false, Status.Requested, false );
        return new ResponseEntity<>(new EventResponseDto(event), HttpStatus.CREATED);
    }

    //TODO with login can get person id without needing it as a parameter
    @PostMapping("/event/{id}/invite")
    public ResponseEntity<EventResponseDto> inviteToEvent(@PathVariable("id") int id, @RequestParam String email) {
        Event event = eventService.getEventById(id);
        registrationService.createRegistration(new Registration(personService.getPersonByEmail(email), event), false, Status.Invited, false );
        return new ResponseEntity<>(new EventResponseDto(event), HttpStatus.CREATED);
    }

    @GetMapping("/event/{id}/registrations")
    public ResponseEntity<List<RegistrationResponseDto>> getAllRegistrations(@PathVariable("id") int id) {
        List<Registration> list = eventService.getAllRegistrations(id);
        List<RegistrationResponseDto> dtos = new ArrayList<>();
        for(Registration registration: list) {
            dtos.add(new RegistrationResponseDto(registration));
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/event/{id}/registrations/requests")
    public ResponseEntity<List<RegistrationResponseDto>> getAllPendingRegistrations(@PathVariable("id") int id) {
        List<Registration> list = eventService.getAllPendingRegistrations(id);
        List<RegistrationResponseDto> dtos = new ArrayList<>();
        for(Registration registration: list) {
            dtos.add(new RegistrationResponseDto(registration));
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PutMapping("/event/{id}/registrations/{reg_id}/reject")
    public void rejectRequest(@PathVariable("id") int id, @PathVariable("reg_id") int reg_id) {
        registrationService.changeStatus(registrationService.getRegistrationById(reg_id), Status.Rejected);
    }

    //TODO when adding login and authenticate, only delete event if organizer is TRUE for person logged in
    @DeleteMapping("/event/{id}/delete")
    public void delete(@PathVariable("id") int id) {
        eventService.delete(eventService.getEventById(id));
    }

}
