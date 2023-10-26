package main_1.repository

import main_1.model.Movie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Repository interface for Movie entities.
 */
@Repository
interface MovieRepository : JpaRepository<Movie?, Long?> {
    /**
     * Finds movies by their genre.
     *
     * @param genre The genre to filter by.
     * @return A list of movies that belong to the specified genre.
     */
    fun findByGenre(genre: String?): List<Movie?>?

    /**
     * Finds movies by their tags.
     *
     * @param tag The tag to filter by.
     * @return A list of movies that have the specified tag.
     */
    fun findByTags(tag: String?): List<Movie?>?
}

/*
Interface: MovieRepository

Description:
The MovieRepository interface serves as a Spring repository for the Movie entity. It extends the JpaRepository from Spring Data JPA to provide CRUD operations, and additionally defines methods for custom queries.

Annotations:
- @Repository: Specifies that the interface is a Spring repository.

Extends:
- JpaRepository<Movie, Long>: Inherits CRUD methods for handling Movie objects with primary keys of type Long.

Methods:

findByGenre
- Signature: List<Movie> findByGenre(String genre)
- Parameters:
    - genre (String): The genre to filter movies by.
- Returns:
    - List<Movie>: A list of movies matching the specified genre.
- Description: Retrieves movies that have the specified genre.

findByTags
- Signature: List<Movie> findByTags(String tag)
- Parameters:
    - tag (String): The tag to filter movies by.
- Returns:
    - List<Movie>: A list of movies matching the specified tag.
- Description: Retrieves movies that have the specified tag.
*/
