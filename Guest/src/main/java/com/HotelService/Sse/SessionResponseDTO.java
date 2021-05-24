package com.HotelService.Sse;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SessionResponseDTO {

    private String accessToken;
}
