package com.example.jbdl.minorproject1.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    private String name;
    private int age;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true)
    private String phoneNumber;

    /* Remember it in this way, mapped is always the current class' reference
       attribute in the other class
     */
    @OneToMany(mappedBy = "student")
    @JsonIgnoreProperties(value = "student")
    private List<Book> bookList;

    @OneToMany(mappedBy = "student")
    @JsonIgnoreProperties(value = "student")
    private List<Transaction> transactionList;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    // All the books issued to student 1 --> GET Student info
}