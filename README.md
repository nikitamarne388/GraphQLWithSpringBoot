# GraphQLWithSpringBoot

# E-commerce Backend

A backend-only e-commerce application built while learning Java backend development.

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- GraphQL
- Maven
- Git and GitHub

## Features

- User management
- Order management
- Create, read, update, and delete operations
- GraphQL queries and mutations
- User-to-order relationships
- Database persistence using Spring Data JPA

## Project Structure

- `entities` — JPA entity classes
- `repositories` — database access and custom queries
- `services` — business logic
- `controllers` — GraphQL query and mutation handlers
- `resources/graphql` — GraphQL schema
- `resources/application.yml` — application configuration

## Prerequisites

- Java 17 or a compatible version configured for the project
- MySQL
- Maven
- IntelliJ IDEA or another Java IDE

## Database Setup

1. Create a MySQL database named `ecommerce_db`.
2. Configure your local database credentials using environment variables.
3. Start the Spring Boot application.

Never commit real database credentials to the repository.

## Running the Application

Run the `EcommerceApplication` main class from your IDE, or use Maven:

```bash
mvn spring-boot:run
```

The GraphQL endpoint is available at:

`http://localhost:8080/graphql`

## Learning Progress

- [x] Create Spring Boot application
- [x] Configure MySQL connection
- [x] Create User and Order entities
- [x] Create repository layer
- [x] Implement service layer
- [x] Define GraphQL schema
- [x] Implement GraphQL queries and mutations
- [ ] Add automated tests
- [ ] Add validation and error handling
- [ ] Improve authentication and authorization

## Purpose

This project is part of my ongoing learning journey in Java, Spring Boot, databases, and GraphQL.
