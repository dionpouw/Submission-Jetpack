package com.aldion.moviecatalog.data.source

import android.provider.ContactsContract
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.aldion.moviecatalog.data.source.remote.RemoteDataSource
import com.aldion.moviecatalog.utils.DataDummy
import com.aldion.moviecatalog.LiveDataTestUtil
import com.aldion.moviecatalog.data.source.local.LocalDataSource
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.utils.AppExecutors
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class ShowsRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val filmRepository = FakeShowsRepository(remote,local,appExecutors)

    private val moviesResponse = DataDummy.generateRemoteDummyFilms()
    private val showsResponse = DataDummy.generateRemoteDummyTvShows()
    private val movieId = moviesResponse[0].id
    private val showId = showsResponse[0].id

    @Test
    fun getAllMovies() {
        val dummyMovies = MutableLiveData<List<ShowEntity>>()
        dummyMovies.value = DataDummy.generateDummyFilms()
        `when`(local.getAllMovies()).thenReturn(dummyMovies)

        val movieEntity = LiveDataTestUtil.getValue(filmRepository.getAllMovies())
        verify(local).getAllMovies()
        assertNotNull(movieEntity.data)
        assertEquals(moviesResponse.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getAllShows() {
        val dummyShows = MutableLiveData<List<ShowEntity>>()
        dummyShows.value = DataDummy.generateDummyTvShows()
        val showEntity = LiveDataTestUtil.getValue(filmRepository.getAllShows())
        verify(remote).getAllShows()
        assertNotNull(showEntity)
        assertEquals(showsResponse.size.toLong(), showEntity.data?.size?.toLong())
    }

    @Test
    fun getMovieDetail() {
        val dummyEntity = MutableLiveData<ShowEntity>()
        dummyEntity.value = DataDummy.genera
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