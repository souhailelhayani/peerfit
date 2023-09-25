package com.spring_peerfit_project.peerfit.repository;

import com.spring_peerfit_project.peerfit.model.Registration;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RegistrationRepositoryTest {
    @Autowired
    RegistrationRepository repo;

    @AfterEach
    public void clearDatabase() {
        this.repo.deleteAll();
    }
}
