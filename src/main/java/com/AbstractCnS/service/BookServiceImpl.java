package com.AbstractCnS.service;

import com.AbstractCnS.entity.Book;
import com.AbstractCnS.entity.Story;
import com.AbstractCnS.repository.BookRepository;
import com.AbstractCnS.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("bookServiceImpl")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {

        book = bookRepository.save(book);
        return book;

    }


    public Book findByBookId(int bookId) {
        Book book = bookRepository.findByBookId(bookId);
        return book;
    }
}