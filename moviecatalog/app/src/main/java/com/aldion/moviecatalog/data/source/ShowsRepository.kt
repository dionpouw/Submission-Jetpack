package com.aldion.moviecatalog.data.source

import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.data.source.remote.RemoteDataSource

class ShowsRepository private constructor(private val remoteDataSource: RemoteDataSource):ShowsDataSource{
    override fun getAllMovies(): List<ShowEntity> {

        val movieResponse = remoteDataSource.getAllMovies()
        val movieList = ArrayList
    }

    override fun getAllShows(): List<ShowEntity> {
        TODO("Not yet implemented")
    }

    override fun getMovieDetail(movieId: Int): ShowEntity {
        TODO("Not yet implemented")
    }

    override fun getShowDetail(tvId: Int): ShowEntity {
        TODO("Not yet implemented")
    }

    companion object{
        @Volatile
        private var instance: ShowsRepository? = null

        fun getInstance(remoteData: RemoteDataSource):ShowsRepository= instance?: synchronized(this){
            instance?: ShowsRepository(remoteData).apply { instance = this }
        }
    }

}