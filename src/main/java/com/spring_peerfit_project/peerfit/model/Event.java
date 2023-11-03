package com.spring_peerfit_project.peerfit.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
public class Event {
    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date startDate;
    private Time startTime;
    /**
     * duration in minutes
     */
    private int duration;
    private String address;
    private int numOfPlayers;
    private Level level;
    private Atmosphere atm;
    private Sport sport;
    private float price;
    private boolean paymentByCard;

    @OneToOne
    private GroupChat group;
//    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
//    private List<Registration> registrations;

    protected Event () {

    }

    //temporarily used for simplified testing
    public Event(Date startDate, Time startTime, int duration, int numOfPlayers, float price, GroupChat group) {
        this.startDate = startDate;
        this.startTime = startTime;
        this.duration = duration;
        this.numOfPlayers = numOfPlayers;
        this.price = price;
        this.group = group;
    }

    //used in Dto object
    public Event(Date startDate, Time startTime, int duration, String address, int numOfPlayers, Level level, Atmosphere atm, Sport sport, float price, boolean paymentByCard) {
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

    public int getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public float getPrice() {
        return price;
    }

    public GroupChat getGroup() {
        return group;
    }

//    public List<Registration> getRegistrations() {
//        return registrations;
//    }

    public void setId(int event_id) {
        this.id = event_id;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setGroup(GroupChat group) {
        this.group = group;
    }

    //public boolean addRegistration(Registration registration) {
//        return true;
//    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Atmosphere getAtm() {
        return atm;
    }

    public void setAtm(Atmosphere atm) {
        this.atm = atm;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public boolean isPaymentByCard() {
        return paymentByCard;
    }

    public void setPaymentByCard(boolean paymentByCard) {
        this.paymentByCard = paymentByCard;
    }
}
