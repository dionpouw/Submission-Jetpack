package com.aldion.jetpackprosubmission1.ui.movieshows

import androidx.lifecycle.ViewModel
import com.aldion.jetpackprosubmission1.ui.data.ShowEntity
import com.aldion.jetpackprosubmission1.utils.DataDummy

class MoviesShowsViewModel : ViewModel() {

    fun getMovie(): List<ShowEntity> = DataDummy.generateDummyFilms()

    fun getTvShows(): List<ShowEntity> = DataDummy.generateDummyTvShows()

}