package com.aldion.moviecatalog.data.source.remote

import android.os.Handler
import android.os.Looper
import com.aldion.moviecatalog.data.source.remote.response.MovieResponse
import com.aldion.moviecatalog.data.source.remote.response.TvResponse
import com.aldion.moviecatalog.utils.EspressoIdlingResource

import com.aldion.moviecatalog.utils.JsonHelper


class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    fun getAllMovies(callback: LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllMovieReceived(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getAllShows(callback: LoadShowsCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllShowreceived(jsonHelper.loadTvShows())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource(helper).apply { instance = this }
        }
    }

    interface LoadMoviesCallback {
        fun onAllMovieReceived(movieResponse: List<MovieResponse>)
    }

    interface LoadShowsCallback {
        fun onAllShowreceived(showResponse: List<TvResponse>)
    }

}