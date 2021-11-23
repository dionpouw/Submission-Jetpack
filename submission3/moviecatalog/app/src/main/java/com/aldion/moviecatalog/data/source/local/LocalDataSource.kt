package com.aldion.moviecatalog.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.aldion.moviecatalog.data.source.local.entity.DetailEntity
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.data.source.local.room.MovieShowDao

class LocalDataSource private constructor(private val mMovieShowDao: MovieShowDao) {

    fun getAllMovies(): DataSource.Factory<Int, ShowEntity> = mMovieShowDao.getMovies()

    fun getAllShows(): DataSource.Factory<Int, ShowEntity> = mMovieShowDao.getShows()

    fun getBookmarkedMovieShow(): DataSource.Factory<Int, ShowEntity> =
        mMovieShowDao.getBookmarkedMovieShow()

    fun insertMoviesShows(movieShows: List<ShowEntity>) =
        mMovieShowDao.insertMoviesShows(movieShows)

    fun getMovieShowDetail(movieShowId: Int): LiveData<DetailEntity> =
        mMovieShowDao.getMovieShowDetail(movieShowId)

    fun insertMovieDetail(movie: DetailEntity) = mMovieShowDao.insertMovieDetail(movie)

    fun insertShowDetail(show: DetailEntity) = mMovieShowDao.insertShowDetail(show)

    fun setMovieBookmark(movieShow: ShowEntity, newState: Boolean) {
        movieShow.bookmarked = newState
        mMovieShowDao.updateMovieShow(movieShow)
    }

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieShowDao: MovieShowDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieShowDao)
    }
}