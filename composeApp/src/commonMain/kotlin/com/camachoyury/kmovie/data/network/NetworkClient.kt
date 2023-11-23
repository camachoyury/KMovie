package com.camachoyury.kmovie.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class NetworkClient {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    suspend fun getMovies(): MoviesResponse {
        val url = "https://api.themoviedb.org/3/movie/popular?api_key=ea34d9b6d5b890cf49efe5cca27784bd"
        return client.get(url).body()
    }
}

private const val BASE_URL = "https://api.themoviedb.org/"
private const val API_KEY = "ea34d9b6d5b890cf49efe5cca27784bd"