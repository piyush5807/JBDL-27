package com.example.jbdl.demojpa.requests;

import com.example.jbdl.demojpa.models.Book;
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
                .id(this.name.equals("Intro to Java") ? 3 : 0)
                .author_name(this.authorName)
                .n_a_m_e(this.name)
                .cost(this.cost)
                .build();
    }
}
