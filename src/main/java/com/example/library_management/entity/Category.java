package com.example.library_management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments the ID
    private int id;

    @OneToOne
    private String name;

    private String description;

    private String books;

}
