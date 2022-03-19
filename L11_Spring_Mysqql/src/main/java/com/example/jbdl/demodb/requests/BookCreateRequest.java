package com.example.jbdl.demodb.requests;

import com.example.jbdl.demodb.models.Book;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
public class BookCreateRequest {

    @NotNull
    private String name;

    @NotNull
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
