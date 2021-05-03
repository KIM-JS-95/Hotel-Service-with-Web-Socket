package com.HotelService.entity;


import lombok.*;

@Getter
@Setter
public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;
}
