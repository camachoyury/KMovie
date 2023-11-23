package com.camachoyury.kmovie.data.network

@kotlinx.serialization.Serializable
data class MoviesResponse(
    val results: List<MovieEntity>
)
