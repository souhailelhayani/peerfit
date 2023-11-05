package com.spring_peerfit_project.peerfit.controller;

import com.spring_peerfit_project.peerfit.Service.PersonEventRelationService;
import com.spring_peerfit_project.peerfit.Service.PersonService;
import com.spring_peerfit_project.peerfit.Service.RegistrationService;
import com.spring_peerfit_project.peerfit.TransferObjects.EventResponseDto;
import com.spring_peerfit_project.peerfit.TransferObjects.PersonRequestDto;
import com.spring_peerfit_project.peerfit.TransferObjects.PersonResponseDto;
import com.spring_peerfit_project.peerfit.TransferObjects.RegistrationResponseDto;
import com.spring_peerfit_project.peerfit.model.Event;
import com.spring_peerfit_project.peerfit.model.Person;
import com.spring_peerfit_project.peerfit.model.Registration;
import com.spring_peerfit_project.peerfit.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@RestController is both @controller and @responseBody , used for json or something similar
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private PersonEventRelationService personEventRelationService;

    @GetMapping("/person")
    public ResponseEntity<List<PersonResponseDto>> getAllPeople() {
        List<Person> list = personService.getAllPeople();
        List<PersonResponseDto> dtos = new ArrayList<>();
        for(Person person: list) {
            dtos.add(new PersonResponseDto(person));
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<PersonResponseDto> getPersonById(@PathVariable("id") int id) {
        Person person = personService.getPersonById(id);
        return new ResponseEntity<>(new PersonResponseDto(person), HttpStatus.OK);
    }

    @GetMapping("/person/{id}/events")
    public ResponseEntity<List<EventResponseDto>> getEventsFromPerson(@PathVariable("id") int id) {
        List<Event> list = personEventRelationService.getEventsFromPerson(personService.getPersonById(id));
        List<EventResponseDto> dtos = new ArrayList<>();
        for(Event event: list) {
            dtos.add(new EventResponseDto(event));
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping("/person/byEmail")
    public ResponseEntity<PersonResponseDto> getPersonByEmail(@RequestParam String email) {
        Person person = personService.getPersonByEmail(email);
        return new ResponseEntity<>(new PersonResponseDto(person), HttpStatus.OK);
    }

    @PostMapping("/person/new")
    public ResponseEntity<PersonResponseDto> createPerson(@RequestBody PersonRequestDto personRequestDto) {
        Person person = personRequestDto.toModel();
        return new ResponseEntity<>(new PersonResponseDto(personService.createPerson(person)), HttpStatus.CREATED);
    }

    @GetMapping("/person/{id}/registrations")
    public ResponseEntity<List<RegistrationResponseDto>> getAllRegistrations(@PathVariable("id") int id) {
        List<Registration> list = personService.getAllRegistrations(id);
        List<RegistrationResponseDto> dtos = new ArrayList<>();
        for(Registration registration: list) {
            dtos.add(new RegistrationResponseDto(registration));
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PutMapping("/person/{id}/registrations/{reg_id}/accept")
    public ResponseEntity<RegistrationResponseDto> acceptInvite(@PathVariable("id") int id, @PathVariable("reg_id") int reg_id) {
        Registration reg = registrationService.getRegistrationById(reg_id);
        reg = registrationService.changeStatus(reg, Status.Accepted);
        return new ResponseEntity<>(new RegistrationResponseDto(reg), HttpStatus.OK);
    }

    @PutMapping("/person/{id}/registrations/{reg_id}/reject")
    public ResponseEntity<RegistrationResponseDto> rejectInvite(@PathVariable("id") int id, @PathVariable("reg_id") int reg_id) {
        Registration reg = registrationService.getRegistrationById(reg_id);
        reg = registrationService.changeStatus(reg, Status.Rejected);
        return new ResponseEntity<>(new RegistrationResponseDto(reg), HttpStatus.OK);
    }

    @PutMapping("/person/{id}/rating")
    public ResponseEntity<PersonResponseDto> ratePerson(@PathVariable("id") int id, @RequestParam float rating) {
        Person person = personService.getPersonById(id);
        person = personService.rate(person, rating);
        return new ResponseEntity<>(new PersonResponseDto(person), HttpStatus.OK);
    }

    @PutMapping("person/{id}/password")
    public ResponseEntity<PersonResponseDto> changePassword(@PathVariable("id") int id, @RequestParam String oldPassword, @RequestParam String newPassword) {
        Person person = personService.getPersonById(id);
        person = personService.changePassword(person, oldPassword, newPassword);
        return new ResponseEntity<>(new PersonResponseDto(person), HttpStatus.OK);
    }

    @DeleteMapping("person/{id}/delete")
    public void delete(@PathVariable("id") int id) {
        Person person = personService.getPersonById(id);
        personService. delete(person);
    }

}
