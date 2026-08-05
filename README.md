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

## externalURLS
https://www.baeldung.com/hibernate-one-to-many

https://www.geeksforgeeks.org/sql/relationships-in-sql-one-to-one-one-to-many-many-to-many/

https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

https://github.com/harman-04/spring-data-jpa-criteria-specifications

https://github.com/AhmetAksunger/Jpa-Specifications-Example/blob/main/jpaspecifications/src/main/java/com/ahmetaksunger/jpaspecifications/specification/ProductSpecification.java

https://www.baeldung.com/spring-data-criteria-queries

https://medium.com/devxtalks/implementing-pagination-sorting-and-filtering-in-spring-boot-42615dbd74a7

https://medium.com/spring-boot-world/dynamically-querying-with-jpa-specification-ec5c41fff5d6

https://www.bezkoder.com/spring-boot-swagger-3/

https://medium.com/@anandjeyaseelan10/spring-boot-project-structure-explained-best-practices-c2ba46ea57eb

used dbschema 10.4.1 and spring boot to visualize ER diagrams






