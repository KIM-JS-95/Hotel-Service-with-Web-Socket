package com.AbstractCnS.mapper;


import com.AbstractCnS.entity.ChatRoom;
import com.AbstractCnS.entity.request.ChatRoomRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ChatRoomRepository extends CrudRepository<ChatRoom, Long> {
    Long createChatRoom(ChatRoom newRoom);

    List<ChatRoom> getJoinedRoomList(long user_id);

    ChatRoom checkExistChatRoom(@Param("user1") long user1, @Param("user2") long user2);

    int updateReadTime(ChatRoomRequest chatroomReq);
}

