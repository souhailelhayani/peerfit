package com.spring_peerfit_project.peerfit.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int person_id;
    private String firstName;
    private String LastName;
    private String email;
    private String password;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Registration> registrations;

    protected Person () {

    }

    public Person(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.password = password;
    }

    public int getPerson_id() {
        return person_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean addRegistration(Registration registration) {
        return true;
    }
}
