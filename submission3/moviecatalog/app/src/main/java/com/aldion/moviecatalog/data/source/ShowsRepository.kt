package com.aldion.moviecatalog.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.aldion.moviecatalog.data.NetworkBoundResource
import com.aldion.moviecatalog.data.source.local.LocalDataSource
import com.aldion.moviecatalog.data.source.local.entity.DetailEntity
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.data.source.remote.ApiResponse
import com.aldion.moviecatalog.data.source.remote.RemoteDataSource
import com.aldion.moviecatalog.data.source.remote.response.MovieResponse
import com.aldion.moviecatalog.data.source.remote.response.TvResponse
import com.aldion.moviecatalog.utils.AppExecutors
import com.aldion.moviecatalog.vo.Resource

class ShowsRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors,
) :
    ShowsDataSource {
    override fun getAllMovies(): LiveData<Resource<PagedList<ShowEntity>>> {
        return object :
            NetworkBoundResource<PagedList<ShowEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<ShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<ShowEntity>?): Boolean =
                data == null || data.isEmpty()


            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()


            public override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<ShowEntity>()
                for (response in data) {
                    val movie = ShowEntity(
                        response.id,
                        response.title,
                        "movie",
                        response.releaseDate,
                        response.voteAverage,
                        response.overview,
                        false,
                        response.posterPath
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMoviesShows(movieList)
            }
        }.asLiveData()
    }

    override fun getAllShows(): LiveData<Resource<PagedList<ShowEntity>>> {
        return object :
            NetworkBoundResource<PagedList<ShowEntity>, List<TvResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<ShowEntity>> {
                val config = PagedList.Config.Builder().apply {
                    setEnablePlaceholders(false)
                    setInitialLoadSizeHint(4)
                    setPageSize(4)
                }.build()
                return LivePagedListBuilder(localDataSource.getAllShows(), config).build()

            }

            override fun shouldFetch(data: PagedList<ShowEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TvResponse>>> =
                remoteDataSource.getAllShows()

            public override fun saveCallResult(data: List<TvResponse>) {
                val showList = ArrayList<ShowEntity>()

                for (response in data) {
                    val show = ShowEntity(
                        response.id,
                        response.title,
                        "tv",
                        response.releaseDate,
                        response.voteAverage,
                        response.overview,
                        false,
                        response.posterPath
                    )
                    showList.add(show)
                }
                localDataSource.insertMoviesShows(showList)
            }
        }.asLiveData()
    }

    override fun getMovieDetail(movieId: Int): LiveData<Resource<DetailEntity>> {
        return object : NetworkBoundResource<DetailEntity, MovieResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<DetailEntity> =
                localDataSource.getMovieShowDetail(movieId)

            override fun shouldFetch(data: DetailEntity?): Boolean = data == null

            override fun createCall(): LiveData<ApiResponse<MovieResponse>> =
                remoteDataSource.getDetailMovie(movieId)

            override fun saveCallResult(data: MovieResponse) {
                val detailEntity = DetailEntity(
                    data.id,
                    data.title,
                    data.releaseDate,
                    data.voteAverage,
                    data.overview,
                    data.posterPath
                )
                localDataSource.insertMovieDetail(detailEntity)
            }
        }.asLiveData()
    }

    override fun getShowDetail(showId: Int): LiveData<Resource<DetailEntity>> {
        return object : NetworkBoundResource<DetailEntity, TvResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<DetailEntity> =
                localDataSource.getMovieShowDetail(showId)

            override fun shouldFetch(data: DetailEntity?): Boolean = data == null

            override fun createCall(): LiveData<ApiResponse<TvResponse>> =
                remoteDataSource.getDetailShow(showId)

            override fun saveCallResult(data: TvResponse) {
                val detailEntity = DetailEntity(
                    data.id,
                    data.title,
                    data.releaseDate,
                    data.voteAverage,
                    data.overview,
                    data.posterPath
                )
                localDataSource.insertShowDetail(detailEntity)
            }
        }.asLiveData()
    }

    override fun getBookmarkedMoviesShows(): LiveData<PagedList<ShowEntity>> {
        val config = PagedList.Config.Builder().setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getBookmarkedMovieShow(), config).build()
    }

    override fun setMovieShowBookmark(movieShow: ShowEntity, state: Boolean) =
        appExecutors.diskIO().execute {
            localDataSource.setMovieBookmark(movieShow, state)
        }

    companion object {
        @Volatile
        private var instance: ShowsRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localDataSource: LocalDataSource,
            appExecutors: AppExecutors,
        ): ShowsRepository =
            instance ?: synchronized(this) {
                instance ?: ShowsRepository(remoteData,
                    localDataSource,
                    appExecutors).apply { instance = this }
            }
    }
}