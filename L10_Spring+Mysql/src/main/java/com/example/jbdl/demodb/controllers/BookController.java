package com.example.jbdl.demodb.controllers;

import com.example.jbdl.demodb.models.Book;
import com.example.jbdl.demodb.requests.BookCreateRequest;
import com.example.jbdl.demodb.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    private static Logger logger = LoggerFactory.getLogger(BookController.class);

    @GetMapping("/book")
    public Book getBook(@RequestParam("id") int id){
//        Book book = new Book(1, "Python Fundamentals", "Jim Harvey", 1000);
        Book book = new Book();
        book.setId(1);

        return book;
    }

    @PostMapping("/book")
    public void insertBook(@Valid @RequestBody BookCreateRequest bookCreateRequest){
        bookService.insert(bookCreateRequest.to());
    }
}


// CRUD
// Create Read Update Delete