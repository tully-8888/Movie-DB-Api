package service

import model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import repository.UserRepository

@Service
class UserService @Autowired constructor(private val userRepository: UserRepository) {

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

}