package com.example.library_management.Dto;

import org.springframework.data.domain.Sort;

import java.util.List;

public class PaginationDTO<T> {

    private List<BookResponseDTO> content;
    private List<SortDTO> sort;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;

    public PaginationDTO(List<BookResponseDTO> content, List<SortDTO> sort, int pageNumber, int pageSize, long totalElements, int totalPages) {
        this.content = content;
        this.sort = sort;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public List<BookResponseDTO> getContent() {
        return content;
    }

    public void setContent(List<BookResponseDTO> content) {
        this.content = content;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<SortDTO> getSort() {
        return sort;
    }

    public void setSort(List<SortDTO> sort) {
        this.sort = sort;
    }
}
