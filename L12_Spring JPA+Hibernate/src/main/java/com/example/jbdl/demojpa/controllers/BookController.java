package com.example.jbdl.demojpa.controllers;

import com.example.jbdl.demojpa.models.Book;
import com.example.jbdl.demojpa.requests.BookCreateRequest;
import com.example.jbdl.demojpa.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    private static Logger logger = LoggerFactory.getLogger(BookController.class);

    @GetMapping("/book")
    public Book getBook(@RequestParam("id") int id) {
        return bookService.get(id);
    }

    @GetMapping("/book/all")
    public List<Book> getBooks()  {
        return bookService.get();
    }

    @PostMapping("/book")
    public void insertBook(@Valid @RequestBody BookCreateRequest bookCreateRequest) {
        bookService.insert(bookCreateRequest.to());
    }

    // Q1. You need to find all the books which have author name starting with 'P' and cost > 100;

//    @PutMapping("/book")
//    public Book updateBook(@Valid @RequestBody BookUpdateRequest bookUpdateRequest) throws SQLException{
//        return bookService.update(bookUpdateRequest.to());
//    }
//
//    @DeleteMapping("/book")
//    public Book deleteBook(@RequestParam("id") int id) throws SQLException{
//        return bookService.delete(id);
//    }
}
