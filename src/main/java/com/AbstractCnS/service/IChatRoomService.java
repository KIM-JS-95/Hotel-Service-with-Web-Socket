package com.AbstractCnS.service;

import com.AbstractCnS.entity.ChatRoom;
import com.AbstractCnS.entity.request.ChatRoomRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;




public interface IChatRoomService {
    public long createChatRoom(ChatRoom newRoom);
    public List<ChatRoom> getJoinedRoomList(long user_id);
    public ChatRoom checkExistChatRoom(long user1_id, long user2_id);
    public boolean updateReadTime(ChatRoomRequest chatroomReq);

}
