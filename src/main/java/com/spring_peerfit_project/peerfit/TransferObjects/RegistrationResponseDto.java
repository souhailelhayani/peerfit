package com.spring_peerfit_project.peerfit.TransferObjects;

import com.spring_peerfit_project.peerfit.model.Event;
import com.spring_peerfit_project.peerfit.model.Person;
import com.spring_peerfit_project.peerfit.model.Registration;
import com.spring_peerfit_project.peerfit.model.Status;

public class RegistrationResponseDto {
    private int id;
    private Person person;
    private Event event;
    private boolean isOrganizer;
    private boolean paymentByCard;
    private String status;

    public RegistrationResponseDto(Registration registration) {
        this.id = registration.getId();
        this.person = registration.getPerson();
        this.event = registration.getEvent();
        this.isOrganizer = registration.isOrganizer();
        this.paymentByCard = registration.isPaymentByCard();
        this.status = registration.getStatus().name();
    }
}
