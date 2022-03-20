package com.example.jbdl.demojpa.services;

import com.example.jbdl.demojpa.models.Author;
import com.example.jbdl.demojpa.dao.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public void insert(Author author){
        authorRepository.save(author);
    }
}
