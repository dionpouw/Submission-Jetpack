package com.aldion.moviecatalog.ui.fragment.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aldion.moviecatalog.R
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.databinding.ItemShowBinding
import com.aldion.moviecatalog.ui.detail.DetailActivity
import com.bumptech.glide.Glide


class MoviesShowsAdapter : RecyclerView.Adapter<MoviesShowsAdapter.MovieShowViewHolder>() {
    private var listMovie = ArrayList<ShowEntity>()

    fun setMovie(movie: List<ShowEntity>) {
        this.listMovie.clear()
        this.listMovie.addAll(movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieShowViewHolder {
        val itemsShowBinding =
            ItemShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieShowViewHolder(itemsShowBinding)
    }

    class MovieShowViewHolder(private val binding: ItemShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: ShowEntity) {
            with(binding) {
                tvNameShow.text = movies.title
                tvItemReleaseDate.text = movies.releaseDate
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_SHOWS, movies)
                    intent.putExtra(DetailActivity.EXTRA_TYPE,"Movies")
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500${movies.posterPath}")
                    .override(66, 100).error(R.drawable.poster_alita).into(imageView)
            }
        }
    }

    override fun onBindViewHolder(holder: MovieShowViewHolder, position: Int) {
        val movieShow = listMovie[position]
        holder.bind(movieShow)
    }

    override fun getItemCount(): Int = listMovie.size
}

