package com.spring_peerfit_project.peerfit.repository;

import com.spring_peerfit_project.peerfit.model.Event;
import com.spring_peerfit_project.peerfit.model.GroupChat;
import com.spring_peerfit_project.peerfit.model.Person;
import com.spring_peerfit_project.peerfit.model.Registration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RegistrationRepositoryTest {
    @Autowired
    RegistrationRepository reg_repo;

    @Autowired
    PersonRepository per_repo;

    @Autowired
    EventRepository eve_repo;

    @AfterEach
    public void clearDatabase() {
        this.reg_repo.deleteAll();
    }

    @Test
    public void createAndRetrieveRegistrations() {
        Person p1 = new Person("souhail", "elhayani","email","pass");
        Person p2 = new Person("yassine", "zniber","email1","pass1");

        GroupChat group = new GroupChat("group");
        Event event = new Event(LocalDateTime.of(LocalDate.of(2023,9,26),LocalTime.of(10,10,10)),
                LocalDateTime.of(LocalDate.of(2023,9,26),LocalTime.of(12,10,10)),
                10,
                20,
                group
                );
        group.setEvent(event);

        /*eve_repo.save(event);
        per_repo.save(p1);
        per_repo.save(p2);*/


        Registration reg1 = new Registration(p1,true, event);
        //organizer = true
        reg_repo.save(reg1);

        Registration reg2 = new Registration(p2,event);
        reg_repo.save(reg2);

        //retrieve
        List<Registration> list1 = reg_repo.findRegistrationsByPerson(p1);
        Registration test = list1.get(0);
        assertEquals(reg1.getId(), test.getId());
        assertEquals(reg1.getPerson().getId(),test.getPerson().getId());
        assertEquals(reg1.isOrganizer(),test.isOrganizer());
        assertEquals(reg1.getEvent().getId(),test.getEvent().getId());

        List<Registration> list2 = reg_repo.findRegistrationsByPerson(p2);
        Registration test2 = list1.get(0);
        assertEquals(reg2.getId(), test2.getId());
        assertEquals(reg2.getPerson().getId(),test2.getPerson().getId());
        assertEquals(reg2.isOrganizer(),test2.isOrganizer());
        assertEquals(reg2.getEvent().getId(),test2.getEvent().getId());


        /*List<Registration> list3 = repo.findRegistrationsByPersonAndOrganizerTrue(p1);
        test = list3.get(0);
        assertEquals(reg1.getId(), test.getId());
        assertEquals(reg1.getPerson().getId(),test.getPerson().getId());
        assertEquals(reg1.isOrganizer(),test.isOrganizer());
        assertEquals(reg1.getEvent().getId(),test.getEvent().getId());*/
    }
}
