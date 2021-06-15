package com.HotelService.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Goods {

    @Id
    @GeneratedValue
    private Long id;

    private String items;

    private String value;
}
