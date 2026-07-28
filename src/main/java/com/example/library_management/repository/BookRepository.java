package com.example.library_management.repository;

import com.example.library_management.entity.Book;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//a specific annotation used in Java frameworks like Spring to indicate that a class or interface
// acts as a Data Access Object (DAO). It manages the storage, retrieval, updating, and deleting of
// data from a database and automatically translates low-level database errors into Spring's
// standard data access
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    
}
