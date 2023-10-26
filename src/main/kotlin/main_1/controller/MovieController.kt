package main_1.controller

import main_1.model.Movie
import org.springframework.beans.factory.annotation.Autowired
import main_1.repository.MovieRepository
import main_1.service.MovieService
import org.springframework.web.bind.annotation.*

/**
 * REST Controller for managing Movie entities.
 * Provides API endpoints for operations related to the Movie entity.
 */
@RestController
@RequestMapping("/api/movies")
class MovieController(@Autowired private val movieService: MovieService) {

    /**
     * Get all Movies.
     * @return A list of all Movies.
     */
    @GetMapping("/")
    fun getAllMovies(): MutableList<Movie?> = movieService.getAllMovies()

    /**
     * Get details of Movies by a specific category (genre).
     * @param category The category (genre) to filter movies by.
     * @return A list of Movies matching the specified category (genre).
     */
    @GetMapping("/category/{category}")
    fun getMoviesByCategory(@PathVariable category: String): List<Movie?>? {
        return movieService.getMoviesByGenre(category)
    }

    /**
     * Get details of Movies by a specific tag.
     * @param tag The tag to filter movies by.
     * @return A list of Movies matching the specified tag.
     */
    @GetMapping("/tag/{tag}")
    fun getMoviesByTag(@PathVariable tag: String): List<Movie?>? {
        return movieService.getMoviesByTag(tag)
    }
}

/*
Class: MovieController

Description:
The MovieController class is a REST Controller that provides API endpoints for operations related to the Movie entity.

Annotations:
- @RestController: Specifies that this is a REST Controller class.
- @RequestMapping: Maps the class to the "/api/movies" URL path.

Methods:

- getAllMovies
    - Endpoint: GET /api/movies/
    - Description: Retrieves all movies.
    - Returns: A list of all Movies.

- getMoviesByCategory
    - Endpoint: GET /api/movies/category/{category}
    - Description: Retrieves movies by their category (genre).
    - Parameters:
        - category (String): The category (genre) to filter movies by.
    - Returns: A list of Movies matching the specified category.

- getMoviesByTag
    - Endpoint: GET /api/movies/tag/{tag}
    - Description: Retrieves movies by their tag.
    - Parameters:
        - tag (String): The tag to filter movies by.
    - Returns: A list of Movies matching the specified tag.
*/