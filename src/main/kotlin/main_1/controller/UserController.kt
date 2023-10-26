package main_1.controller

import main_1.model.User
import org.springframework.beans.factory.annotation.Autowired
import main_1.repository.UserRepository
import main_1.service.UserService
import org.springframework.web.bind.annotation.*
import java.util.Optional

/**
 * REST Controller for managing User entities.
 * Provides API endpoints for operations related to the User entity.
 */
@RestController
@RequestMapping("/api/users")
class UserController(@Autowired private val userService: UserService) {

    /**
     * Get all Users.
     * @return A list of all Users.
     */
    @GetMapping("/")
    fun getAllUsers(): List<User> = userService.getAllUsers()

    /**
     * Get details of a specific User by ID.
     * @param userId The ID of the User to retrieve.
     * @return The User with the given ID.
     */
    @GetMapping("/{userId}")
    fun getUserDetails(@PathVariable userId: Long): User? {
        return userService.getUserById(userId)
    }
}

/*
Class: UserController

Description:
The UserController class is a REST Controller that provides API endpoints for operations related to the User entity.

Annotations:
- @RestController: Specifies that this is a REST Controller class.
- @RequestMapping: Maps the class to the "/api/users" URL path.

Methods:

- getAllUsers
    - Endpoint: GET /api/users/
    - Description: Retrieves all users.
    - Returns: A list of all Users.

- getUserDetails
    - Endpoint: GET /api/users/{userId}
    - Description: Retrieves a specific user's details by their ID.
    - Parameters:
        - userId (Long): The ID of the user to retrieve.
    - Returns: The User with the given ID.
*/
