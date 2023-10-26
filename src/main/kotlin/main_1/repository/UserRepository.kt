package main_1.repository

import main_1.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Repository interface for User entities.
 */
@Repository
interface UserRepository : JpaRepository<User, Long>

/*
Interface: UserRepository

Description:
The UserRepository interface serves as a Spring repository for the User entity. It extends the JpaRepository from Spring Data JPA to provide CRUD operations.

Annotations:
- @Repository: Specifies that the interface is a Spring repository.

Extends:
- JpaRepository<User, Long>: Inherits CRUD methods for handling User objects with primary keys of type Long.

Methods:
Here, you would list any custom query methods that the interface might have. As of now, there are none. Custom query methods could be added to handle specific requirements.

*/