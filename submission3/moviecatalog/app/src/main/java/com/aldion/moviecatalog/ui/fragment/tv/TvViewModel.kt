package com.aldion.moviecatalog.ui.fragment.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aldion.moviecatalog.data.source.ShowsRepository
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity

class TvViewModel(private val mTvRepository: ShowsRepository) : ViewModel() {
    fun getTvShows(): LiveData<List<ShowEntity>> = mTvRepository.getAllShows()
}