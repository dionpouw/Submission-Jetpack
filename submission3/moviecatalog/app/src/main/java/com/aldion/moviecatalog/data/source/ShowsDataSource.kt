package com.aldion.moviecatalog.data.source

import androidx.lifecycle.LiveData
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity

interface ShowsDataSource {
    fun getAllMovies(): LiveData<List<ShowEntity>>
    fun getAllShows(): LiveData<List<ShowEntity>>
    fun getMovieDetail(movieId: Int): LiveData<ShowEntity>
    fun getShowDetail(tvId: Int): LiveData<ShowEntity>
}