package com.aldion.moviecatalog.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.aldion.moviecatalog.data.source.local.entity.DetailEntity
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.vo.Resource

interface ShowsDataSource {
    fun getAllMovies(): LiveData<Resource<PagedList<ShowEntity>>>
    fun getAllShows(): LiveData<Resource<PagedList<ShowEntity>>>
    fun getMovieDetail(movieId: Int): LiveData<Resource<DetailEntity>>
    fun getShowDetail(showId: Int): LiveData<Resource<DetailEntity>>
    fun getBookmarkedMoviesShows(): LiveData<PagedList<ShowEntity>>
    fun setMovieShowBookmark(movieShow: ShowEntity, state: Boolean)
}