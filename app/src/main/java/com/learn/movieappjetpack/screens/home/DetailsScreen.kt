package com.learn.movieappjetpack.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.learn.movieappjetpack.models.Movie
import com.learn.movieappjetpack.models.getMovies
import com.learn.movieappjetpack.widgets.MovieRow

@Composable
fun DetailsScreen(navController: NavController, movieId: String?){
    //fetch the movie with the movie id
    val newMovieList= getMovies().filter { movie ->  movie.id==movieId}


    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Magenta, elevation = 5.dp) {
            Row() {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow Back",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                })
                Spacer(modifier = Modifier.width(100.dp))
                Text(text = "Movie Details")
            }
        }
    }) {
           Surface(modifier = Modifier
               .fillMaxWidth()
               .fillMaxHeight()) {
               Column(
                   horizontalAlignment = Alignment.CenterHorizontally,
                   verticalArrangement = Arrangement.Top
               ) {
                   MovieRow(movie = newMovieList.first(), expandedd = true)
                   Divider()
                   
                   Text(text = "Movie Images")

                   HorizontalImageScrollable(newMovieList)
               }

           }}}

@Composable
private fun HorizontalImageScrollable(newMovieList: List<Movie>) {
    LazyRow {
        items(newMovieList[0].images) { image ->
            Card(modifier = Modifier
                .padding(12.dp)
                .size(240.dp), elevation = 5.dp) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(image)
                        .crossfade(true)
                        .build(),

                    contentDescription = "Poster Image",
                    contentScale = ContentScale.Crop,

                    )
            }
        }
    }
}
    
    
    
    


