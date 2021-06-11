package com.HotelService.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Null;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Admin {

    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String name;

    private String phonenum;

    private String people;

    @OneToOne
    @JoinColumn(name="ROOM_roomnum")
    private Room room;

}
