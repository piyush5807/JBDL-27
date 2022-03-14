package com.example.jbdl.demodb.services;

import com.example.jbdl.demodb.models.Book;
import com.example.jbdl.demodb.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void insert(Book book){
        bookRepository.insert(book);
    }
}
