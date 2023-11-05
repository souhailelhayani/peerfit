package com.spring_peerfit_project.peerfit.Service;

import com.spring_peerfit_project.peerfit.model.Event;
import com.spring_peerfit_project.peerfit.model.Person;
import com.spring_peerfit_project.peerfit.model.Registration;
import com.spring_peerfit_project.peerfit.model.Status;
import com.spring_peerfit_project.peerfit.repository.EventRepository;
import com.spring_peerfit_project.peerfit.repository.PersonRepository;
import com.spring_peerfit_project.peerfit.repository.RegistrationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonEventRelationService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Transactional
    public List<Event> getEventsFromPerson(Person person) {
        List<Registration> list = this.getRegistrationsByPerson(person);
        List<Event> eventsAttendedByPerson = new ArrayList<>();
        for (Registration r : list) {
            if(r.getStatus() == Status.Accepted) {
                eventsAttendedByPerson.add(r.getEvent());
            }
        }
        return eventsAttendedByPerson;
    }

    @Transactional
    public List<Person> getAcceptedPersonsFromEvent(Event event) {
        List<Registration> list = this.getRegistrationsByEvent(event);
        List<Person> personList = new ArrayList<>();
        for(Registration registration: list) {
            if(registration.getStatus() == Status.Accepted){
                personList.add(registration.getPerson());
            }
        }
        return personList;
    }

    @Transactional
    public List<Person> getPendingPersonsFromEvent(Event event) {
        List<Registration> list = this.getRegistrationsByEvent(event);
        List<Person> personList = new ArrayList<>();
        for(Registration registration: list) {
            if(registration.getStatus() == Status.Invited || registration.getStatus() == Status.Requested){
                personList.add(registration.getPerson());
            }
        }
        return personList;
    }

    @Transactional
    public List<Registration> getRegistrationsByPerson(Person person) {
        person = personRepository.findPersonById(person.getId());
        if(person == null) {
            throw new IllegalArgumentException("person doesnt exist");
        }
        return registrationRepository.findRegistrationsByPerson_Id(person.getId());
    }

    @Transactional
    public List<Registration> getRegistrationsByEvent(Event event) {
        event = eventRepository.findEventById(event.getId());
        if(event == null) {
            throw new IllegalArgumentException("event doesn't exist");
        }
        return registrationRepository.findRegistrationsByEvent_Id(event.getId());
    }

    @Transactional
    public void deleteRegistration(Registration registration) {
        registrationRepository.delete(registration);
    }
}
