package com.aldion.moviecatalog.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aldion.moviecatalog.data.source.ShowsRepository
import com.aldion.moviecatalog.data.source.local.entity.DetailEntity
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.vo.Resource

class DetailShowViewModel(private val mShowsRepository: ShowsRepository) : ViewModel() {
    private var movieShowId:Int =0

    fun setSelectedShow(movieShotId: Int) {
        this.movieShowId = movieShotId
    }

    fun getMovieDetail(): LiveData<Resource<DetailEntity>> = mShowsRepository.getMovieDetail(movieShowId)
    fun getShowDetail(): LiveData<Resource<DetailEntity>> = mShowsRepository.getShowDetail(movieShowId)

    fun setFavorite(movieShow: ShowEntity,newState:Boolean) = mShowsRepository.setMovieShowBookmark(movieShow,newState)
}