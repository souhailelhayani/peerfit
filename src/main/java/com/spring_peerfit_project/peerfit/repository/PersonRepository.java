package com.spring_peerfit_project.peerfit.repository;

import com.spring_peerfit_project.peerfit.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
    //findByFirstname, findby last name etc ...

    public Person findPersonById(int id);

    //public Person findPersonByRegistrations


}
