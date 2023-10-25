package main_1.controller

import main_1.model.User
import org.springframework.beans.factory.annotation.Autowired
import main_1.repository.UserRepository
import main_1.service.UserService
import org.springframework.web.bind.annotation.*
import java.util.Optional

@RestController
@RequestMapping("/api")
class UserController(@Autowired private val userService: UserService) {


    @PostMapping("/")
    fun createUser(@RequestBody user: User): User {
        return userService.createUser(user)
    }

    @GetMapping("/")
    fun getAllUsers(): List<User> {
        return userService.getAllUsers()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): User? {
        return userService.getUserById(id)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody updatedUser: User): User {
        return userService.updateUser(id, updatedUser)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) {
        userService.deleteUser(id)
    }
}