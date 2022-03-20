package com.example.jbdl.demojpa.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Spring will search for all the components in the entire package / all packages
 * Hibernate will search for all entities in the entire package / all packages
 **/


@Getter
@Setter
@Entity
@Table(name = "my_book")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @GeneratedValue(strategy = GenerationType.AUTO) // Automatic generation of ids
    @Id      // Primary key
    private int id;
    private String n_a_m_e;
    private String author_name; // author_name
    private int cost;

    // select * from book where authorName = 'Peter';

    // Queries : SQL Table, Java object

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;  // ALTER TABLE ADD COLUMN updatedOn DATE
}
