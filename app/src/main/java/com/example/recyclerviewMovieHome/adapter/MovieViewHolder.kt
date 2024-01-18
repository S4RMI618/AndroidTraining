package com.example.recyclerviewMovieHome.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationcomponent.databinding.ItemMovieBinding
import com.example.recyclerviewMovieHome.Movie
import com.example.recyclerviewMovieHome.services.ApiService.Companion.IMAGE_URL
import com.squareup.picasso.Picasso

class MovieViewHolder(view:View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemMovieBinding.bind(view)

    fun render(movie : Movie) {
        binding.tvMovie.text = movie.original_title
        binding.tvMovieRate.text = movie.vote_average.toString()
        Picasso.get().load(IMAGE_URL + movie.poster_path).into(binding.ivMovie)
    }
}