package com.aldion.moviecatalog.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aldion.moviecatalog.data.source.remote.RemoteDataSource
import com.aldion.moviecatalog.utils.DataDummy
import com.aldion.moviecatalog.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class ShowsRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val filmRepository = FakeShowsRepository(remote)

    private val moviesResponse = DataDummy.generateRemoteDummyFilms()
    private val showsResponse = DataDummy.generateRemoteDummyTvShows()
    private val movieId = moviesResponse[0].id
    private val showId = showsResponse[0].id

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMovieReceived(moviesResponse)
            null
        }.`when`(remote).getAllMovies(any())
        val movieEntity = LiveDataTestUtil.getValue(filmRepository.getAllMovies())
        verify(remote).getAllMovies(any())
        assertNotNull(movieEntity)
        assertEquals(moviesResponse.size.toLong(), movieEntity.size.toLong())
    }

    @Test
    fun getAllShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadShowsCallback)
                .onAllShowreceived(showsResponse)
            null
        }.`when`(remote).getAllShows(any())
        val showEntity = LiveDataTestUtil.getValue(filmRepository.getAllShows())
        verify(remote).getAllShows(any())
        assertNotNull(showEntity)
        assertEquals(showsResponse.size.toLong(), showEntity.size.toLong())
    }

    @Test
    fun getMovieDetail() {
        doAnswer {
                invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback).onAllMovieReceived(moviesResponse)
            null
        }.`when`(remote).getAllMovies(any())
        val movieEntity = LiveDataTestUtil.getValue(filmRepository.getMovieDetail(movieId))
        verify(remote).getAllMovies(any())
        assertNotNull(movieEntity)
        assertEquals(moviesResponse[0].id,movieEntity.id)
    }

    @Test
    fun getShowDetail() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadShowsCallback).onAllShowreceived(showsResponse)
            null
        }.`when`(remote).getAllShows(any())
        val showEntity = LiveDataTestUtil.getValue(filmRepository.getShowDetail(showId))
        verify(remote).getAllShows(any())
        assertNotNull(showEntity)
        assertEquals(showsResponse[0].id,showEntity.id)
    }
}