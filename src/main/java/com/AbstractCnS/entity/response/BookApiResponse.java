package com.AbstractCnS.entity.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BookApiResponse {

    private Long id;

    private String name;

    private Long storyList;
}
