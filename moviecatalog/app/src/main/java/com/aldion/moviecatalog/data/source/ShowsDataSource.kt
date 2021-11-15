package com.aldion.moviecatalog.data.source

import com.aldion.moviecatalog.data.source.local.entity.ShowEntity

interface ShowsDataSource {
    fun getAllMovies():List<ShowEntity>
    fun getAllShows():List<ShowEntity>
    fun getMovieDetail(movieId:Int):ShowEntity
    fun getShowDetail(tvId:Int):ShowEntity
}