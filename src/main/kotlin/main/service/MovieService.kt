package main.service

import main.model.Movie
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import main.repository.MovieRepository

@Service
class MovieService @Autowired constructor(private val movieRepository: MovieRepository) {

    fun getAllMovies(): List<Movie> {
        return movieRepository.findAll()
    }

    fun getMoviesByGenre(genre: String): List<Movie> {
        return movieRepository.findByGenre(genre)
    }

    fun getMoviesByTag(tag: String): List<Movie> {
        return movieRepository.findByTags(tag)
    }

}