package com.spring_peerfit_project.peerfit.repository;

import com.spring_peerfit_project.peerfit.model.GroupChat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupChatRepository extends CrudRepository<GroupChat,Integer> {

}
