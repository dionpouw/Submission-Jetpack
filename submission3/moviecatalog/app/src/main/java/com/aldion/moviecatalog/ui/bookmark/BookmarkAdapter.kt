package com.aldion.moviecatalog.ui.bookmark

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


class BookmarkAdapter : RecyclerView.Adapter<BookmarkAdapter.BookmarkViewHolder>() {
    private var listBookmark = ArrayList<ShowEntity>()

    fun setBookmark(listBookmark: List<ShowEntity>) {
        this.listBookmark.clear()
        this.listBookmark.addAll(listBookmark)
    }

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
                tvItemReleaseDate.text = movies.releaseDate
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_SHOWS, movies)
                    intent.putExtra(DetailActivity.EXTRA_TYPE,"Movie")
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500${movies.posterPath}")
                    .override(66, 100).error(R.drawable.poster_alita).into(imageView)
            }
        }
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        val bookmarked = listBookmark[position]
        holder.bind(bookmarked)
    }

    fun getBookmarkAt(position: Int):ShowEntity {
        return ShowEntity(listBookmark[position].id,listBookmark[position].title,listBookmark[position].category,listBookmark[position].releaseDate,listBookmark[position].voteAverage,listBookmark[position].overview,listBookmark[position].bookmarked,listBookmark[position].posterPath)
    }

    override fun getItemCount(): Int = listBookmark.size
}
