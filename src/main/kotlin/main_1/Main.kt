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
open class MyApplication

    fun main(args: Array<String>) {
        val context: ApplicationContext = runApplication<MyApplication>(*args)

        val movieService = context.getBean(MovieService::class.java)
        val userService = context.getBean(UserService::class.java)

    }

