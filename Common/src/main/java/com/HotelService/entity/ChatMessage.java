package com.HotelService.entity;


import lombok.*;

import javax.persistence.Entity;

@NoArgsConstructor
@Getter
public class ChatMessage {
    private String from;
    private String text;
    private String time;

    public ChatMessage(String from, String text, String time) {
        this.from = from;
        this.text = text;
        this.time = time;
    }

}
