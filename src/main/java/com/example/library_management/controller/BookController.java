package com.example.library_management.controller;

import com.example.library_management.Dto.BookResponseDTO;
import com.example.library_management.Dto.NewBookDTO;
import com.example.library_management.Dto.PaginationDTO;
import com.example.library_management.Dto.SearchDTO;
import com.example.library_management.entity.Book;
import com.example.library_management.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/books")
@Tag(
        name = "Books",
        description = "APIs for managing books"
)
public class BookController {

    @Autowired
    private BookService bookService;



    @PostMapping()
    @Operation(
            summary = "Add a new book",
            description = "Adds a new book to the library"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Book created successfully"
    )
    public ResponseEntity<NewBookDTO> addBook(@RequestBody NewBookDTO newBookRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(newBookRequest));
    }

    @GetMapping("/{bookId}")
    @Operation(
            summary = "Get book by ID",
            description = "Retrieves a single book using primary key bookId"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Book found"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Book not found"
            )
    })
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Integer bookId) {

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(bookId));
    }

    @GetMapping()
    @Operation(
            summary = "Get all books",
            description = "Retrieves all books"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Books retrieved successfully"
            )
    })
    public ResponseEntity<List<Book>> getAllBooks() {

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @DeleteMapping("/{bookId}")
    @Operation(
            summary = "Delete book by ID",
            description = "Deletes a book from the library using its unique identifier"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Book deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Book not found"
            )
    })
    public ResponseEntity<Void> deleteBook(@PathVariable int bookId) {

        bookService.deleteBook(bookId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/count")
    @Operation(
            summary = "Count total books",
            description = "Returns the total number of books in the library"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Book count retrieved successfully"
    )
    public ResponseEntity<Long> getBookCount() {

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookCount());
    }


    @ApiResponses({

            @ApiResponse(
                    responseCode = "200",
                    description = "Books found successfully",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = BookResponseDTO.class
                            )
                    )
            ),

            @ApiResponse(
                    responseCode = "404",
                    description = "No books found with the given title"
            ),

            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error"
            )
    })
    @GetMapping("/title/{title}")
    public ResponseEntity<List<Book>> getBooksByTitle(@PathVariable String title) {

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksByTitle(title));
    }

    @ApiResponses({

            @ApiResponse(
                    responseCode = "200",
                    description = "Books found successfully",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(
                                    schema = @Schema(
                                            implementation = BookResponseDTO.class
                                    )
                            )
                    )
            ),

            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid search keyword"
            ),

            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error"
            )
    })
    @GetMapping("/title-keyword/{keyword}")
    public ResponseEntity<List<Book>> getBooksByTitleContaining(@PathVariable String keyword) {

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksByTitleContaining(keyword));
    }

    @Operation(
            summary = "Search books by title prefix",
            description = "Retrieves books where the title starts with the provided prefix"
    )
    @ApiResponses({

            @ApiResponse(
                    responseCode = "200",
                    description = "Books retrieved successfully",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(
                                    schema = @Schema(
                                            implementation = BookResponseDTO.class
                                    )
                            )
                    )
            ),

            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid prefix value"
            ),

            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error"
            )
    })
    @GetMapping("/title-prefix/{prefix}")
    public ResponseEntity<List<Book>> getBooksByPrefix(@PathVariable String prefix) {
        
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksByTitlePrefix(prefix));
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
    @Operation(
            summary = "Search books",
            description = "Search books using search filters with pagination and sorting"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Books retrieved successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid search parameters"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No books found"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error"
            )
    })
    public ResponseEntity<PaginationDTO<BookResponseDTO>> getSearchBooks(@ModelAttribute SearchDTO search, Pageable pageable) {

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getSearchBooks(search, pageable));
    }

}