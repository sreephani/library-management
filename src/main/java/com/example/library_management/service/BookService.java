package com.example.library_management.service;


import com.example.library_management.Dto.BookResponseDTO;
import com.example.library_management.entity.Book;
import com.example.library_management.exception.ResourceNotFound;
import com.example.library_management.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//The @Service annotation is used to indicate that a class belongs to the service layer in an application.
// The service layer typically contains the business logic of the application.
// The @Service annotation is a specialization of the @Component annotation,
// meaning that classes annotated with @Service are automatically detected during classpath scanning.
public class BookService {

    //Spring Framework annotation used for automatic Dependency Injection
    //https://www.geeksforgeeks.org/advance-java/spring-dependency-injection-with-example/
    @Autowired
    private BookRepository repository;

    public Book addBook(Book book) {
        return repository.save(book);
    }


    public BookResponseDTO getBookById(Integer bookId) {

        Optional<Book> books = repository.findById(bookId);

        if(books.isEmpty()){
            throw new ResourceNotFound(
                    "Book not found with id: " + bookId);
        }

        Book book = books.get();

        BookResponseDTO dto = new BookResponseDTO();
        dto.setTitle(book.getTitle());
        dto.setAuthorName(book.getAuthor_name());
        dto.setCategoryName(book.getCategory_name());

        return dto;
    }
}
