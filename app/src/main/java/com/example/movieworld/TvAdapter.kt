package com.example.movieworld

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieworld.models.Movie
import com.example.movieworld.models.Tv
import kotlinx.android.synthetic.main.movie_item.view.*

class TvAdapter(
    private val tvs: List<Tv>
) : RecyclerView.Adapter<TvAdapter.TvViewHolder>() {

    class TvViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(tv: Tv) {

            itemView.movie_title.text = tv.title
            itemView.movie_release_date.text = tv.release
            Glide.with(itemView).load(IMAGE_BASE + tv.poster).into(itemView.movie_poster)
//                    itemView.movie_overview.text = movie.overview
            itemView.progress_bar.progress = (tv.vote!! * 10).toInt()
            itemView.text_view_progress.text = " ${(tv.vote!! * 10).toInt()}%"


        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        return TvAdapter.TvViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )

    }


    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        holder.bindMovie(tvs[position])
    }


    override fun getItemCount(): Int = tvs.size


}