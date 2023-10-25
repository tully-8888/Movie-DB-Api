package main_1.service

import main_1.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import main_1.repository.UserRepository

@Service
class UserService @Autowired constructor(private val userRepository: UserRepository) {

    fun createUser(user: User): User {
        return userRepository.save(user)
    }

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    fun getUserById(id: Long): User? {
        return userRepository.findById(id).orElse(null)
    }

    fun updateUser(id: Long, updatedUser: User): User {
        val user = getUserById(id) ?: throw RuntimeException("User not found")
        return userRepository.save(
            user.copy(
                email = updatedUser.email,
                phoneNumber = updatedUser.phoneNumber,
                favoriteMovies = updatedUser.favoriteMovies,
                favoriteCategories = updatedUser.favoriteCategories,
                websiteTheme = updatedUser.websiteTheme
            )
        )
    }

    fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }
}
