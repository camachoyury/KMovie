package com.camachoyury.kmovie.data.network

import com.camachoyury.kmovie.domain.Movie
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class MovieEntity(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("poster_path")
    val posterImage: String,
    @SerialName("release_date")
    val releaseDate: String
) {
    internal fun toMovie(): Movie {
        return Movie(
            id = id,
            title = title,
            description = overview,
            imageUrl = "https://image.tmdb.org/t/p/w500/$posterImage",
            releaseDate = releaseDate
        )
    }


}



