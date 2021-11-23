package com.aldion.moviecatalog.di

import android.content.Context
import com.aldion.moviecatalog.data.source.ShowsRepository
import com.aldion.moviecatalog.utils.AppExecutors
import com.aldion.moviecatalog.data.source.local.LocalDataSource
import com.aldion.moviecatalog.data.source.local.room.MovieShowDatabase
import com.aldion.moviecatalog.data.source.remote.RemoteDataSource
import com.aldion.moviecatalog.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): ShowsRepository {
        val database = MovieShowDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.movieShowDao())
        val appExecutors = AppExecutors()
        return ShowsRepository.getInstance(remoteDataSource,localDataSource, appExecutors)
    }
}