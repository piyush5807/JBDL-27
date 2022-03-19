package com.example.jbdl.demodb.controllers;

import com.example.jbdl.demodb.models.Book;
import com.example.jbdl.demodb.requests.BookCreateRequest;
import com.example.jbdl.demodb.requests.BookUpdateRequest;
import com.example.jbdl.demodb.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    private static Logger logger = LoggerFactory.getLogger(BookController.class);

    @GetMapping("/book")
    public Book getBook(@RequestParam("id") int id) throws SQLException {
        return bookService.get(id);
    }

    @GetMapping("/book/all")
    public List<Book> getBooks() throws SQLException {
        return bookService.get();
    }

    @PostMapping("/book")
    public void insertBook(@Valid @RequestBody BookCreateRequest bookCreateRequest) throws SQLException {
        bookService.insert(bookCreateRequest.to());
    }

    @PutMapping("/book")
    public Book updateBook(@Valid @RequestBody BookUpdateRequest bookUpdateRequest) throws SQLException{
        return bookService.update(bookUpdateRequest.to());
    }

    @DeleteMapping("/book")
    public Book deleteBook(@RequestParam("id") int id) throws SQLException{
        return bookService.delete(id);
    }
}


// CRUD
// Create Read Update Delete