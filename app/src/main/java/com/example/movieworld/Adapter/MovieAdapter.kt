package com.example.movieworld.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieworld.InfoActivity
import com.example.movieworld.LoginActivity
import com.example.movieworld.R
import com.example.movieworld.models.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter (
    private val movies : List<Movie>
        ):RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){


            class MovieViewHolder(view:View): RecyclerView.ViewHolder(view){
                private val IMAGE_BASE ="https://image.tmdb.org/t/p/w500/"
                fun bindMovie(movie : Movie){

                    itemView.movie_title.text=movie.title
                    itemView.movie_release_date.text=movie.release
                    Glide.with(itemView).load(IMAGE_BASE+ movie.poster).into(itemView.movie_poster)
                    itemView.progress_bar.progress = (movie.vote!!*10).toInt()
                    itemView.text_view_progress.text =" ${(movie.vote!!*10).toInt()}%"
                    itemView.setOnClickListener {
                        val intent : Intent = Intent(itemView.context , InfoActivity::class.java)
                        intent.putExtra("title" , movie.title)
                        intent.putExtra("release",movie.release)
                        intent.putExtra("rating" , (movie.vote/2))
                        intent.putExtra("overview",movie.overview)
                        intent.putExtra("poster" , IMAGE_BASE+ movie.poster)
                        startActivity(itemView.context, intent , null)
                    }
                }

            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_item , parent,false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies[position])


    }

    override fun getItemCount(): Int =movies.size
}