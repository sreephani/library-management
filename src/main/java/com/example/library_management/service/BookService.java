package com.example.library_management.service;


import com.example.library_management.Dto.*;
import com.example.library_management.entity.Book;
import com.example.library_management.exception.ResourceNotFound;
import com.example.library_management.repository.BookRepository;
import com.example.library_management.specification.BookSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
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
        book.setAuthorName(request.getAuthor_name());
        book.setCategoryName(request.getCategory_name());

        Book savedBook = repository.save(book);

        NewBookDTO response = new NewBookDTO();

        response.setTitle(savedBook.getTitle());
        response.setIsbn(savedBook.getIsbn());
        response.setPublicationYear(savedBook.getPublicationYear());
        response.setAvailableCopies(savedBook.getAvailableCopies());
        response.setVersion(savedBook.getVersion());
        response.setAuthor_name(savedBook.getAuthorName());
        response.setCategory_name(savedBook.getCategoryName());

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
        dto.setAuthorName(book.getAuthorName());
        dto.setCategoryName(book.getCategoryName());

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

    public List<Book> getBooksByTitle(String title) {
        return repository.findByTitle(title);
    }

    public List<Book> getBooksByTitleContaining(String keyword){
        return repository.findByTitleContaining(keyword);
    }

    public List<Book> getBooksByTitlePrefix(String prefix){
        return repository.findByTitleStartingWith(prefix);
    }

    public List<Book> getBooksByAuthorName(String authorName){
        return repository.findByAuthorAuthorName(authorName);
    }

    public List<Book> getBooksByCategoryName(String categoryName){
        return repository.findByCategoryCategoryName(categoryName);
    }

    public List<Book> getBooksByAvailableCopiesGreaterThan(int copies){
        return repository.findByAvailableCopiesGreaterThan(copies);
    }

    public List<Book> getBooksByPublicationYearGreaterThan(long year){
        return repository.findByPublicationYearGreaterThan(year);
    }

    public PaginationDTO<BookResponseDTO> getSearchBooks(SearchDTO bookSearch, Pageable pageable) {

        BookSpecification specification = new BookSpecification(bookSearch);

        Page<Book> books =
                repository.findAll(specification, pageable);

        List<BookResponseDTO> bookResponse = new ArrayList<>();
        for(Book book: books.getContent()){

            BookResponseDTO bookResponseDTO = new BookResponseDTO();
            bookResponseDTO.setTitle(book.getTitle());
            bookResponseDTO.setAuthorName(book.getAuthorName());
            bookResponseDTO.setCategoryName(book.getCategoryName());

            bookResponse.add(bookResponseDTO);
        }

        List<SortDTO> sortList = new ArrayList<>();
        for(Sort.Order sort : books.getSort()){

            SortDTO sortDTO = new SortDTO();
            sortDTO.setProperty(sort.getProperty());
            sortDTO.setDirection(sort.getDirection());

            sortList.add(sortDTO);
        }


        return new PaginationDTO<>(
                bookResponse,
                sortList,
                books.getTotalPages(),
                (int) books.getTotalElements(),
                books.getSize(),
                books.getNumber()
        );
    }


}
