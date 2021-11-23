package com.aldion.moviecatalog.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.aldion.moviecatalog.data.source.local.entity.DetailEntity
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity

@Dao
interface MovieShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMoviesShows(movieShows: List<ShowEntity>)

    @Query("SELECT * FROM movieShowEntities where category = 'movie'")
    fun getMovies(): DataSource.Factory<Int,ShowEntity>
    @Query("SELECT * FROM movieShowEntities where category = 'tv'")
    fun getShows(): DataSource.Factory<Int,ShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieDetail(movie:DetailEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShowDetail(show:DetailEntity)

    @Transaction
    @Query("SELECT * FROM detailEntities WHERE detailId = :movieShowId")
    fun getMovieShowDetail(movieShowId: Int): LiveData<DetailEntity>

    @Query("SELECT * FROM movieShowEntities where bookmarked = 1")
    fun getBookmarkedMovieShow(): DataSource.Factory<Int,ShowEntity>

    @Update
    fun updateMovieShow(movieShow: ShowEntity)
}