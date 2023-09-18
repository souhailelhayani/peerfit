package com.spring_peerfit_project.peerfit.Model;

import java.time.LocalDateTime;
import java.util.List;

public class Event {
    private int event_id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int numOfPlayers;
    private float price;
    private GroupChat group;
    private List<Registration> registrations;

}
