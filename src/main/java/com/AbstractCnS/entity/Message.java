package com.AbstractCnS.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Message {

    private long id;
    private String content;
    private LocalDateTime sendTime;
    private LocalDateTime receiveTime;
    private long chatroomId;
    private long senderId;
    private long receiverId;

}
