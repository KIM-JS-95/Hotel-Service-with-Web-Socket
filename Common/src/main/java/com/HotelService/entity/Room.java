package com.HotelService.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Room {

    @Id
    private String roomnum;

    private String bedtype;

    private String people;

//    @OneToOne
//    private Admin admin;

}
