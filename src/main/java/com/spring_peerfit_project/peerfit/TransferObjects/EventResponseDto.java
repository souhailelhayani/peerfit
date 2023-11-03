package com.spring_peerfit_project.peerfit.TransferObjects;

import com.spring_peerfit_project.peerfit.model.Atmosphere;
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

    public EventResponseDto(int id, Date startDate, Time startTime, int duration, String address, int numOfPlayers, Level level, Atmosphere atm, Sport sport, float price, boolean paymentByCard) {
        this.id = id;
        this.startDate = startDate;
        this.startTime = startTime;
        this.duration = duration;
        this.address = address;
        this.numOfPlayers = numOfPlayers;
        this.level = level.name();
        this.atm = atm.name();
        this.sport = sport.name();
        this.price = price;
        this.paymentByCard = paymentByCard;
    }
}
