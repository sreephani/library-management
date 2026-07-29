package com.example.library_management.controller;

import com.example.library_management.Dto.BookResponseDTO;
import com.example.library_management.Dto.NewBookDTO;
import com.example.library_management.Dto.PaginationDTO;
import com.example.library_management.Dto.SearchDTO;
import com.example.library_management.entity.Book;
import com.example.library_management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/title-keyword/{keyword}")
    public ResponseEntity<List<Book>> getBooksByTitleContaining(@PathVariable String keyword) {

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksByTitleContaining(keyword));
    }

    @GetMapping("/title-prefix/{prefix}")
    public ResponseEntity<List<Book>> getBooksByPrefix(@PathVariable String prefix) {
        
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksByTitlePrefix(prefix));
    }

    @GetMapping("/title-author")
    public ResponseEntity<List<Book>> getBooksByAuthorName(@RequestParam String authorName) {

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksByAuthorName(authorName));
    }

    @GetMapping("/title-category")
    public ResponseEntity<List<Book>> getBooksByCategoryName(@RequestParam String categoryName) {

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksByCategoryName(categoryName));
    }

    @GetMapping("/title-copies")
    public ResponseEntity<List<Book>> getBooksByAvailableCopiesGreaterThan(@RequestParam int copies) {

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksByAvailableCopiesGreaterThan(copies));
    }

    @GetMapping("/title-publicationYear")
    public ResponseEntity<List<Book>> getBooksByPublicationYearGreaterThan(@RequestParam long year) {

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksByPublicationYearGreaterThan(year));
    }

    @GetMapping("/search")
    public ResponseEntity<PaginationDTO<BookResponseDTO>> getSearchBooks(@ModelAttribute SearchDTO search, Pageable pageable) {

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getSearchBooks(search, pageable));
    }

}