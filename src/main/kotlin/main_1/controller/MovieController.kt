package main_1.controller

import main_1.model.Movie
import org.springframework.beans.factory.annotation.Autowired
import main_1.repository.MovieRepository
import main_1.service.MovieService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/movies")
class MovieController(@Autowired private val movieService: MovieService) {

    // Endpoint to expose all movies
    @GetMapping("/")
    fun getAllMovies(): MutableList<Movie?> = movieService.getAllMovies()

    // Endpoint to expose all movies in a category
    @GetMapping("/category/{category}")
    fun getMoviesByCategory(@PathVariable category: String): List<Movie?>? {
        return movieService.getMoviesByGenre(category)
    }

    // Endpoint to expose all movies with a specific tag
    @GetMapping("/tag/{tag}")
    fun getMoviesByTag(@PathVariable tag: String): List<Movie?>? {
        return movieService.getMoviesByTag(tag)
    }
}