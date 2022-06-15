package com.learn.movieappjetpack.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.learn.movieappjetpack.models.Movie
import com.learn.movieappjetpack.models.getMovies

@Preview
@Composable
fun MovieRow(movie: Movie= getMovies()[0], onItemClick:(String)->Unit={}){
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .clickable { onItemClick(movie.id) }
        .height(130.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Surface(modifier = Modifier
                .padding(13.dp)
                .size(100.dp),
                shape = RectangleShape, elevation = 4.dp) {
                Image(painter = rememberImagePainter(data = movie.images[0],
                builder = {
                    crossfade(true)
                    transformations(CircleCropTransformation())
                }), contentDescription = "Movie Posters"
                        )
                
                  }
            Column() {
                Text(text = movie.title,color= Color.Black
                    , style = MaterialTheme.typography.h5)
                Text(text = "Director: ${movie.director}",color= Color.Black
                    , style = MaterialTheme.typography.h6)
                Text(text = "Release: ${movie.title}",color= Color.Black
                    , style = MaterialTheme.typography.h6)
            }
        }

    }
}
