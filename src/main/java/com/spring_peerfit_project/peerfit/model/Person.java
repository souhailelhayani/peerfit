package com.spring_peerfit_project.peerfit.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Person {
    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
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
        //TODO add constraint cant have same email as someone else??
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
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

    public void setId(int person_id) {
        this.id = person_id;
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
