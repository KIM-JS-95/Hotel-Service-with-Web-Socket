package com.AbstractCnS.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Builder
@Getter
@ToString
public class ChatRoom {
    long id;
    long user1Id;
    long user2Id;
}
