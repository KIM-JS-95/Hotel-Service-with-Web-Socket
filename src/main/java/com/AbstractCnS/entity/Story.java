package com.AbstractCnS.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;



@Entity

public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int storyId;

    @Column(name = "story_name")
    private String storyName;

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public String getStoryName() {
        return storyName;
    }

    public void setStoryName(String storyName) {
        this.storyName = storyName;
    }

}
