package com.example.movieworld

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieworld.models.Movie
import com.example.movieworld.models.MovieResponse
import com.example.movieworld.models.Tv
import com.example.movieworld.models.TvResponse
import com.example.movieworld.services.MovieApiInterface
import com.example.movieworld.services.MovieApiService
import com.example.movieworld.services.TvApiInterface
import kotlinx.android.synthetic.main.fragment_movie_screen.*
import kotlinx.android.synthetic.main.fragment_movie_screen.view.*
import kotlinx.android.synthetic.main.fragment_tv_screen.*
import kotlinx.android.synthetic.main.fragment_tv_screen.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TvScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.rv_tv_list.layoutManager= LinearLayoutManager( context , LinearLayoutManager.VERTICAL ,false )
        view.rv_tv_list.setHasFixedSize(true)
        getMovieData { tvs :List<Tv> -> rv_tv_list.adapter =TvAdapter(tvs) }

    }
    private fun getMovieData(callback: (List<Tv>) -> Unit){
        val apiService = MovieApiService.getInstance().create(TvApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<TvResponse> {
            override fun onResponse(call: Call<TvResponse>, response: Response<TvResponse>) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<TvResponse>, t: Throwable) {
            }

        })
    }

}