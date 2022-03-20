package com.example.jbdl.demojpa.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;      // 3  // 15

    @Column(name = "authorName")
    private String name;
    private Integer authorAge;
    private String country;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

}
