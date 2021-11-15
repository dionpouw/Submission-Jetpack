package com.aldion.moviecatalog.ui.fragment

import androidx.lifecycle.ViewModel
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.utils.DataDummy

class MoviesShowsViewModel : ViewModel() {

    fun getMovie(): List<ShowEntity> = DataDummy.generateDummyFilms()

    fun getTvShows(): List<ShowEntity> = DataDummy.generateDummyTvShows()

}