package com.example.library_management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments the ID
    private int id;

    @OneToOne()
    private String title;

    private String isbn;

    private long publicationYear;

    private int availableCopies;

    private String version;

    private String author;

    private String category;

}
