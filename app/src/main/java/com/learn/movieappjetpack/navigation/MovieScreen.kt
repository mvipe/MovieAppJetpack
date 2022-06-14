package com.learn.movieappjetpack.navigation

import java.lang.IllegalArgumentException

enum class MovieScreen {
    HomeScreen,
    DetailsScreen;

    companion object{
        fun fromRoute(route:String?):MovieScreen
        =when (route?.substringBefore("/")){
            HomeScreen.name -> HomeScreen
            DetailsScreen.name+"/{movie}" -> DetailsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route:${route} is not found")
        }


    }
}