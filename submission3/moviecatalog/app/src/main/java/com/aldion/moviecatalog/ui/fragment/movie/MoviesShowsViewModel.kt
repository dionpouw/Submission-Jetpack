package com.aldion.moviecatalog.ui.fragment.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.aldion.moviecatalog.data.source.ShowsRepository
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.vo.Resource

class MoviesShowsViewModel(private val mShowsRepository: ShowsRepository) : ViewModel() {
    fun getMovie(): LiveData<Resource<List<ShowEntity>>> = mShowsRepository.getAllMovies()
}