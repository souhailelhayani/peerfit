package com.spring_peerfit_project.peerfit.TransferObjects;

import com.spring_peerfit_project.peerfit.model.Event;
import com.spring_peerfit_project.peerfit.model.Person;
import com.spring_peerfit_project.peerfit.model.Status;

public class RegistrationResponseDto {
    private int id;
    private Person person;
    private Event event;
    private boolean isOrganizer;
    private boolean paymentByCard;
    private String status;

    public RegistrationResponseDto(int id, Person person, Event event, boolean isOrganizer, boolean paymentByCard, Status status) {
        this.id = id;
        this.person = person;
        this.event = event;
        this.isOrganizer = isOrganizer;
        this.paymentByCard = paymentByCard;
        this.status = status.name();
    }
}
