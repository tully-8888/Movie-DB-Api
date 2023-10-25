package main_1.repository

import main_1.model.Movie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository : JpaRepository<Movie, Long> {
    fun findByGenre(genre: String): List<Movie>
    fun findByTags(tag: String): List<Movie>
}