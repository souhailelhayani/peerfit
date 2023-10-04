package com.spring_peerfit_project.peerfit.repository;

import com.spring_peerfit_project.peerfit.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
    //add custom methods here if needed
    //can also annotate functions with @Query to specify exactly how the function should behave, with JPQL queries ( not SQl )

    public void findEventById(int id);

    //method to return all registrations of an event


    //method to filter registrations by id , or firstname, or lastname, or full name

    //method to return the organizer of the event
}
