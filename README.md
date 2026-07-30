# Library Management System

A Spring Boot REST API for managing books, authors, and categories using Java, Spring Data JPA, Hibernate, and MySQL.

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA / Hibernate
- MySQL
- Maven
- Swagger OpenAPI

## Features

- CRUD operations for books
- JPA entity relationships
  - Author → Books
  - Category → Books
- DTO-based request and response handling
- Spring Data JPA queries
  - Derived queries
  - JPQL
  - Native SQL
- Dynamic search using JPA Specification
- Pagination and default sorting(only ascending)
- Validation and global exception handling
- Swagger API documentation

## Search Features

Supports searching books by:

- Title
- Author
- Category
- Publication year
- isbn


## Project Structure
controller
service
repository
entity
dto
specification
exception
config


## Swagger UI
http://localhost:8080/swagger-ui/index.html


## Future Enhancements

- Spring Security with JWT Authentication
- Unit testing with JUnit and Mockito





