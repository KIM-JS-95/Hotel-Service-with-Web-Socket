package com.AbstractCnS.entity.request;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Builder
public class ChatRoomRequest {
    long id;
    long userId;
}
