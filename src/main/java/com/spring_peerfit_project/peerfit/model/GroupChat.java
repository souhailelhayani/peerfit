package com.spring_peerfit_project.peerfit.model;

import jakarta.persistence.*;

@Entity
public class GroupChat {
    @Id
    @Column(name = "group_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String groupName;
    @OneToOne(mappedBy = "group", cascade = CascadeType.ALL)
    private Event event;

    protected GroupChat() {

    }
    public GroupChat(String groupName) {
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int group_id) {
        this.id = group_id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
