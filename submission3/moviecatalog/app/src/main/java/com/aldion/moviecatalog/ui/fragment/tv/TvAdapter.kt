package com.aldion.moviecatalog.ui.fragment.tv

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aldion.moviecatalog.R
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.databinding.ItemShowBinding
import com.aldion.moviecatalog.ui.detail.DetailActivity
import com.bumptech.glide.Glide

class TvAdapter : RecyclerView.Adapter<TvAdapter.ShowViewHolder>() {
    private var listTvShows = ArrayList<ShowEntity>()

    fun setShow(Shows: List<ShowEntity>) {
        this.listTvShows.clear()
        this.listTvShows.addAll(Shows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val itemsShowBinding =
            ItemShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShowViewHolder(itemsShowBinding)
    }

    class ShowViewHolder(private val binding: ItemShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(shows: ShowEntity) {
            with(binding) {
                tvNameShow.text = shows.title
                tvItemReleaseDate.text = shows.releaseDate
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_SHOWS, shows)
                    intent.putExtra(DetailActivity.EXTRA_TYPE,"Tv")
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500${shows.posterPath}")
                    .override(66, 100).error(R.drawable.poster_alita).into(imageView)
            }
        }
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        val movieShow = listTvShows[position]
        holder.bind(movieShow)
    }

    override fun getItemCount(): Int = listTvShows.size
}


