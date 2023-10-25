package main

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import service.MovieService
import service.UserService

@SpringBootApplication
open class MyApplication

fun main(args: Array<String>) {
    val context: ApplicationContext = runApplication<MyApplication>(*args)

    val movieService = context.getBean(MovieService::class.java)
    val userService = context.getBean(UserService::class.java)

    val movies = movieService.getAllMovies()
    println("Movies: $movies")

    val users = userService.getAllUsers()
    println("Users: $users")
}