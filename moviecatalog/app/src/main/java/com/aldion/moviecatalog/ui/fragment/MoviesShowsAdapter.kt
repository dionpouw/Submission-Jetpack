package com.aldion.moviecatalog.ui.fragment

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aldion.moviecatalog.data.ShowEntity
import com.aldion.moviecatalog.databinding.ItemShowBinding
import com.aldion.moviecatalog.ui.detail.DetailActivity
import com.bumptech.glide.Glide


class MoviesShowsAdapter : RecyclerView.Adapter<MoviesShowsAdapter.MovieShowViewHolder>() {
    private var listMovieShows = ArrayList<ShowEntity>()

    fun setMovieShow(movieShows: List<ShowEntity>) {
        this.listMovieShows.clear()
        this.listMovieShows.addAll(movieShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieShowViewHolder {
        val itemsShowBinding =
            ItemShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieShowViewHolder(itemsShowBinding)
    }

    class MovieShowViewHolder(private val binding: ItemShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(moviesShows: ShowEntity) {
            with(binding) {
                tvNameShow.text = moviesShows.title
                tvItemGenre.text = moviesShows.genre
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_SHOWS, moviesShows)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context).load(moviesShows.imagePath).into(imageView)
            }
        }
    }

    override fun onBindViewHolder(holder: MovieShowViewHolder, position: Int) {
        val movieShow = listMovieShows[position]
        holder.bind(movieShow)
    }

    override fun getItemCount(): Int = listMovieShows.size
}

