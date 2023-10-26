package main_1.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


/**
 * Entity class for Movie.
 * This class represents a Movie entity with various attributes like title, description, genre, etc.
 */
@Entity
data class Movie(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    /** Title of the movie */
    val title: String = "",

    /** Description of the movie */
    val description: String = "",

    /** Genre of the movie */
    val genre: String = "",

    /** Tags associated with the movie */
    val tags: String = "",

    /** Length of the movie in minutes */
    val length: Int = 0,

    /** Date the movie was released */
    val dateReleased: String = "",

    /** Date the movie is available until */
    val dateAvailableUntil: String = "",

    /** Meta title */
    val metaTitle: String? = null,

    /** Meta description */
    val metaDescription: String? = null
) {
    constructor() : this(0, "", "", "", "", 0, "", "", null, null)
}

/*
Data Class: Movie

Description:
The Movie data class is an Entity class representing a movie with various fields like title, description, genre, etc.

Annotations:
- @Entity: Specifies that this is an entity class.
- @Id: Specifies the identifier property of this entity.
- @GeneratedValue: Specifies how the primary key should be generated.

Attributes:
- id (Long): The unique identifier for a movie.
- title (String): The title of the movie.
- description (String): A brief description of the movie.
- genre (String): The genre of the movie.
- tags (String): Tags associated with the movie.
- length (Int): The length of the movie in minutes.
- dateReleased (String): The date the movie was released.
- dateAvailableUntil (String): The date the movie is available until.
- metaTitle (String?): Meta title for SEO.
- metaDescription (String?): Meta description for SEO.

Constructors:
- Default constructor initializes all fields to their default values.
*/
