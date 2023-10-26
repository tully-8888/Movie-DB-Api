package main_1.service

import main_1.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import main_1.repository.UserRepository

/**
 * Service class for User.
 * This class contains methods for CRUD operations related to the User entity.
 */
@Service
class UserService @Autowired constructor(private val userRepository: UserRepository) {

    /**
     * Create a new User.
     * @param user The user to be created.
     * @return The created User.
     */
    fun createUser(user: User): User {
        return userRepository.save(user)
    }

    /**
     * Get all Users.
     * @return A list of all Users.
     */
    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    /**
     * Get a User by their ID.
     * @param id The ID of the User.
     * @return The User with the given ID.
     */
    fun getUserById(id: Long): User {
        return userRepository.findById(id).orElse(null)
    }

    /**
     * Update a User.
     * @param id The ID of the User to be updated.
     * @param updatedUser The new details for the User.
     * @return The updated User.
     */
    fun updateUser(id: Long, updatedUser: User): User {
        val user = getUserById(id) ?: throw RuntimeException("User not found")
        return userRepository.save(
            user.copy(
                email = updatedUser.email,
                phoneNumber = updatedUser.phoneNumber,
                favoriteMovies = updatedUser.favoriteMovies,
                favoriteCategories = updatedUser.favoriteCategories,
                websiteTheme = updatedUser.websiteTheme
            )
        )
    }

    /**
     * Delete a User by their ID.
     * @param id The ID of the User to be deleted.
     */
    fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }
}

/*
Class: UserService

Description:
The UserService class is a Spring service that contains methods for CRUD operations related to the User entity.

Annotations:
- @Service: Specifies that this is a Spring service class.
- @Autowired: Specifies that the UserRepository dependency is to be automatically wired.

Methods:

- createUser
    - Description: Creates a new user.
    - Parameters:
        - user (User): The user to be created.
    - Returns: The created User.

- getAllUsers
    - Description: Retrieves all users.
    - Returns: A list of all Users.

- getUserById
    - Description: Retrieves a user by their ID.
    - Parameters:
        - id (Long): The ID of the user.
    - Returns: The User with the given ID.

- updateUser
    - Description: Updates a user's details.
    - Parameters:
        - id (Long): The ID of the user to be updated.
        - updatedUser (User): The new details for the user.
    - Returns: The updated User.

- deleteUser
    - Description: Deletes a user by their ID.
    - Parameters:
        - id (Long): The ID of the user to be deleted.
*/