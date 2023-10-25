package main_1.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
data class Movie(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val title: String = "",
    val description: String = "",
    val genre: String = "",
    val tags: String = "",
    val length: Int = 0,
    val dateReleased: String = "",
    val dateAvailableUntil: String = "",
    val metaTitle: String? = null,
    val metaDescription: String? = null
) {
    constructor() : this(0, "", "", "", "", 0, "", "", null, null)
}
