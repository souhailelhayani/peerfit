package com.spring_peerfit_project.peerfit.model;

import jakarta.persistence.*;

@Entity
public class GroupChat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int group_id;
    private String groupName;
    @OneToOne(mappedBy = "group", cascade = CascadeType.ALL)
    private Event event;

    protected GroupChat() {

    }
    public GroupChat(String groupName) {
        this.groupName = groupName;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
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
