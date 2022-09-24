package com.example.movieworld

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieworld.models.Movie
import com.example.movieworld.models.MovieResponse
import com.example.movieworld.services.MovieApiInterface
import com.example.movieworld.services.MovieApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieScreen : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rv_movies_list.layoutManager= LinearLayoutManager( context , LinearLayoutManager.VERTICAL ,false )
        rv_movies_list.setHasFixedSize(true)
        getMovieData { movies :List<Movie> -> rv_movies_list.adapter =MovieAdapter(movies) }
        println(getMovieData {  movies :List<Movie> -> rv_movies_list.adapter =MovieAdapter(movies) })
        return inflater.inflate(R.layout.fragment_movie_screen, container, false)
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