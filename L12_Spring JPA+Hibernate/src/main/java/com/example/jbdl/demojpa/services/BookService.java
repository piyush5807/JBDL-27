package com.example.jbdl.demojpa.services;

import com.example.jbdl.demojpa.models.Book;
import com.example.jbdl.demojpa.dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void insert(Book book){
        bookRepository.save(book);
    }

    public List<Book> get(){
        return bookRepository.findAll();
    }

    public Book get(int bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

//    public Book update(Book book) throws SQLException{
//        return bookRepository.update(book);
//    }
//
//    public Book delete(int bookId) throws SQLException{
//        return bookRepository.delete(bookId);
//    }
}
