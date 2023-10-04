package com.spring_peerfit_project.peerfit.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Registration {
    @Id
    @Column(name = "registration_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;
    @Column(columnDefinition = "boolean default false")
    private boolean isOrganizer = false;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private Event event;

    protected Registration() {
    }

    //constructor if organizer is false
    public Registration(Person person, Event event) {
        this.person =person;
        this.event = event;
    }

    //constructor when organizer is true
    public Registration(Person person, boolean isOrganizer, Event event) {
        this.person =person;
        this.isOrganizer = isOrganizer; //true
        this.event = event;
    }

    public int getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public boolean isOrganizer() {
        return isOrganizer;
    }

    public Event getEvent() {
        return event;
    }

    public void setId(int registration_id) {
        this.id = registration_id;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setOrganizer(boolean organizer) {
        isOrganizer = organizer;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registration that = (Registration) o;
        return id == that.id && isOrganizer == that.isOrganizer && Objects.equals(person, that.person) && Objects.equals(event, that.event);
    }*/
}
