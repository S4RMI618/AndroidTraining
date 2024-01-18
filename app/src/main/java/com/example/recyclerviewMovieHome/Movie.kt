package com.example.recyclerviewMovieHome

import com.google.gson.annotations.SerializedName

data class Movies (
    val page : Int?,
    val results: List<Movie>
)

data class Movie(
    val id: Long,
    val original_title:String?,
    val overview: String?,
    val poster_path:String?,
    val vote_average: Double
)
