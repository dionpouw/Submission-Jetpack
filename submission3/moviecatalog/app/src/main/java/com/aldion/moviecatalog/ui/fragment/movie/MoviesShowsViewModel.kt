package com.aldion.moviecatalog.ui.fragment.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aldion.moviecatalog.data.source.ShowsRepository
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity

class MoviesShowsViewModel(private val mShowsRepository: ShowsRepository) : ViewModel() {
    fun getMovie(): LiveData<List<ShowEntity>> = mShowsRepository.getAllMovies()
}