package com.example.jbdl.demojpa.dao;

import com.example.jbdl.demojpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
