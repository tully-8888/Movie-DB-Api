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

/**
 * Entry point for the Spring Boot application.
 * Scans the specified packages for entity classes.
 */
@SpringBootApplication
@EntityScan(basePackages = ["main_1.model"])
open class MyApplication

/**
 * Main function to launch the Spring Boot application.
 * @param args Command line arguments.
 */
fun main(args: Array<String>) {
    val context: ApplicationContext = runApplication<MyApplication>(*args)

    /**
     * Retrieve MovieService bean.
     */
    val movieService = context.getBean(MovieService::class.java)

    /**
     * Retrieve UserService bean.
     */
    val userService = context.getBean(UserService::class.java)

}

/*
Class: MyApplication

Description:
The MyApplication class serves as the entry point for the Spring Boot application. It includes the @SpringBootApplication and @EntityScan annotations to bootstrap the application and scan the specified package for entity classes. The main function initializes the Spring application context and retrieves the necessary beans for MovieService and UserService.

Annotations:
- @SpringBootApplication: Specifies that the class serves as the entry point for a Spring Boot application.
- @EntityScan: Specifies the base packages to scan for entity classes.

Functions:

- main
    - Parameters:
        - args (Array<String>): Command line arguments.
    - Description: Initializes the Spring application context and retrieves the necessary beans for MovieService and UserService.
*/