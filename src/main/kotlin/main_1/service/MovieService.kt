package main_1.service

import main_1.model.Movie
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import main_1.repository.MovieRepository

/**
 * Service class for Movie.
 * This class contains methods for CRUD operations and additional queries related to the Movie entity.
 */
@Service
class MovieService @Autowired constructor(private var movieRepository: MovieRepository) {

    /**
     * Create a new Movie.
     * @param movie The Movie to be created.
     * @return The created Movie.
     */
    fun createMovie(movie: Movie): Movie {
        return movieRepository.save(movie)
    }

    /**
     * Get all Movies.
     * @return A list of all Movies.
     */
    fun getAllMovies(): MutableList<Movie?> {
        return movieRepository.findAll()
    }

    /**
     * Get a Movie by its ID.
     * @param id The ID of the Movie.
     * @return The Movie with the given ID.
     */
    fun getMovieById(id: Long): Movie? {
        return movieRepository.findById(id).orElse(null)
    }

    /**
     * Update a Movie.
     * @param id The ID of the Movie to be updated.
     * @param updatedMovie The new details for the Movie.
     * @return The updated Movie.
     */
    fun updateMovie(id: Long, updatedMovie: Movie): Movie {
        val movie = getMovieById(id) ?: throw RuntimeException("Movie not found")
        return movieRepository.save(
            movie.copy(
                title = updatedMovie.title,
                description = updatedMovie.description,
                genre = updatedMovie.genre,
                tags = updatedMovie.tags,
                length = updatedMovie.length,
                dateReleased = updatedMovie.dateReleased,
                dateAvailableUntil = updatedMovie.dateAvailableUntil,
                metaTitle = updatedMovie.metaTitle,
                metaDescription = updatedMovie.metaDescription
            )
        )
    }

    /**
     * Delete a Movie by its ID.
     * @param id The ID of the Movie to be deleted.
     */
    fun deleteMovie(id: Long) {
        movieRepository.deleteById(id)
    }

    /**
     * Get Movies by genre.
     * @param genre The genre to filter movies by.
     * @return A list of Movies with the specified genre.
     */
    fun getMoviesByGenre(genre: String): List<Movie?>? {
        return movieRepository.findByGenre(genre)
    }

    /**
     * Get Movies by tag.
     * @param tag The tag to filter movies by.
     * @return A list of Movies with the specified tag.
     */
    fun getMoviesByTag(tag: String): List<Movie?>? {
        return movieRepository.findByTags(tag)
    }
}

/*
Class: MovieService

Description:
The MovieService class is a Spring service that contains methods for CRUD operations and additional queries related to the Movie entity.

Annotations:
- @Service: Specifies that this is a Spring service class.
- @Autowired: Specifies that the MovieRepository dependency is to be automatically wired.

Methods:

- createMovie
    - Description: Creates a new movie.
    - Parameters:
        - movie (Movie): The Movie to be created.
    - Returns: The created Movie.

- getAllMovies
    - Description: Retrieves all movies.
    - Returns: A list of all Movies.

- getMovieById
    - Description: Retrieves a movie by its ID.
    - Parameters:
        - id (Long): The ID of the movie.
    - Returns: The Movie with the given ID.

- updateMovie
    - Description: Updates a movie's details.
    - Parameters:
        - id (Long): The ID of the movie to be updated.
        - updatedMovie (Movie): The new details for the movie.
    - Returns: The updated Movie.

- deleteMovie
    - Description: Deletes a movie by its ID.
    - Parameters:
        - id (Long): The ID of the movie to be deleted.

- getMoviesByGenre
    - Description: Retrieves movies by their genre.
    - Parameters:
        - genre (String): The genre to filter movies by.
    - Returns: A list of Movies with the specified genre.

- getMoviesByTag
    - Description: Retrieves movies by their tag.
    - Parameters:
        - tag (String): The tag to filter movies by.
    - Returns: A list of Movies with the specified tag.
*/