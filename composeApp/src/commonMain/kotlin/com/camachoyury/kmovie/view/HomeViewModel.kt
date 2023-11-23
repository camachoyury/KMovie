package com.camachoyury.kmovie.view

import com.camachoyury.kmovie.domain.Movie
import com.camachoyury.kmovie.domain.MoviesUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val moviesUseCase: MoviesUseCase) {

    private val _movieList: MutableStateFlow<ItemListState> =
        MutableStateFlow(ItemListState.LoadingState)
    val movieList: StateFlow<ItemListState> = _movieList.asStateFlow()
    fun loadItems( scope: CoroutineScope){
        scope.launch {
            _movieList.value = ItemListState.LoadingState
            moviesUseCase.getMovies().collect {
                _movieList.value = ItemListState.Success(it)
            }
        }
    }
}

sealed class ItemListState {
    object LoadingState : ItemListState()
    class Success(val items: List<Movie>) : ItemListState()
    data class Error(val exception: Throwable) : ItemListState()
}
