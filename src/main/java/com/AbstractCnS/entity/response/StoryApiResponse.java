package com.AbstractCnS.entity.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StoryApiResponse {

    private Long id;

    private String username;

    private Long teamId;

}
