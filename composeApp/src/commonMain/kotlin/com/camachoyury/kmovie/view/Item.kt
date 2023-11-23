package com.camachoyury.kmovie.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.camachoyury.kmovie.domain.Movie
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.resources.painterResource


@Composable
fun Item(
    modifier: Modifier = Modifier,
    movie: Movie,
    selectItem: (Movie) -> Unit
) {
    Card(
        modifier = modifier
            .height(220.dp)
            .clickable {selectItem (movie) },
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Box(
                modifier = modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                KamelImage(
                    asyncPainterResource(movie.imageUrl),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(bottomStart = 2.dp, bottomEnd = 2.dp))
                )

            }

            Column(
                modifier = modifier.padding(10.dp)
            ){
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = modifier.height(4.dp))

                Text(text = movie.releaseDate, style = MaterialTheme.typography.caption)
            }
        }
    }

}