package com.AbstractCnS.service;

import com.AbstractCnS.entity.ChatRoom;
import com.AbstractCnS.entity.request.ChatRoomRequest;
import com.AbstractCnS.mapper.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatRoomService implements IChatRoomService {

    private final ChatRoomRepository chatroomMapper;

    @Override
    public long createChatRoom(ChatRoom newRoom) {
        long idx = chatroomMapper.createChatRoom(newRoom);
        return idx == 1 ? newRoom.getId() : -1;
    }

    @Override
    public List<ChatRoom> getJoinedRoomList(long user_id) {
        return chatroomMapper.getJoinedRoomList(user_id);
    }

    @Override
    public ChatRoom checkExistChatRoom(long user1, long user2) {
        return chatroomMapper.checkExistChatRoom(user1, user2);
    }

    @Override
    public boolean updateReadTime(ChatRoomRequest chatroomReq) {
        return chatroomMapper.updateReadTime(chatroomReq) > 0 ? true : false;
    }

}
