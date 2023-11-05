package com.spring_peerfit_project.peerfit.TransferObjects;

import com.spring_peerfit_project.peerfit.model.Event;
import com.spring_peerfit_project.peerfit.model.Person;
import com.spring_peerfit_project.peerfit.model.Registration;
import com.spring_peerfit_project.peerfit.model.Status;

public class RegistrationRequestDto {
    private int personId;
    private int eventId;
    private boolean paymentByCard;

    public RegistrationRequestDto(int personId, int eventId, boolean paymentByCard) {
        this.personId = personId;
        this.eventId = eventId;
        this.paymentByCard = paymentByCard;
    }

    //get person and event from Ids
    public Registration toModel(Person person, boolean organizer, boolean payment, Status status, Event event) {
        return new Registration(person, organizer, payment, status, event);
    }
}
