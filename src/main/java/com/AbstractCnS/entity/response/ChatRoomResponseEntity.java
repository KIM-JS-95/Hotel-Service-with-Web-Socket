package com.AbstractCnS.entity.response;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
@Builder
public class ChatRoomResponseEntity {

    String otherUserNickname;
    String otherUserProfile;
    String recentMessage;
    int unreadMessage;
}
