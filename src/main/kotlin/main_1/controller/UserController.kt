package main_1.controller

import main_1.model.User
import org.springframework.beans.factory.annotation.Autowired
import main_1.repository.UserRepository
import main_1.service.UserService
import org.springframework.web.bind.annotation.*
import java.util.Optional

@RestController
@RequestMapping("/api/users")
class UserController(@Autowired private val userService: UserService) {

    // Endpoint to expose all users
    @GetMapping("/")
    fun getAllUsers(): List<User> = userService.getAllUsers()

    // Endpoint to expose one single user’s details (with movies)
    @GetMapping("/{userId}")
    fun getUserDetails(@PathVariable userId: Long): User? {
        return userService.getUserById(userId)
    }
}