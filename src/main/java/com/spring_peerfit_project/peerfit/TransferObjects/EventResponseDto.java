package com.spring_peerfit_project.peerfit.TransferObjects;

import com.spring_peerfit_project.peerfit.model.Event;

import java.sql.Date;
import java.sql.Time;

public class EventResponseDto {

    private int event_id;
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
        this.event_id = event.getId();
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

    public int getId() {
        return event_id;
    }

    public void setId(int event_id) {
        this.event_id = event_id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAtm() {
        return atm;
    }

    public void setAtm(String atm) {
        this.atm = atm;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isPaymentByCard() {
        return paymentByCard;
    }

    public void setPaymentByCard(boolean paymentByCard) {
        this.paymentByCard = paymentByCard;
    }
}
