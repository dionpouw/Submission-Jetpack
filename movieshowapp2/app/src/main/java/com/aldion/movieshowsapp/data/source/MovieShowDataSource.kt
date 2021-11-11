package com.aldion.movieshowsapp.data.source

import com.aldion.movieshowsapp.data.source.local.entity.ShowEntity

interface MovieShowDataSource {
    fun getAllMovies():List<ShowEntity>
    fun getAllTvShows():List<ShowEntity>
    fun getDetailMovies(id:String):ShowEntity
    fun getDetailShow(id:String):ShowEntity
}