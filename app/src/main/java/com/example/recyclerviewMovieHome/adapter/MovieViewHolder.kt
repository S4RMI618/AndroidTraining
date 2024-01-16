package com.example.recyclerviewMovieHome.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationcomponent.databinding.ItemMovieBinding
import com.example.recyclerviewMovieHome.Movie
import com.squareup.picasso.Picasso

class MovieViewHolder(view:View) : RecyclerView.ViewHolder(view) {

    val binding = ItemMovieBinding.bind(view)

    fun render(movie : Movie) {
        binding.tvMovie.text = movie.movieName
        binding.tvMovieRate.text = movie.rate.toString()
        Picasso.get().load(movie.imgMovie).into(binding.ivMovie)
    }
}