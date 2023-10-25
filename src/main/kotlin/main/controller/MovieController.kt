package main.controller

import main.model.Movie
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import main.repository.MovieRepository

@RestController
@RequestMapping("/api")
class MovieController(@Autowired private val movieRepository: MovieRepository) {

    @GetMapping("/movies")
    fun getAllMovies(): MutableList<Movie> = movieRepository.findAll()

    @GetMapping("/movies/{genre}")
    fun getMoviesByGenre(@PathVariable genre: String) = movieRepository.findByGenre(genre)

    @GetMapping("/movies/tag/{tag}")
    fun getMoviesByTag(@PathVariable tag: String) = movieRepository.findByTags(tag)
}