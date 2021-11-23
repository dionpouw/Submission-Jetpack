package com.aldion.moviecatalog.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.aldion.moviecatalog.R
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.databinding.ActivityDetailBinding
import com.aldion.moviecatalog.viewmodel.ViewModelFactory
import com.aldion.moviecatalog.vo.Status
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: DetailShowViewModel
    private var menu: Menu? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val movieShow = intent.getParcelableExtra<ShowEntity>(EXTRA_SHOWS)
        val type = intent.getStringExtra(EXTRA_TYPE)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailShowViewModel::class.java]

        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.progressBar.visibility = View.VISIBLE

        if (movieShow != null && type == "Movie") {
            viewModel.setSelectedShow(movieShow.id)
            viewModel.getMovieDetail().observe(this, { movies ->
                if (movies != null) {
                    when (movies.status) {
                        Status.LOADING ->
                            binding.progressBar.visibility = View.VISIBLE

                        Status.SUCCESS -> {
                            binding.progressBar.visibility = View.GONE
                            binding.apply {
                                Glide.with(this@DetailActivity)
                                    .load("https://image.tmdb.org/t/p/w500/${movies.data?.posterPath}")
                                    .thumbnail(0.9f)
                                    .into(imgPoster)
                                tvTitle.text = movies.data?.title
                                tvYear.text = movies.data?.releaseDate
                                tvUserReviewNumber.text = movies.data?.voteAverage.toString()
                                tvDescriptionContent.text = movies.data?.overview
                            }
                        }
                        Status.ERROR -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(this, "There's an error", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            })
        } else if (movieShow != null && type == "Tv") {
            viewModel.setSelectedShow(movieShow.id)
            viewModel.getShowDetail().observe(this, { show ->
                if (show != null) {
                    when (show.status) {
                        Status.LOADING ->
                            binding.progressBar.visibility = View.VISIBLE

                        Status.SUCCESS -> {
                            binding.progressBar.visibility = View.GONE
                            binding.apply {
                                Glide.with(this@DetailActivity)
                                    .load("https://image.tmdb.org/t/p/w500/${show.data?.posterPath}")
                                    .thumbnail(0.9f)
                                    .into(imgPoster)
                                tvTitle.text = show.data?.title
                                tvYear.text = show.data?.releaseDate
                                tvUserReviewNumber.text = show.data?.voteAverage.toString()
                                tvDescriptionContent.text = show.data?.overview
                            }
                        }
                        Status.ERROR -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(this, "There's an error", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            })
            supportActionBar?.elevation = 0f
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        val detail = intent.getParcelableExtra<ShowEntity>(EXTRA_SHOWS) as ShowEntity
        setBookmarkState(detail.bookmarked)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_bookmark -> {
                val detailBookmarked =
                    intent.getParcelableExtra<ShowEntity>(EXTRA_SHOWS) as ShowEntity
                val newState = !detailBookmarked.bookmarked
                viewModel.setFavorite(detailBookmarked, newState)
                message(newState)
                setBookmarkState(newState)
            }
        }
    }

    private fun setBookmarkState(newState: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_bookmark)
        if (newState) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_white)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_border)
        }
    }

    private fun message(newState: Boolean) {
        if (newState) {
            Toast.makeText(this, "Favourited", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "UnFavourited", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        const val EXTRA_SHOWS = "EXTRA_SHOWS"
        const val EXTRA_TYPE = "EXTRA_TYPE"
    }
}
