package com.AbstractCnS.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;

    @Column(name = "book_name")
    private String bookName;

    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name = "book_id",referencedColumnName="bookId")
    private List<Story> storyList = new ArrayList<>();

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<Story> getStoryList() {
        return storyList;
    }

    public void setStoryList(List<Story> storyList) {
        this.storyList = storyList;
    }



}
