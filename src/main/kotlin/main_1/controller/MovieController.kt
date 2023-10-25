package main_1.controller

import main_1.model.Movie
import org.springframework.beans.factory.annotation.Autowired
import main_1.repository.MovieRepository
import main_1.service.MovieService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class MovieController() {

    @Autowired
    private lateinit var movieService: MovieService

    @PostMapping("/")
    fun createMovie(@RequestBody movie: Movie): Movie {
        return movieService.createMovie(movie)
    }

    @GetMapping("/")
    fun getAllMovies(): List<Movie> {
        return movieService.getAllMovies()
    }

    @GetMapping("/{id}")
    fun getMovieById(@PathVariable id: Long): Movie? {
        return movieService.getMovieById(id)
    }

    @PutMapping("/{id}")
    fun updateMovie(@PathVariable id: Long, @RequestBody updatedMovie: Movie): Movie {
        return movieService.updateMovie(id, updatedMovie)
    }

    @DeleteMapping("/{id}")
    fun deleteMovie(@PathVariable id: Long) {
        movieService.deleteMovie(id)
    }

    @GetMapping("/genre/{genre}")
    fun getMoviesByGenre(@PathVariable genre: String): List<Movie> {
        return movieService.getMoviesByGenre(genre)
    }

    @GetMapping("/tag/{tag}")
    fun getMoviesByTag(@PathVariable tag: String): List<Movie> {
        return movieService.getMoviesByTag(tag)
    }
}
