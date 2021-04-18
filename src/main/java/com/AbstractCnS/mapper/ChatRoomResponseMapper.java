package com.AbstractCnS.mapper;

import com.AbstractCnS.entity.response.ChatRoomResponse;
import com.AbstractCnS.entity.response.ChatRoomResponseEntity;
import org.springframework.data.repository.CrudRepository;

public interface ChatRoomResponseMapper extends CrudRepository<Long, ChatRoomResponseEntity> {

    ChatRoomResponseEntity getChatRoomInfo(ChatRoomResponse chatroomRes);
}
