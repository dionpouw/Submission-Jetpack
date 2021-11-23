package com.aldion.moviecatalog.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aldion.moviecatalog.data.source.ShowsRepository
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity

class DetailShowViewModel(private val mShowsRepository: ShowsRepository) : ViewModel() {
    private var id: Int = 0

    fun setSelectedShow(id: Int) {
        this.id = id
    }

    fun getMovieDetail(): LiveData<ShowEntity> = mShowsRepository.getMovieDetail(id)
    fun getShowDetail(): LiveData<ShowEntity> = mShowsRepository.getShowDetail(id)
}