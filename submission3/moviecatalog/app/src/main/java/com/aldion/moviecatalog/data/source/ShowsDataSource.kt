package com.aldion.moviecatalog.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.aldion.moviecatalog.data.source.local.entity.DetailEntity
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.vo.Resource

interface ShowsDataSource {
    fun getAllMovies(): LiveData<Resource<List<ShowEntity>>>
    fun getAllShows(): LiveData<Resource<List<ShowEntity>>>
    fun getMovieDetail(movieId: Int): LiveData<Resource<DetailEntity>>
    fun getShowDetail(showId: Int): LiveData<Resource<DetailEntity>>
    fun getBookmarkedMoviesShows(): LiveData<List<ShowEntity>>
    fun setMovieShowBookmark(movieShow: ShowEntity, state: Boolean)
}