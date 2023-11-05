package com.spring_peerfit_project.peerfit.repository;

import com.spring_peerfit_project.peerfit.model.Event;
import com.spring_peerfit_project.peerfit.model.Person;
import com.spring_peerfit_project.peerfit.model.Registration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends CrudRepository<Registration, Integer> {

    Registration findRegistrationById(int id);

    //method to return all registrations for a person
    List<Registration> findRegistrationsByPerson(Person person);

    List<Registration> findRegistrationsByEvent(Event event);

    List<Registration> findAll();

    //method to return registrations given person id
    List<Registration> findRegistrationsByPerson_Id(int id);

    //method to return registrations given event id
    List<Registration> findRegistrationsByEvent_Id(int id);

    Registration findRegistrationByPerson_IdAndEvent_Id(int person_id, int event_id);

    //method to return registrations of a person where is organizer is True
    //public List<Registration> findRegistrationsByPerson_IdAndOrganizerIsTrue(int id);

    //method to return all registrations where isOrganizer is true
    //public List<Registration> findRegistrationsByOrganizerIsTrue();

    //method to filter registrations with
}
