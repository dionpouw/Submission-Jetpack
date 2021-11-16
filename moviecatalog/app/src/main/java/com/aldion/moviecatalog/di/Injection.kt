package com.aldion.moviecatalog.di

import android.content.Context
import com.aldion.moviecatalog.data.source.ShowsRepository
import com.aldion.moviecatalog.data.source.remote.RemoteDataSource
import com.aldion.moviecatalog.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): ShowsRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        return ShowsRepository.getInstance(remoteDataSource)
    }
}