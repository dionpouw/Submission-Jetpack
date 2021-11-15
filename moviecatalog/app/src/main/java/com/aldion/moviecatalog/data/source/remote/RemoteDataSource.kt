package com.aldion.moviecatalog.data.source.remote

import com.aldion.moviecatalog.data.source.remote.response.MovieResponse
import com.aldion.moviecatalog.data.source.remote.response.TvResponse
import com.aldion.moviecatalog.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    fun getAllMovies(): List<MovieResponse> = jsonHelper.loadMovies()
    fun getAllShows(): List<TvResponse> = jsonHelper.loadTvShows()

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource(helper).apply { instance = this }
        }
    }
}