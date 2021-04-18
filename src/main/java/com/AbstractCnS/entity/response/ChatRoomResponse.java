package com.AbstractCnS.entity.response;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Builder
public class ChatRoomResponse {

    long id;
    long currUserId;
    long otherUserId;

    ChatRoomResponseEntity entity;

    public void setEntity(ChatRoomResponseEntity entity) {
        this.entity = entity;
    }
}
