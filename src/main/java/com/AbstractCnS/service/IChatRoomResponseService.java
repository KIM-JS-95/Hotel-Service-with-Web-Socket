package com.AbstractCnS.service;

import com.AbstractCnS.entity.response.ChatRoomResponse;
import com.AbstractCnS.entity.response.ChatRoomResponseEntity;

public interface IChatRoomResponseService {
    public ChatRoomResponseEntity getChatRoomInfo(ChatRoomResponse crr);

}
