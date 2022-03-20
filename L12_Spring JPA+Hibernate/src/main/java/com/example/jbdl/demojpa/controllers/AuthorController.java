package com.example.jbdl.demojpa.controllers;

import com.example.jbdl.demojpa.requests.AuthorCreateRequest;
import com.example.jbdl.demojpa.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/author")
    public void insertAuthor(@Valid @RequestBody AuthorCreateRequest authorCreateRequest){
        authorService.insert(authorCreateRequest.to());
    }
}
