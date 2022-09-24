package com.example.movieworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.movieworld.Adapter.MovieAdapter
import com.example.movieworld.Adapter.TvAdapter
import com.example.movieworld.models.Movie
import com.example.movieworld.models.MovieResponse
import com.example.movieworld.models.Tv
import com.example.movieworld.models.TvResponse
import com.example.movieworld.services.MovieApiInterface
import com.example.movieworld.services.MovieApiService
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlinx.android.synthetic.main.fragment_movie_screen.*
import kotlinx.android.synthetic.main.fragment_movie_screen.view.*
import kotlinx.android.synthetic.main.movie_item.*
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InfoActivity : AppCompatActivity() {
    private lateinit var collapsing: CollapsingToolbarLayout
    private lateinit var toolbar: Toolbar
    private lateinit var release :TextView
    private lateinit var rating : RatingBar
    private lateinit var overView :TextView
    private lateinit var poster :ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        toolbar = findViewById(R.id.testToolBar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        collapsing = findViewById(R.id.collapsingToolbar)
        collapsing.title = intent.getStringExtra("title")
        release = findViewById(R.id.releaseDate)
        rating = findViewById(R.id.rating)
        overView = findViewById(R.id.overView)
        poster = findViewById(R.id.poster)
        release.text = intent.getStringExtra("release")
        overView.text  = intent.getStringExtra("overview")
        Glide.with(this).load(intent.getStringExtra("poster")).into(poster)
        rating.rating = intent.getDoubleExtra("rating" , 0.0).toFloat()
    }

    @Override
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}