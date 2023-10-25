package model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val email: String = "",
    val phoneNumber: String? = null,
    val favoriteMovies: String? = null,
    val favoriteCategories: String? = null,
    val websiteTheme: String? = null
) {
    constructor() : this(0, "", null, null, null, null)
}

