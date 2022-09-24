package com.example.movieworld.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieworld.InfoActivity
import com.example.movieworld.R
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
            itemView.progress_bar.progress = (tv.vote!! * 10).toInt()
            itemView.text_view_progress.text = " ${(tv.vote!! * 10).toInt()}%"

            itemView.setOnClickListener {
                val intent : Intent = Intent(itemView.context , InfoActivity::class.java)
                intent.putExtra("title" , tv.title)
                intent.putExtra("release",tv.release)
                intent.putExtra("rating" , (tv.vote/2))
                intent.putExtra("overview",tv.overview)
                intent.putExtra("poster" , IMAGE_BASE+ tv.poster)
                ContextCompat.startActivity(itemView.context, intent, null)
            }


        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        return TvViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )

    }


    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        holder.bindMovie(tvs[position])
    }


    override fun getItemCount(): Int = tvs.size


}