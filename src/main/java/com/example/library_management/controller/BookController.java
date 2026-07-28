package com.example.library_management.controller;

import com.example.library_management.Dto.BookResponseDTO;
import com.example.library_management.Dto.NewBookDTO;
import com.example.library_management.entity.Book;
import com.example.library_management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;



    @PostMapping()
    public ResponseEntity<NewBookDTO> addBook(@RequestBody NewBookDTO newBookRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(newBookRequest));
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Integer bookId) {

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(bookId));
    }

    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks() {

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable int bookId) {

        bookService.deleteBook(bookId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getBookCount() {

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookCount());
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Book>> getBooksByTitle(@PathVariable String title) {

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksByTitle(title));
    }

}