package main.controller

import main.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import main.repository.UserRepository
import java.util.Optional

@RestController
@RequestMapping("/api")
class UserController(@Autowired private val userRepository: UserRepository) {

    @GetMapping("/users")
    fun getAllUsers(): MutableList<User> = userRepository.findAll()

    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable id: Long): Optional<User> = userRepository.findById(id)
}