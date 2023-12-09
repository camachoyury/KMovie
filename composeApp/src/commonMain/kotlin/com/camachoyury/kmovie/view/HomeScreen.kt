package com.camachoyury.kmovie.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.camachoyury.kmovie.android.composables.ProgressBar

@ExperimentalFoundationApi
@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {

    val items = homeViewModel.movieList.collectAsState()
    when (items.value) {
        is ItemListState.Success -> {
            LazyVerticalGrid(columns = GridCells.Fixed(2),
                content = {
                    val i = (items.value as ItemListState.Success).items
                    items(i.size) { index ->
                        Item(modifier = Modifier, i[index], selectItem = {

                        })
                    }
                }
            )
        }
        is ItemListState.Error -> {
            Text(text = "ERROR")
        }
        is ItemListState.LoadingState -> {
            ProgressBar()
        }
    }
}