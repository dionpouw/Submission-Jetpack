package com.aldion.moviecatalog.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.databinding.ActivityDetailBinding
import com.aldion.moviecatalog.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailShowViewModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val movieShow = intent.getParcelableExtra<ShowEntity>(EXTRA_SHOWS)
        val type = intent.getStringExtra(EXTRA_TYPE)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailShowViewModel::class.java]

        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.progressBar.visibility = View.VISIBLE

        if (movieShow != null && type == "Movies") {
            viewModel.setSelectedShow(movieShow.id)
            viewModel.getMovieDetail().observe(this, { movies ->
                binding.progressBar.visibility = View.GONE
                binding.content.visibility = View.VISIBLE
                binding.apply {
                    Glide.with(this@DetailActivity)
                        .load("https://image.tmdb.org/t/p/w500/${movies.posterPath}")
                        .thumbnail(0.9f)
                        .into(imgPoster)
                    tvTitle.text = movies.title
                    tvYear.text = movies.releaseDate
                    tvUserReviewNumber.text = movies.voteAverage.toString()
                    tvDescriptionContent.text = movies.overview
                }
            })
        } else if (movieShow != null && type == "Tv") {
            viewModel.setSelectedShow(movieShow.id)
            viewModel.getShowDetail().observe(this, { shows ->
                binding.progressBar.visibility = View.GONE
                binding.content.visibility = View.VISIBLE
                binding.apply {
                    Glide.with(this@DetailActivity)
                        .load("https://image.tmdb.org/t/p/w500/${shows.posterPath}").thumbnail(0.9f)
                        .into(imgPoster)
                    tvTitle.text = shows.title
                    tvYear.text = shows.releaseDate
                    tvUserReviewNumber.text = shows.voteAverage.toString()
                    tvDescriptionContent.text = shows.overview
                }
            })
            supportActionBar?.elevation = 0f
        }
    }

    companion object {
        const val EXTRA_SHOWS = "EXTRA_SHOWS"
        const val EXTRA_TYPE = "EXTRA_TYPE"
    }
}
