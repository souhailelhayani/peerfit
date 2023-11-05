package com.spring_peerfit_project.peerfit.TransferObjects;

import com.spring_peerfit_project.peerfit.model.Event;
import com.spring_peerfit_project.peerfit.model.Person;
import com.spring_peerfit_project.peerfit.model.Registration;

public class RegistrationResponseDto {
    private int registration_id;
    private Person person;
    private Event event;
    private boolean isOrganizer;
    private boolean paymentByCard;
    private String status;

    public RegistrationResponseDto(Registration registration) {
        this.registration_id = registration.getId();
        this.person = registration.getPerson();
        this.event = registration.getEvent();
        this.isOrganizer = registration.isOrganizer();
        this.paymentByCard = registration.isPaymentByCard();
        this.status = registration.getStatus().name();
    }

    public int getId() {
        return registration_id;
    }

    public void setId(int id) {
        this.registration_id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public boolean isOrganizer() {
        return isOrganizer;
    }

    public void setOrganizer(boolean organizer) {
        isOrganizer = organizer;
    }

    public boolean isPaymentByCard() {
        return paymentByCard;
    }

    public void setPaymentByCard(boolean paymentByCard) {
        this.paymentByCard = paymentByCard;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
