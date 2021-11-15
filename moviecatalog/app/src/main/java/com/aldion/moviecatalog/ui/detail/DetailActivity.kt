package com.aldion.moviecatalog.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val viewModel by viewModels<DetailShowViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val movieShow = intent.getParcelableExtra<ShowEntity>(EXTRA_SHOWS)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        if (movieShow != null) {
            val moviesShows = viewModel.setMovieShows(movieShow.id)
            binding.apply {
                Glide.with(this@DetailActivity).load("https://image.tmdb.org/t/p/w500/${moviesShows.posterPath}").thumbnail(0.9f)
                    .into(imgPoster)
                tvTitle.text = moviesShows.title
                tvYear.text = moviesShows.releaseDate
                tvUserReviewNumber.text = moviesShows.voteAverage.toString()
                tvDescriptionContent.text = moviesShows.overview
            }
        }
        supportActionBar?.elevation = 0f
    }

    companion object {
        const val EXTRA_SHOWS = "EXTRA_SHOWS"
    }
}