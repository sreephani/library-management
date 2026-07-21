package com.example.library_management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Author")//maps feilds to Author table in DB
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments the ID
    private int id;

    @OneToMany
    private String name;

    private String country;

    private String book;

}
