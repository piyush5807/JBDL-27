package com.example.jbdl.minorproject1.controllers;

import com.example.jbdl.minorproject1.models.Book;
import com.example.jbdl.minorproject1.models.Genre;
import com.example.jbdl.minorproject1.models.Student;
import com.example.jbdl.minorproject1.requests.BookCreateRequest;
import com.example.jbdl.minorproject1.requests.BookFilterKey;
import com.example.jbdl.minorproject1.requests.StudentCreateRequest;
import com.example.jbdl.minorproject1.responses.BookResponse;
import com.example.jbdl.minorproject1.responses.BookWithoutStudentResponse;
import com.example.jbdl.minorproject1.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

    // post, put, delete --> ADMIN
    // get --> STUDENT, ADMIN


    @Autowired
    BookService bookService;

    @PostMapping("/book")
    public void createBook(@Valid @RequestBody BookCreateRequest bookCreateRequest){
        bookService.createBook(bookCreateRequest.to());
    }

    @GetMapping("/book/all")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    // This API filters the book on basis of id
    @GetMapping("/book")
    public List<Book> getBook(@RequestParam("filterKey") String filterKey,
                        @RequestParam("filterValue") String filterValue) throws Exception {

        BookFilterKey bookFilterKey = BookFilterKey.valueOf(filterKey);

        switch (bookFilterKey){
            case AUTHOR_NAME:
                return bookService.getBookByAuthorName(filterValue);
            case BOOK_NAME:
                return bookService.getBookByName(filterValue);
            case BOOK_ID:
                return bookService.getBookById(Integer.parseInt(filterValue));
            case GENRE:
                return bookService.getBookByGenre(Genre.valueOf(filterValue));
            default:
                throw new Exception("Wrong filter type passed");
        }
    }

    @GetMapping("/bookByStudent1")
    public List<BookResponse> getBooksByStudent1(@RequestParam("name") String name) {
        return bookService.getBookByStudentName(name);
    }

    @GetMapping("/bookByStudent2")
    public List<BookWithoutStudentResponse> getBooks(@RequestParam("name") String name) {
        return bookService.getBookByStudentNameWithoutStudent(name);
    }


//    public List<Book> getBooks(@RequestParam("filterkeys") String filterKeys,
//                               @RequestParam("filterValues") String filterValues){
//
//        // FilterKeys -   BOOK_NAME,      AUTHOR_NAME, COST
//        // Filtervalues - Intro to Maths,  Will,   1000
//        // FilterRegex -     =,               s%,        <=
//        //
//    }
}
