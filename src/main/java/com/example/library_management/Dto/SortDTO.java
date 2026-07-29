package com.example.library_management.Dto;

import org.springframework.data.domain.Sort;

public class SortDTO {

    private String property;
    private Sort.Direction direction;


    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Sort.Direction getDirection() {
        return direction;
    }

    public void setDirection(Sort.Direction direction) {
        this.direction = direction;
    }
}
