package com.spring_peerfit_project.peerfit.TransferObjects;

import com.spring_peerfit_project.peerfit.model.Person;

public class PersonRequestDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public PersonRequestDto(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Person toModel() {
        return new Person(firstName, lastName, email, password);
    }
}
