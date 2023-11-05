package com.spring_peerfit_project.peerfit.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
public class Message {
    @Id
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String message;
    private Date date;
    private Time time;
    @ManyToOne
    private GroupChat group;
    @ManyToOne
    private Person person;

    protected Message() {
    }

    public Message(String message, Date date, Time time, GroupChat group, Person person) {
        this.message = message;
        this.date = date;
        this.time = time;
        this.group = group;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public GroupChat getGroup() {
        return group;
    }

    public void setGroup(GroupChat group) {
        this.group = group;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
