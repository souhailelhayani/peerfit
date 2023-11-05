package com.spring_peerfit_project.peerfit.TransferObjects;

import com.spring_peerfit_project.peerfit.model.Atmosphere;
import com.spring_peerfit_project.peerfit.model.Event;
import com.spring_peerfit_project.peerfit.model.Level;
import com.spring_peerfit_project.peerfit.model.Sport;

import java.sql.Date;
import java.sql.Time;

public class EventResponseDto {

    private int id;
    private Date startDate;
    private Time startTime;
    /**
     * duration in minutes
     */
    private int duration;
    private String address;
    private int numOfPlayers;
    private String level;
    private String atm;
    private String sport;
    private float price;
    private boolean paymentByCard;

    public EventResponseDto(Event event) {
        this.id = event.getId();
        this.startDate = event.getStartDate();
        this.startTime = event.getStartTime();
        this.duration = event.getDuration();
        this.address = event.getAddress();
        this.numOfPlayers = event.getNumOfPlayers();
        this.level = event.getLevel().name();
        this.atm = event.getAtm().name();
        this.sport = event.getSport().name();
        this.price = event.getPrice();
        this.paymentByCard = event.isPaymentByCard();
    }
}
