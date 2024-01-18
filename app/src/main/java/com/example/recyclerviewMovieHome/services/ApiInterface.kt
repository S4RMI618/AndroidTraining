package com.example.recyclerviewMovieHome.services


import com.example.recyclerviewMovieHome.Movies
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("top_rated?api_key=c5c47722a4adcc77f6e84f28a48b857a")
    fun getMovies(): Call<Movies>
}