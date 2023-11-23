package com.camachoyury.kmovie.domain


import com.camachoyury.kmovie.data.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class MoviesUseCase (private val movieRepository: MovieRepository){
    fun getMovies(): Flow<List<Movie>> {
        return movieRepository.getMovieList(1)
    }

}