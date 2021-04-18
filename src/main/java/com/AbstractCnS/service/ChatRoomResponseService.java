package com.AbstractCnS.service;

import com.AbstractCnS.entity.ChatRoom;
import com.AbstractCnS.entity.request.ChatRoomRequest;
import com.AbstractCnS.entity.response.ChatRoomResponse;
import com.AbstractCnS.entity.response.ChatRoomResponseEntity;
import com.AbstractCnS.mapper.ChatRoomResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatRoomResponseService implements IChatRoomResponseService {

    private final ChatRoomResponseMapper chatroomResMapper;

    @Override
    public ChatRoomResponseEntity getChatRoomInfo(ChatRoomResponse crr) {
        return null;
    }
}
