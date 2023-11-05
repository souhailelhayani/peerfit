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
