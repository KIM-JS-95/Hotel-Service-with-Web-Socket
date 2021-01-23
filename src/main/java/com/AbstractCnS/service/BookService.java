package com.AbstractCnS.service;



import com.AbstractCnS.entity.Book;

import org.springframework.stereotype.Component;


@Component
public interface BookService {
    public Book saveBook(Book book);
    public Book findByBookId(int bookId);
}
