package main_1.service

import main_1.model.Movie
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import main_1.repository.MovieRepository

@Service
class MovieService @Autowired constructor (private var movieRepository: MovieRepository){

    fun createMovie(movie: Movie): Movie {
        return movieRepository.save(movie)
    }

    fun getAllMovies(): List<Movie> {
        return movieRepository.findAll()
    }

    fun getMovieById(id: Long): Movie? {
        return movieRepository.findById(id).orElse(null)
    }

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

    fun deleteMovie(id: Long) {
        movieRepository.deleteById(id)
    }

    fun getMoviesByGenre(genre: String): List<Movie> {
        return movieRepository.findByGenre(genre)
    }

    fun getMoviesByTag(tag: String): List<Movie> {
        return movieRepository.findByTags(tag)
    }
}