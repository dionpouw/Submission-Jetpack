package com.aldion.movieshowsapp.ui.movieshows

import ShowEntity
import androidx.lifecycle.ViewModel
import com.aldion.jetpackprosubmission1.utils.DataDummy

class MoviesShowsViewModel : ViewModel() {

    fun getMovie(): List<ShowEntity> = DataDummy.generateDummyFilms()

    fun getTvShows(): List<ShowEntity> = DataDummy.generateDummyTvShows()

}