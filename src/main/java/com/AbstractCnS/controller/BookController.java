package com.AbstractCnS.controller;

import com.AbstractCnS.entity.Book;
import com.AbstractCnS.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/savebook", method = RequestMethod.POST)
    @ResponseBody
    public Book saveBook(@RequestBody Book book) {

        Book bookResponse = bookService.saveBook(book);
        return bookResponse;
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
    @ResponseBody
    public Book getBookDetails(@PathVariable int bookId) {
        Book bookResponse = bookService.findByBookId(bookId);

        return bookResponse;
    }
}



