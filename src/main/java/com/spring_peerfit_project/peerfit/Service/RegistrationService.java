package com.spring_peerfit_project.peerfit.Service;

import com.spring_peerfit_project.peerfit.model.Event;
import com.spring_peerfit_project.peerfit.model.Person;
import com.spring_peerfit_project.peerfit.model.Registration;
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

    @Transactional
    public void createRegistration(Registration registration, boolean isOrganizer) {
        //event and person are already verified, in controller use getPerson by id and getEvent by id
        Event event = registration.getEvent();
        Person person = registration.getPerson();

        registration = new Registration(person, isOrganizer, event);
        regRepo.save(registration);
    }

    @Transactional
    public boolean isPersonInEvent(Person person, Event event) {
        for(Registration registration: regRepo.findRegistrationsByEvent(event)) {
            if(registration.getPerson().getId() == person.getId()) return true;
        }
        return false;
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
        return regRepo.findRegistrationsByPerson_Id(person.getId());
    }

    @Transactional
    public List<Registration> getRegistrationsByEvent(Event event) {
        return regRepo.findRegistrationsByEvent_Id(event.getId());
    }

    //event and person are already valid
    @Transactional
    public Registration getRegistrationByPersonAndEvent(Person person, Event event) {
        return regRepo.findRegistrationByPerson_IdAndEvent_Id(person.getId(), event.getId());
    }

    @Transactional
    public List<Registration> getRegistrationsPersonIsOrganizer(Person person) {
        List<Registration> list = regRepo.findRegistrationsByPerson_Id(person.getId());
        List<Registration> regList = new ArrayList<>();

        for(Registration registration: list) {
            if(registration.isOrganizer()) {
                regList.add(registration);
            }
        }

        return regList;
    }
}
