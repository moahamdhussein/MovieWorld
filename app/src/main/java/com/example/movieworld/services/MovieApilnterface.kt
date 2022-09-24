package com.example.movieworld.services

import com.example.movieworld.models.MovieResponse
import com.example.movieworld.models.TvResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApiInterface{
    @GET("/3/movie/popular?api_key=d2197d7fdc567c348464975c16c3beb8")
            fun getMovieList(): Call<MovieResponse>

    @GET("/3/tv/popular?api_key=d2197d7fdc567c348464975c16c3beb8")
    fun getTvList(): Call<TvResponse>

}

