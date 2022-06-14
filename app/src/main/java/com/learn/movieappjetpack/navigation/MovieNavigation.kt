package com.learn.movieappjetpack.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.learn.movieappjetpack.screens.home.DetailsScreen
import com.learn.movieappjetpack.screens.home.HomeScreen

@Composable
fun MovieNavigation(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreen.HomeScreen.name ){
        composable(MovieScreen.HomeScreen.name){
            //here we pass where this should lead us to
            HomeScreen(navController = navController)
        }

        composable(MovieScreen.DetailsScreen.name){
            //here we pass where this should lead us to
            DetailsScreen(navController = navController)
        }

    }
}