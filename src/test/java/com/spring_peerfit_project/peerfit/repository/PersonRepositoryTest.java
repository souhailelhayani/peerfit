package com.spring_peerfit_project.peerfit.repository;

import com.spring_peerfit_project.peerfit.model.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void CreateAndReadPerson() {
        Person person = new Person("souhail", "elhayani", "email", "pass");
        repo.save(person);

        Person test = repo.findPersonById(person.getId());

        assertNotNull(test);
        assertEquals(person.getFirstName(), test.getFirstName());
        assertEquals(person.getLastName(), test.getLastName());
        assertEquals(person.getEmail(), test.getEmail());
        assertEquals(person.getPassword(), test.getPassword());
    }
}
