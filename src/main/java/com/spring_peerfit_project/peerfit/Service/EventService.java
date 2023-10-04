package com.spring_peerfit_project.peerfit.Service;

import com.spring_peerfit_project.peerfit.model.Event;
import com.spring_peerfit_project.peerfit.model.GroupChat;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    public void addGroupChatToEvent(Event event, GroupChat group) {
        event.setGroup(group);
        group.setEvent(event);
    }
}
