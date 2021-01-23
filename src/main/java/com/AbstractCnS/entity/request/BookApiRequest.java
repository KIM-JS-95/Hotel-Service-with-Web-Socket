package com.AbstractCnS.entity.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BookApiRequest {

    private int bookId;

    private String bookName;

    private Long storyList;

}
