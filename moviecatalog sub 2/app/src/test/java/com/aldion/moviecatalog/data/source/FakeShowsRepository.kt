package com.aldion.moviecatalog.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.data.source.remote.RemoteDataSource
import com.aldion.moviecatalog.data.source.remote.response.MovieResponse
import com.aldion.moviecatalog.data.source.remote.response.TvResponse

class FakeShowsRepository(private val remoteDataSource: RemoteDataSource) :
    ShowsDataSource {

    override fun getAllMovies(): LiveData<List<ShowEntity>> {
        val movieResults = MutableLiveData<List<ShowEntity>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMovieReceived(movieResponse: List<MovieResponse>) {
                val movieList = ArrayList<ShowEntity>()
                for (response in movieResponse) {
                    val movie = ShowEntity(
                        response.id,
                        response.title,
                        response.releaseDate,
                        response.voteAverage,
                        response.overview,
                        response.posterPath
                    )
                    movieList.add(movie)
                }
                movieResults.postValue(movieList)
            }
        })
        return movieResults
    }

    override fun getAllShows(): LiveData<List<ShowEntity>> {
        val showsResult = MutableLiveData<List<ShowEntity>>()
        remoteDataSource.getAllShows(object : RemoteDataSource.LoadShowsCallback {
            override fun onAllShowreceived(showResponse: List<TvResponse>) {
                val showList = ArrayList<ShowEntity>()

                for (response in showResponse) {
                    val show = ShowEntity(
                        response.id,
                        response.title,
                        response.releaseDate,
                        response.voteAverage,
                        response.overview,
                        response.posterPath
                    )
                    showList.add(show)
                }
                showsResult.postValue(showList)
            }
        })
        return showsResult
    }
    override fun getMovieDetail(movieId: Int): LiveData<ShowEntity> {
        val movieResult = MutableLiveData<ShowEntity>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMovieReceived(movieResponse: List<MovieResponse>) {
                lateinit var movie: ShowEntity

                for (response in movieResponse) {
                    if (response.id == movieId) {
                        movie = ShowEntity(
                            response.id,
                            response.title,
                            response.releaseDate,
                            response.voteAverage,
                            response.overview,
                            response.posterPath)
                    }
                }
                movieResult.postValue(movie)
            }
        })
        return movieResult
    }


    override fun getShowDetail(tvId: Int): LiveData<ShowEntity> {
        val showResult = MutableLiveData<ShowEntity>()
        remoteDataSource.getAllShows(object : RemoteDataSource.LoadShowsCallback {
            override fun onAllShowreceived(showResponse: List<TvResponse>) {
                lateinit var show: ShowEntity

                for (response in showResponse) {
                    if (response.id == tvId) {
                        show = ShowEntity(
                            response.id,
                            response.title,
                            response.releaseDate,
                            response.voteAverage,
                            response.overview,
                            response.posterPath
                        )
                    }
                }
                showResult.postValue(show)
            }
        })
        return showResult
    }
}