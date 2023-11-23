package com.camachoyury.kmovie


import com.camachoyury.kmovie.data.network.NetworkClient
import com.camachoyury.kmovie.data.repository.MovieRepository
import com.camachoyury.kmovie.domain.MoviesUseCase
import com.camachoyury.kmovie.view.HomeViewModel

object Injector  {
    private val networkClient: NetworkClient by lazy { return@lazy NetworkClient() }
    private val movieRepository:MovieRepository by lazy { return@lazy MovieRepository(networkClient) }
    private val moviesUseCase: MoviesUseCase by lazy { return@lazy MoviesUseCase(movieRepository) }
    val homeViewModel: HomeViewModel by lazy { return@lazy HomeViewModel(moviesUseCase) }
}