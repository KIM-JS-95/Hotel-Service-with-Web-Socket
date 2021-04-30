package com.HotelService.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Builder
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    private String roomnum;

    private String bedtype;

    private String people;

    private String st;
}
