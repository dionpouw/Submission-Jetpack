package com.aldion.moviecatalog.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.aldion.moviecatalog.utils.LiveDataTestUtil
import com.aldion.moviecatalog.data.source.local.LocalDataSource
import com.aldion.moviecatalog.data.source.local.entity.DetailEntity
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.data.source.remote.RemoteDataSource
import com.aldion.moviecatalog.utils.AppExecutors
import com.aldion.moviecatalog.utils.DataDummy
import com.aldion.moviecatalog.utils.PagedListUtil
import com.aldion.moviecatalog.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class ShowsRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val filmRepository = FakeShowsRepository(remote, local, appExecutors)

    private val moviesResponse = DataDummy.generateRemoteDummyFilms()
    private val showsResponse = DataDummy.generateRemoteDummyTvShows()
    private val movieId = moviesResponse[0].id
    private val showId = showsResponse[0].id

    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ShowEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        filmRepository.getAllMovies()
        val movieEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyFilms()))
        verify(local).getAllMovies()
        assertNotNull(movieEntity.data)
        assertEquals(moviesResponse.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getAllShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ShowEntity>
        `when`(local.getAllShows()).thenReturn(dataSourceFactory)
        filmRepository.getAllShows()

        val showEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getAllShows()
        assertNotNull(showEntity.data)
        assertEquals(showsResponse.size.toLong(), showEntity.data?.size?.toLong())
    }

    @Test
    fun getMovieDetail() {
        val dummyEntity = MutableLiveData<DetailEntity>()
        dummyEntity.value = DataDummy.generateDataDummyMovie()[0]
        `when`(local.getMovieShowDetail(movieId)).thenReturn(dummyEntity)
        val movieEntity = LiveDataTestUtil.getValue(filmRepository.getMovieDetail(movieId))
        verify(local).getMovieShowDetail(movieId)
        assertNotNull(movieEntity)
        assertEquals(moviesResponse[0].id, movieEntity.data?.id)
    }

    @Test
    fun getShowDetail() {
        val dummyEntity = MutableLiveData<DetailEntity>()
        dummyEntity.value = DataDummy.generateDataDummyShow()[0]
        `when`(local.getMovieShowDetail(showId)).thenReturn(dummyEntity)
        val showEntity = LiveDataTestUtil.getValue(filmRepository.getShowDetail(showId))
        verify(local).getMovieShowDetail(showId)
        assertNotNull(showEntity)
        assertEquals(showsResponse[0].id, showEntity.data?.id)
    }

    @Test
    fun getFavoritedMovie(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ShowEntity>
        `when`(local.getBookmarkedMovieShow()).thenReturn(dataSourceFactory)
        filmRepository.getBookmarkedMoviesShows()

        val bookmarkEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyFilms()))
        verify(local).getBookmarkedMovieShow()
        assertNotNull(bookmarkEntities)
        assertEquals(moviesResponse.size.toLong(), bookmarkEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoritedShow(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ShowEntity>
        `when`(local.getBookmarkedMovieShow()).thenReturn(dataSourceFactory)
        filmRepository.getBookmarkedMoviesShows()

        val bookmarkEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getBookmarkedMovieShow()
        assertNotNull(bookmarkEntities)
        assertEquals(showsResponse.size.toLong(), bookmarkEntities.data?.size?.toLong())
    }

}