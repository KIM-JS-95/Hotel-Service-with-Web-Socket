package com.HotelService.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@SequenceGenerator(name = "BOARD_SEQ_GENERATOR",
        sequenceName = "ROOM_SEQ", initialValue = 1)
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "ROOM_SEQ_GENERATOR")
    private Long idx;

    private String roomnum;

    private String bedtype;

    private String people;

    private String st;
}
