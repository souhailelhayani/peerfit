package com.spring_peerfit_project.peerfit.repository;

import com.spring_peerfit_project.peerfit.model.Person;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class PersonRepositoryTest {
    @Autowired
    PersonRepository repo;

    @AfterEach
    public void clearDatabase() {
        this.repo.deleteAll();
        /*Optional<Person> person = this.repo.findById(5);
        if(person.isPresent()) {
            Person p = person.get();
        }*/
        //Person per = repo.findPersonById(5);
    }
}
