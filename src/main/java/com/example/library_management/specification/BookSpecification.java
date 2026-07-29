package com.example.library_management.specification;

import com.example.library_management.Dto.SearchDTO;
import com.example.library_management.entity.Book;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


public class BookSpecification implements Specification<Book> {

    private SearchDTO bookSearch;

    public BookSpecification(SearchDTO bookSearch) {
        this.bookSearch = bookSearch;
    }

    @Override
    @Nullable
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        List<Predicate> predicate = new ArrayList<>();

        if (bookSearch.getTitle() != null) {
            predicate.add(cb.like(
                    root.get("title"),
                    "%" + bookSearch.getTitle() + "%"
            ));
        }

        if (bookSearch.getAuthorName() != null) {
            predicate.add(cb.like(
                    root.get("authorName"),
                    "%" + bookSearch.getAuthorName() + "%"
            ));
        }

        return cb.and(predicate.toArray(new Predicate[0]));

    }
}
