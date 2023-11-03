package com.spring_peerfit_project.peerfit.repository;

import com.spring_peerfit_project.peerfit.model.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
    //add custom methods here if needed
    //can also annotate functions with @Query to specify exactly how the function should behave, with JPQL queries ( not SQl )

    Event findEventById(int id);

    List<Event> findEventsByPriceBetween(float price, float price2);

    List<Event> findEventsByPriceLessThan(float price);

    List<Event> findEventsBySport(Sport sport);

    List<Event> findEventsByAtm(Atmosphere atm);

    List<Event> findEventsByLevel(Level level);

    //method to return the organizer of the event
    List<Event> findAll();
}
