package com.example.library_management.service;


import com.example.library_management.Dto.BookResponseDTO;
import com.example.library_management.Dto.NewBookDTO;
import com.example.library_management.entity.Book;
import com.example.library_management.exception.ResourceNotFound;
import com.example.library_management.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public NewBookDTO addBook(NewBookDTO request) {

        Book book = new Book();

        book.setTitle(request.getTitle());
        book.setIsbn(request.getIsbn());
        book.setPublicationYear(request.getPublicationYear());
        book.setAvailableCopies(request.getAvailableCopies());
        book.setVersion(request.getVersion());
        book.setAuthor_name(request.getAuthor_name());
        book.setCategory_name(request.getCategory_name());

        Book savedBook = repository.save(book);

        NewBookDTO response = new NewBookDTO();

        response.setTitle(savedBook.getTitle());
        response.setIsbn(savedBook.getIsbn());
        response.setPublicationYear(savedBook.getPublicationYear());
        response.setAvailableCopies(savedBook.getAvailableCopies());
        response.setVersion(savedBook.getVersion());
        response.setAuthor_name(savedBook.getAuthor_name());
        response.setCategory_name(savedBook.getCategory_name());

        return response;

    }

    public BookResponseDTO getBookById(Integer bookId) {

        Optional<Book> books = repository.findById(bookId);

        if (books.isEmpty()) {
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

    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    public void deleteBook(int bookId) {
        repository.deleteById(bookId);
    }

    public long getBookCount() {
        return repository.count();
    }






}
