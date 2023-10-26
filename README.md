# MovieDB API

## Table of Contents

- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Architecture](#architecture)
- [Database](#database)
- [How to Run](#how-to-run)
- [API Documentation](#api-documentation)
- [Testing](#testing)
- [License](#license)

## Overview

This project is a Spring Boot-based RESTful API for a Movie Database. It includes features like adding, updating, deleting, and fetching movie and user details.

## Prerequisites

- Java 8 or higher
- Spring Boot 2.5.x
- Maven
- H2 Database (In-memory)

## Architecture

The project follows the MVC (Model-View-Controller) architecture and is structured as follows:

- `Model`: Contains entity classes `Movie` and `User`, which map to database tables.
- `Repository`: Includes Spring Data JPA repositories to handle database operations.
- `Service`: Houses the business logic and calls the methods defined in the repositories.
- `Controller`: Consists of RESTful API endpoints for client-server interaction.

## Database

We are using an H2 in-memory database for storing movie and user details. The database configuration is specified in the `application.properties` file. H2 database has been chosen for simplicity and is not suitable for production environments.

```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
...
```

Your application should now be running on `http://localhost:8080`.

## API Documentation

### Movie API

#### Get All Movies

```http
GET /api/movies/
```

#### Get Movies by Category

```http
GET /api/movies/category/{category}
```

#### Get Movies by Tag

```http
GET /api/movies/tag/{tag}
```

### User API

#### Get All Users

```http
GET /api/users/
```

#### Get User by ID

```http
GET /api/users/{userId}
```

## Testing

You can test the APIs using tools like Postman or any other HTTP client of your choice.

## License

MIT License. See the [LICENSE](LICENSE) file for more information.

---

This README is designed to be straightforward and easy to read. Replace the placeholders and add additional sections as your project grows.
