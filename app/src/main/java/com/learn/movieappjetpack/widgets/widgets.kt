package com.learn.movieappjetpack.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.learn.movieappjetpack.models.Movie
import com.learn.movieappjetpack.models.getMovies

@Preview
@Composable
fun MovieRow(movie: Movie= getMovies()[0], onItemClick:(String)->Unit={}){

    var expanded by remember {
        mutableStateOf(false)
    }

    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .clickable { onItemClick(movie.id) }
      ,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Surface(
                modifier = Modifier
                    .padding(13.dp)
                    .size(100.dp),
                shape = RectangleShape, elevation = 4.dp
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(movie.images[0])
                        .crossfade(true)
                        .build(),

                    contentDescription = "Poster Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(CircleShape)
                )
            }



//                Image(painter = rememberImagePainter(data = movie.images[0],
//                builder = {
//                    crossfade(true)
//                    transformations(CircleCropTransformation())
//                }), contentDescription = "Movie Posters"
//                        )
//


            Column() {
                Text(text = movie.title,color= Color.Black
                    , style = MaterialTheme.typography.h5)
                Text(text = "Director: ${movie.director}",color= Color.Black
                    , style = MaterialTheme.typography.h6)
                Text(text = "Release: ${movie.title}",color= Color.Black
                    , style = MaterialTheme.typography.h6)

                AnimatedVisibility(visible = expanded) {
                    Column() {
                       Text(buildAnnotatedString {
                           withStyle(style = SpanStyle(
                               color = Color.DarkGray,
                               fontSize = 13.sp
                           )){
                               append("Plot: ")
                           }

                           withStyle(style = SpanStyle(
                               color = Color.DarkGray,
                               fontSize = 13.sp,
                               fontWeight = FontWeight.Bold
                           )){
                               append("${movie.plot}")
                           }
                       })
                    }
                }

                Icon(imageVector = if(expanded) Icons.Filled.KeyboardArrowDown
                    else Icons.Filled.KeyboardArrowUp, contentDescription = "Down Arrow"
                    , modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            expanded = !expanded
                        },
                    tint=Color.DarkGray)
            }
        }

    }
    

}
