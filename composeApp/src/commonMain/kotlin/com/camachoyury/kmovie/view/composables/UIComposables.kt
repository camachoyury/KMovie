package com.camachoyury.kmovie.android.composables


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch



@Composable
fun KToolBar(
    state: MutableState<Boolean>,
    titleToolbar: @Composable () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    AnimatedVisibility(
        visible = state.value,
        enter = slideInVertically(initialOffsetY = { -it }),
        exit = slideOutVertically(targetOffsetY = { -it }),
        content = {
            TopAppBar(
                modifier = Modifier.background(Color.Black),
                title = titleToolbar ,
                elevation = 12.dp,
                navigationIcon = {
                    IconButton(
                        onClick = {
                        }
                    ) {
                        Icon(
                            Icons.Filled.Menu,
                            contentDescription = "description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                    }) {
                        Icon(Icons.Filled.ShoppingCart, contentDescription = "", tint = Color.White)
                    }
                },

            )
        }
    )
}

@Composable
fun ProgressBar() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(80.dp),
            color = Color.Blue,
            strokeWidth = 10.dp
        )
    }
}

@Composable
fun LikedIndicator() {
    val selected = remember { mutableStateOf(false) }
    IconButton(
        onClick = { selected.value = !selected.value },
    ) {
        val icon = if (selected.value) Icons.Default.Favorite else Icons.Default.FavoriteBorder
        val color = animateColorAsState(
            targetValue = if (selected.value) Color.Red else Color.Black,
            animationSpec = tween(durationMillis = 2500)
        )
        Icon(imageVector = icon, contentDescription = null, tint = color.value)
    }
}

@Composable
fun BottomView() {
    Row(
        modifier = Modifier
            .fillMaxSize().padding(start = 10.dp, end = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = {

            }
        ) {
            Icon(
                Icons.Filled.Home,
                contentDescription = "description"
            )
        }
        IconButton(
            onClick = {}
        ) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "description"
            )
        }
        IconButton(
            onClick = {}
        ) {
            Icon(
                Icons.Filled.ShoppingCart,
                contentDescription = "description"
            )
        }
        IconButton(
            onClick = {}
        ) {
            Icon(
                Icons.Filled.Person,
                contentDescription = "description"
            )
        }
    }
}
