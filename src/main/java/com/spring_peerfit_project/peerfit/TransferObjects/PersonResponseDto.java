package com.spring_peerfit_project.peerfit.TransferObjects;

import com.spring_peerfit_project.peerfit.model.Person;

public class PersonResponseDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public PersonResponseDto(Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.email = person.getEmail();
        this.password = person.getPassword();
    }

}
