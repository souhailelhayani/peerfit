package com.spring_peerfit_project.peerfit.model;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Person {
    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private float averageRating; //default should be 0
    private int numberOfRatings;

//    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
//    private List<Registration> registrations;

    protected Person () {
    }

    public Person(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.averageRating = 0.0f;
        this.numberOfRatings = 0;
    }

    public Person(String firstName, String lastName, String email, String password, float averageRating, int numberOfRatings) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.averageRating = averageRating;
        this.numberOfRatings = numberOfRatings;
    }

    //    public Person(String email) {
//        this.email = email;
//    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

//    public List<Registration> getRegistrations() {
//        return registrations;
//    }

    public void setId(int person_id) {
        this.id = person_id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }

    public float getAverageRating() {
        return averageRating;
    }

    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(int numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }
}
