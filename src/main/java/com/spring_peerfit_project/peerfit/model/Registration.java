package com.spring_peerfit_project.peerfit.model;

import jakarta.persistence.*;

@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int registration_id;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    private boolean isOrganizer = false;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    protected Registration() {
    }

    public Registration(Person person, Event event) {
        this.person =person;
        this.event = event;
    }

    public Registration(Person person, boolean isOrganizer, Event event) {
        this.person =person;
        this.isOrganizer = isOrganizer; //true
        this.event = event;
    }

    public int getRegistration_id() {
        return registration_id;
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

    public void setRegistration_id(int registration_id) {
        this.registration_id = registration_id;
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
}
