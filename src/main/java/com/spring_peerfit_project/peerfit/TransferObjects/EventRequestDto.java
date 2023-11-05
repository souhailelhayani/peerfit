package com.spring_peerfit_project.peerfit.TransferObjects;

import com.spring_peerfit_project.peerfit.model.Atmosphere;
import com.spring_peerfit_project.peerfit.model.Event;
import com.spring_peerfit_project.peerfit.model.Level;
import com.spring_peerfit_project.peerfit.model.Sport;

import java.sql.Date;
import java.sql.Time;

public class EventRequestDto {

    private Date startDate;
    private Time startTime;
    private int duration;
    private String address;
    private int numOfPlayers;
    private String level;
    private String atm;
    private String sport;
    private float price;
    private boolean paymentByCard;

    public EventRequestDto(Date startDate, Time startTime, int duration, String address, int numOfPlayers, String level, String atm, String sport, float price, boolean paymentByCard) {
        this.startDate = startDate;
        this.startTime = startTime;
        this.duration = duration;
        this.address = address;
        this.numOfPlayers = numOfPlayers;
        this.level = level;
        this.atm = atm;
        this.sport = sport;
        this.price = price;
        this.paymentByCard = paymentByCard;
    }

    public Event toModel() {
        return new Event(startDate, startTime, duration, address, numOfPlayers, Level.valueOf(level), Atmosphere.valueOf(atm), Sport.valueOf(sport), price, paymentByCard);
    }
}
