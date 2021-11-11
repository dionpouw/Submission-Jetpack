package com.aldion.movieshowsapp.ui.detail

import ShowEntity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.aldion.movieshowsapp.databinding.ActivityDetailShowBinding
import com.bumptech.glide.Glide


class DetailShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailShowBinding
    private val viewModel by viewModels<DetailShowViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDetailShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val movieShow = intent.getParcelableExtra<ShowEntity>(EXTRA_SHOWS)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        if (movieShow != null) {
            val moviesShows = viewModel.setMovieShows(movieShow.id,movieShow.category)
            binding.apply {
                Glide.with(this@DetailShowActivity).load(moviesShows.imagePath).thumbnail(0.9f)
                    .into(imgPoster)
                tvTitle.text = moviesShows.title
                tvGenre.text = moviesShows.genre
                tvYear.text = moviesShows.year
                tvUserReviewNumber.text = moviesShows.userRating
                tvListActor.text = moviesShows.actor
                tvDescriptionContent.text = moviesShows.description
            }
        }
        supportActionBar?.elevation = 0f
    }

    companion object {
        const val EXTRA_SHOWS = "EXTRA_SHOWS"
    }
}