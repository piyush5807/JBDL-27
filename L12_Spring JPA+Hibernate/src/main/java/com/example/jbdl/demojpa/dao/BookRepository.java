package com.example.jbdl.demojpa.dao;

import com.example.jbdl.demojpa.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
