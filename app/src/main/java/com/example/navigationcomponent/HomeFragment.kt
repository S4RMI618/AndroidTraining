package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navigationcomponent.databinding.FragmentHomeBinding
import com.example.recyclerviewMovieHome.Movie
import com.example.recyclerviewMovieHome.Movies
import com.example.recyclerviewMovieHome.adapter.MovieAdapter
import com.example.recyclerviewMovieHome.services.ApiInterface
import com.example.recyclerviewMovieHome.services.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private fun getMovieData(callback: (List<Movie>) ->Unit){
        val apiService = ApiService.getIntance().create(ApiInterface::class.java)
        apiService.getMovies().enqueue(object : Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                return callback(response.body()!!.results)
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root = binding.root
        getMovieData {
            initRecyclerView(it)
        }



        return root
    }

    private fun initRecyclerView(movieList : List<Movie>) {
        val recyclerView = binding.recyclerMovie
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = MovieAdapter(movieList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}