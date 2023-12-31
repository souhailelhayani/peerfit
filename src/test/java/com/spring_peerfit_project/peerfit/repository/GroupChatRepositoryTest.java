package com.spring_peerfit_project.peerfit.repository;

import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GroupChatRepositoryTest {
    @Autowired
    GroupChatRepository repo;

    @AfterEach
    public void clearDatabase() {
        this.repo.deleteAll();
    }
}
