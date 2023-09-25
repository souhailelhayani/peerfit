package com.spring_peerfit_project.peerfit.repository;

import com.spring_peerfit_project.peerfit.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    public Person findPersonById(int id);
}
