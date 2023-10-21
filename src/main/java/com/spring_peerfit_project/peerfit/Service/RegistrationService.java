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
public class RegistrationService {

    @Autowired
    private RegistrationRepository regRepo;

    @Autowired
    private PersonRepository personRepo;

    @Autowired
    private EventRepository eventRepo;

    @Transactional
    public void createRegistration(Event event, Person person) {
        String error = "";
        if(event == null || person == null) {
            error += "person or event can't be null";
        }

        if(person != null && event != null) {
            if(personRepo.findPersonById(person.getId()) == null) {
                error += "person doesnt exist";
            } else if(eventRepo.findEventById(event.getId()) == null) {
                error += "event doesnt exist";
            } else if(isPersonInEvent(person, event)) {
                error += "person already registered in event";
            }
        }

        if(!error.isEmpty()) {
            throw new IllegalArgumentException(error);
        }

        Registration registration = new Registration(person, event);
        regRepo.save(registration);
    }

    //TODO test this, maybe it should not be transactional
    @Transactional
    public boolean isPersonInEvent(Person person, Event event) {
        for(Registration registration: regRepo.findRegistrationsByEvent(event)) {
            if(registration.getPerson().getId() == person.getId()) return true;
        }
        return false;
    }

    @Transactional
    public void makeOrganizer(Person person, Event event) {
        String error = "";

        if(event == null || person == null) {
            error += "person or event can't be null";
        }

        if(event != null && person != null) {
            if(eventRepo.findEventById(event.getId()) == null) {
                error += "event doesnt exist";
            } else if(personRepo.findPersonById(person.getId()) == null) {
                error += "person doesnt exist";
            }
        }

        if(!error.isEmpty()) {
            throw new IllegalArgumentException(error);
        }

        Registration reg = null;
        for(Registration registration: regRepo.findRegistrationsByPerson(person)) {
            if(registration.getEvent().getId() == event.getId()) {
                reg = registration;
                break;
            }
        }

        if(reg == null) {
            error += "person not registered in event";
        }

        if(!error.isEmpty()) {
            throw new IllegalArgumentException(error);
        }

        reg.setOrganizer(true);
        regRepo.save(reg);
    }

    @Transactional
    public void makeOrganizer(Registration registration) {
        if(registration == null) {
            throw new IllegalArgumentException("reg cant be null");
        }

        if(regRepo.findRegistrationById(registration.getId()) == null) {
            throw new IllegalArgumentException("registration doesnt exist");
        }

        registration.setOrganizer(true);
        regRepo.save(registration);
    }

    @Transactional
    public List<Registration> getRegistrationsByPerson(Person person) {
        if(person == null ) {
            throw new IllegalArgumentException("Person cannot be null!");
        }

        if(personRepo.findPersonById(person.getId()) == null) {
            throw new IllegalArgumentException("Person doesnt exist");
        }

        return regRepo.findRegistrationsByPerson(person);
    }

    @Transactional
    public List<Registration> getRegistrationsByEvent(Event event) {
        String error = "";

        if(event == null) {
            error += "event cant be null";
        } else if(eventRepo.findEventById(event.getId()) == null) {
            error += "event doesnt exist";
        }

        if(!error.isEmpty()) {
            throw new IllegalArgumentException(error);
        }

        return regRepo.findRegistrationsByEvent(event);
    }

    @Transactional
    public List<Registration> getRegistrationsPersonIsOrganizer(Person person) {
        String error = "";

        if(person == null) {
            error += "person cant be null";
        } else if(personRepo.findPersonById(person.getId()) == null) {
            error += "person doesnt exist";
        }

        if(!error.isEmpty()) {
            throw new IllegalArgumentException(error);
        }

        List<Registration> list = regRepo.findRegistrationsByPerson(person);
        List<Registration> regList = new ArrayList<>();

        for(Registration registration: list) {
            if(registration.isOrganizer()) {
                regList.add(registration);
            }
        }

        return regList;
    }
}
