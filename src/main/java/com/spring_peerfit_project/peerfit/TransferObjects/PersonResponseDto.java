package com.spring_peerfit_project.peerfit.TransferObjects;

import com.spring_peerfit_project.peerfit.model.Person;

public class PersonResponseDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public PersonResponseDto(int id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

}
