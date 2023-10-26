package main_1.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

/**
 * Entity class for User.
 * This class represents a User entity with various attributes like email, phoneNumber, etc.
 */
@Entity(name = "UserEntity")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    /** User's email */
    val email: String = "",

    /** User's phone number */
    val phoneNumber: String = "",

    /** User's favorite movies */
    val favoriteMovies: String = "",

    /** User's favorite categories */
    val favoriteCategories: String = "",

    /** User's website theme */
    val websiteTheme: String = ""
) {
    constructor() : this(0, "", "", "", "", "")
}

/*
Data Class: User

Description:
The User data class is an Entity class that represents a user with various attributes like email, phoneNumber, favoriteMovies, etc.

Annotations:
- @Entity(name = "UserEntity"): Specifies that this is an entity class and maps it to the table "UserEntity".
- @Id: Specifies the identifier property of this entity.
- @GeneratedValue: Specifies how the primary key should be generated.

Attributes:
- id (Long): The unique identifier for a user.
- email (String): The email of the user.
- phoneNumber (String): The phone number of the user.
- favoriteMovies (String): The favorite movies of the user.
- favoriteCategories (String): The favorite categories of the user.
- websiteTheme (String): The website theme preference of the user.

Constructors:
- Default constructor initializes all fields to their default values.
*/