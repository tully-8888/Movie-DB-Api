package main_1.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "UserEntity")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val email: String = "",
    val phoneNumber: String="",
    val favoriteMovies: String = "",
    val favoriteCategories:  String = "",
    val websiteTheme: String = ""
) {
    constructor() : this(0, "", "", "", "", "")
}

