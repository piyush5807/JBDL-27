package com.example.jbdl.demodb.requests;

import com.example.jbdl.demodb.models.Book;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class BookCreateRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String authorName;

    @Positive
    private int cost;


    public Book to(){
        return Book.builder()
                .authorName(this.authorName)
                .name(this.name)
                .cost(this.cost)
                .build();
    }
}
