package main_1

import main_1.model.Movie
import main_1.model.User
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.ComponentScan
import main_1.service.MovieService
import main_1.service.UserService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EntityScan(basePackages = ["main_1.model"])
open class MyApplication {
    @Bean
    fun init(movieService: MovieService, userService: UserService): CommandLineRunner {
        return CommandLineRunner {
            // Create dummy movies
            val movie1 = Movie(
                title = "Inception",
                description = "A mind-bending thriller",
                genre = "Science Fiction",
                tags = "thriller,sci-fi",
                length = 148,
                dateReleased = "2010-07-16",
                dateAvailableUntil = "2025-12-31",
                metaTitle = "Inception Movie",
                metaDescription = "Inception is a 2010 science fiction action film written and directed by Christopher Nolan."
            )

            val movie2 = Movie(
                title = "The Matrix",
                description = "A computer hacker learns from rebels about the true nature of his reality",
                genre = "Action",
                tags = "action,sci-fi",
                length = 136,
                dateReleased = "1999-03-31",
                dateAvailableUntil = "2025-12-31",
                metaTitle = "The Matrix Movie",
                metaDescription = "The Matrix is a 1999 science fiction action film written and directed by the Wachowskis."
            )
//
            movieService.saveMovie(movie1)
  //          movieService.saveMovie(movie2)

            // Create dummy users
            val user1 = User(
                email = "john.doe@example.com",
                phoneNumber = "0700000000",
                favoriteMovies = "Inception,The Matrix",
                favoriteCategories = "Action,Science Fiction",
                websiteTheme = "dark"
            )

            val user2 = User(
                email = "jane.doe@example.com",
                phoneNumber = "07111111111",
                favoriteMovies = "Inception",
                favoriteCategories = "Science Fiction",
                websiteTheme = "light"
            )

            userService.saveUser(user1)
            userService.saveUser(user2)
        }
    }
}

fun main(args: Array<String>) {
    val context: ApplicationContext = runApplication<MyApplication>(*args)

    val movieService = context.getBean(MovieService::class.java)
    val userService = context.getBean(UserService::class.java)

        val movies = movieService.getAllMovies()
        println("Movies: $movies")

        val users = userService.getAllUsers()
        println("Users: $users")
    /*
           */
}
