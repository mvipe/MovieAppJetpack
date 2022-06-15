package com.learn.movieappjetpack.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.learn.movieappjetpack.MovieRow
import com.learn.movieappjetpack.models.Movie
import com.learn.movieappjetpack.models.getMovies
import com.learn.movieappjetpack.navigation.MovieScreen
import com.learn.movieappjetpack.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Magenta, elevation = 5.dp) {
            Text(text="Movies")
        }
    }) {
        MainContent(navController=navController)
    }

}

@Composable
fun MainContent(navController: NavController,movieList:List<Movie> = getMovies()){

    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(items =movieList){
                    item-> MovieRow(movie = item){
                    movie-> navController.navigate(route = MovieScreen.DetailsScreen.name+"/${movie}")
            }
            }
        }
    }
}
