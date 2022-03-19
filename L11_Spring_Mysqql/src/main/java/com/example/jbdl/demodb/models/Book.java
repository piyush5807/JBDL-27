package com.example.jbdl.demodb.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Book {

    private int id;
    private String name;
    private String authorName;
    private int cost;

}
