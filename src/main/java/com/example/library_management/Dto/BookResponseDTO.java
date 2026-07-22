package com.example.library_management.Dto;

public class BookResponseDTO {

    private String title;
    private String authorName;
    private String categoryName;

    public BookResponseDTO(int bookId, String authorName, String categoryName) {
    }

    public BookResponseDTO() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
