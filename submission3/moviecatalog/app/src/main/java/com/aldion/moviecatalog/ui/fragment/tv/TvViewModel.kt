package com.aldion.moviecatalog.ui.fragment.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.aldion.moviecatalog.data.source.ShowsRepository
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.vo.Resource

class TvViewModel(private val mShowsRepository: ShowsRepository) : ViewModel() {
    fun getTvShows(): LiveData<Resource<List<ShowEntity>>> = mShowsRepository.getAllShows()
}