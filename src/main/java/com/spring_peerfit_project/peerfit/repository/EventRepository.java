package com.spring_peerfit_project.peerfit.repository;

import com.spring_peerfit_project.peerfit.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {
}
