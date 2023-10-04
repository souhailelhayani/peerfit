package com.spring_peerfit_project.peerfit.model;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Event {
    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @Transient
    private long duration;
    private int numOfPlayers;
    private float price;
    @OneToOne(cascade = CascadeType.ALL)
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

    public int getId() {
        return id;
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

    public void setId(int event_id) {
        this.id = event_id;
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

    public long getDuration() {
        duration = Duration.between(startDate, endDate).toMinutes();
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
