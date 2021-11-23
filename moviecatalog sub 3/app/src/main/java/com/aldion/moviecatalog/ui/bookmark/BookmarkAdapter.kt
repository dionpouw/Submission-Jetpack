package com.aldion.moviecatalog.ui.bookmark

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aldion.moviecatalog.R
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.databinding.ItemShowBinding
import com.aldion.moviecatalog.ui.detail.DetailActivity
import com.bumptech.glide.Glide


class BookmarkAdapter : PagedListAdapter<ShowEntity, BookmarkAdapter.BookmarkViewHolder>(
    DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        val itemsShowBinding =
            ItemShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookmarkViewHolder(itemsShowBinding)
    }

    class BookmarkViewHolder(private val binding: ItemShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: ShowEntity) {
            with(binding) {
                tvNameShow.text = movies.title
                tvReleaseDate.text = movies.releaseDate
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_SHOWS, movies)
                    intent.putExtra(DetailActivity.EXTRA_TYPE, "Movie")
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500${movies.posterPath}")
                    .override(66, 100).error(R.drawable.launcher).into(imageView)
            }
        }
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        val bookmarked = getItem(position)
        if (bookmarked != null) {
            holder.bind(bookmarked)
        }
    }

    fun getBookmarkAt(position: Int): ShowEntity? = getItem(position)

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ShowEntity>() {
            override fun areItemsTheSame(oldItem: ShowEntity, newItem: ShowEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ShowEntity, newItem: ShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}
