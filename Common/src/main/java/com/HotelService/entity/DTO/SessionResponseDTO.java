package com.HotelService.entity.DTO;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SessionResponseDTO {

    private String accessToken;
}
