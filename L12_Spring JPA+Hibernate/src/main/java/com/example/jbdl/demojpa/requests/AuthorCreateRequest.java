package com.example.jbdl.demojpa.requests;

import com.example.jbdl.demojpa.models.Author;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class AuthorCreateRequest {

    @Positive
    private int age;

    @NotBlank
    private String name;

    private String country;


    public Author to(){
        return Author.builder()
                .authorAge(this.age)
                .name(this.name)
                .country(this.country)
                .build();
    }

}
