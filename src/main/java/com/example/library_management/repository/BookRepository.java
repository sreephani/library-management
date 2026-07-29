package com.example.library_management.repository;

import com.example.library_management.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {

    List<Book> findByTitle(String title);

    List<Book> findByIsbn(String isbn);

    List<Book> findByPublicationYear(long publicationYear);

    List<Book> findByAvailableCopies(int availableCopies);

    List<Book> findByTitleContaining(String keyword);

    List<Book> findByTitleStartingWith(String prefix);

    List<Book> findByTitleEndingWith(String suffix);

    List<Book> findByTitleIgnoreCase(String title);

    @Query(value = "select * from book bk where bk.publication_year > :year", nativeQuery = true)
    List<Book> findByPublicationYearGreaterThan(long year);

    List<Book> findByPublicationYearBetween(long start, long end);

    //jpql
    @Query("select bk from Book bk where bk.availableCopies > :copies")
    List<Book> findByAvailableCopiesGreaterThan(int copies);

    @Query("select bk from Book bk where bk.availableCopies < :copies")
    List<Book> findByAvailableCopiesLessThan(int copies);

    List<Book> findByAuthorAuthorName(String authorName);

    List<Book> findByCategoryCategoryName(String categoryName);

    Page<Book> findAll(
            Specification<Book> specification,
            Pageable pageable
    );

}
