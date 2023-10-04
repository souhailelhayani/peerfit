package com.spring_peerfit_project.peerfit.repository;

import com.spring_peerfit_project.peerfit.model.Event;
import com.spring_peerfit_project.peerfit.model.Person;
import com.spring_peerfit_project.peerfit.model.Registration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends CrudRepository<Registration, Integer> {

    public void findRegistrationById(int id);

    //method to return all registrations for a person
    public List<Registration> findRegistrationsByPerson(Person person);

    public List<Registration> findRegistrationsByEvent(Event event);

    //method to return registrations given person id

    //method to return registrations given event id

    //method to return registrations of a person where is organizer is True
    //public List<Registration> findRegistrationsByPersonAndOrganizerTrue(Person person);

    //method to return all registrations where isOrganizer is true
    //public void findRegistrationsByOrganizerIsTrue();

    //method to filter registrations with
}
