package com.example.movieworld.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieworld.Adapter.MovieAdapter
import com.example.movieworld.R
import com.example.movieworld.models.Movie
import com.example.movieworld.models.MovieResponse
import com.example.movieworld.services.MovieApiInterface
import com.example.movieworld.services.MovieApiService
import kotlinx.android.synthetic.main.fragment_movie_screen.*
import kotlinx.android.synthetic.main.fragment_movie_screen.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieScreen : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_movie_screen, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.rv_movies_list.layoutManager= LinearLayoutManager( context , LinearLayoutManager.VERTICAL ,false )
        view.rv_movies_list.setHasFixedSize(true)
        getMovieData { movies :List<Movie> -> rv_movies_list.adapter = MovieAdapter(movies) }

    }
    private fun getMovieData(callback: (List<Movie>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }

        })
    }
}