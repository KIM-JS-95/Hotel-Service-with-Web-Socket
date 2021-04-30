package com.HotelService.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@SequenceGenerator(name = "BOARD_SEQ_GENERATOR",
        sequenceName = "BOARD_SEQ", initialValue = 1)
public class Room {

    @Id
    @GeneratedValue(
            generator = "BOARD_SEQ_GENERATOR")
    private Long idx;

    private String roomnum;

    private String bedtype;

    private String people;

    private String st;
}
