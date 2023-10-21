package com.spring_peerfit_project.peerfit.Service;

import com.spring_peerfit_project.peerfit.model.Event;
import com.spring_peerfit_project.peerfit.model.Person;
import com.spring_peerfit_project.peerfit.model.Registration;
import com.spring_peerfit_project.peerfit.repository.EventRepository;
import com.spring_peerfit_project.peerfit.repository.PersonRepository;
import com.spring_peerfit_project.peerfit.repository.RegistrationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepo;

    @Autowired
    private EventRepository eventRepo;

    @Autowired
    private RegistrationRepository regRepo;

    //create a person, assume that we already have a person object when we call it from controller, already transformed from dto ?? ?
    @Transactional
    public void createPerson(Person person) {
        Person tmp = personRepo.findPersonById(person.getId());
        if(tmp != null) {
            throw new IllegalArgumentException("person already exists");
        }

        tmp = personRepo.findByEmail(person.getEmail());
        if(tmp != null) {
            throw new IllegalArgumentException("person with email already exists");
        }

        personRepo.save(person);
    }

    @Transactional
    public void createPersonByEmail(String email, String password, String fname, String lname) {
        Person person = personRepo.findByEmail(email);
        if(person != null) {
            throw new IllegalArgumentException("Email already exists");
        }
        personRepo.save(new Person(fname, lname, email, password));
    }

    @Transactional
    public Person getPersonById(int id) {
        Person person = personRepo.findPersonById(id);
        if(person == null) {
            throw new IllegalArgumentException("person with id doesn't exist");
        }

        return person;
    }

    @Transactional
    public Person getPersonByEmail(String email) {
        Person person = personRepo.findByEmail(email);
        if(person == null) {
            throw new IllegalArgumentException("person with email doesn't exist");
        }

        return person;
    }

    @Transactional
    public Iterable<Person> getAllPeople() {
        return personRepo.findAll();
    }

    @Transactional
    public List<Person> getPersonsFromEvent(Event event) {
        String error = "";

        if(event == null) {
            error += "event cant be null";
        } else if(eventRepo.findEventById(event.getId()) == null) {
            error += "event doesnt exist";
        }

        if(!error.isEmpty()) {
            throw new IllegalArgumentException(error);
        }

        List<Person> personList = new ArrayList<>();
        List<Registration> list = regRepo.findRegistrationsByEvent(event);
        for(Registration registration: list) {
            personList.add(registration.getPerson());
        }

        return personList;
    }
}
