package com.example.jbdl.demodb.services;

import com.example.jbdl.demodb.models.Book;
import com.example.jbdl.demodb.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void insert(Book book) throws SQLException {
        bookRepository.insert(book);
    }

    public List<Book> get() throws SQLException {
        return bookRepository.get();
    }

    public Book get(int bookId) throws SQLException {
        return bookRepository.get(bookId);
    }

    public Book update(Book book) throws SQLException{
        return bookRepository.update(book);
    }

    public Book delete(int bookId) throws SQLException{
        return bookRepository.delete(bookId);
    }
}
