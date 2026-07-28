package com.example.library_management.repository;

import com.example.library_management.entity.Book;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByTitle(String title);

    List<Book> findByIsbn(String isbn);

    List<Book> findByPublicationYear(long publicationYear);

    List<Book> findByAvailableCopies(int availableCopies);

    List<Book> findByTitleContaining(String keyword);

    List<Book> findByTitleStartingWith(String prefix);

    List<Book> findByTitleEndingWith(String suffix);

    List<Book> findByTitleIgnoreCase(String title);

    List<Book> findByPublicationYearGreaterThan(long year);

    List<Book> findByPublicationYearBetween(long start, long end);

    @Query("select bk from Book bk where bk.availableCopies > :copies")
    List<Book> findByAvailableCopiesGreaterThan(int copies);

    List<Book> findByAvailableCopiesLessThan(int copies);

    List<Book> findByAuthorAuthorName(String authorName);

    List<Book> findByCategoryCategoryName(String categoryName);

}
