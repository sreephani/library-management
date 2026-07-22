package com.example.library_management.controller;

import com.example.library_management.Dto.BookResponseDTO;
import com.example.library_management.entity.Book;
import com.example.library_management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return service.addBook(book);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Integer bookId) {
        return ResponseEntity.ok(service.getBookById(bookId));
    }

}