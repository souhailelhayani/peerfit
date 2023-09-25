package com.spring_peerfit_project.peerfit.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int event_id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int numOfPlayers;
    private float price;
    @OneToOne()
    @JoinColumn(name = "group_id")
    private GroupChat group;
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Registration> registrations;

    protected Event () {

    }

    public Event(LocalDateTime startDate, LocalDateTime endDate, int numOfPlayers, float price, GroupChat group) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.numOfPlayers = numOfPlayers;
        this.price = price;
        this.group = group;
    }

    public int getEvent_id() {
        return event_id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
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

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
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

    public boolean addRegistration(Registration registration) {
        return true;
    }
}
