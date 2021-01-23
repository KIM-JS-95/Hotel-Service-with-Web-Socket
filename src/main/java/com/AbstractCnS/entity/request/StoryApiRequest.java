package com.AbstractCnS.entity.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StoryApiRequest {
    private Long id;
    private String username;

    private Long teamId;

}
