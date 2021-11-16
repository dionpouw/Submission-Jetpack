package com.aldion.moviecatalog.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aldion.moviecatalog.data.source.ShowsRepository
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailShowViewModelTest {

    private lateinit var viewModel: DetailShowViewModel
    private val dummyDetailMovie = DataDummy.generateDummyFilms()[0]
    private val movieId = dummyDetailMovie.id

    private val dummyDetailShow = DataDummy.generateDummyTvShows()[0]
    private val tvId = dummyDetailShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var showsRepository: ShowsRepository

    @Mock
    private lateinit var observer: Observer<ShowEntity>

    @Before
    fun setUp() {
        viewModel = DetailShowViewModel(showsRepository)
    }

    @Test
    fun getMovieDetail() {
        val movie = MutableLiveData<ShowEntity>()
        movie.value = dummyDetailMovie

        viewModel.setSelectedShow(movieId)

        `when`(showsRepository.getMovieDetail(movieId)).thenReturn(movie)
        val result = viewModel.getMovieDetail().value

        verify(showsRepository).getMovieDetail(movieId)
        assertNotNull(result)

        assertEquals(dummyDetailMovie.id, result?.id)
        assertEquals(dummyDetailMovie.title, result?.title)
        assertEquals(dummyDetailMovie.releaseDate, result?.releaseDate)
        assertEquals(dummyDetailMovie.voteAverage, result?.voteAverage)
        assertEquals(dummyDetailMovie.overview, result?.overview)
        assertEquals(dummyDetailMovie.posterPath, result?.posterPath)

        viewModel.getMovieDetail().observeForever(observer)
        verify(observer).onChanged(dummyDetailMovie)
    }

    @Test
    fun getShowDetail() {
        val show = MutableLiveData<ShowEntity>()
        show.value = dummyDetailShow

        viewModel.setSelectedShow(tvId)

        `when`(showsRepository.getShowDetail(tvId)).thenReturn(show)
        val result = viewModel.getShowDetail().value

        verify(showsRepository).getShowDetail(tvId)
        assertNotNull(result)

        assertEquals(dummyDetailShow.id, result?.id)
        assertEquals(dummyDetailShow.title, result?.title)
        assertEquals(dummyDetailShow.releaseDate, result?.releaseDate)
        assertEquals(dummyDetailShow.voteAverage, result?.voteAverage)
        assertEquals(dummyDetailShow.overview, result?.overview)
        assertEquals(dummyDetailShow.posterPath, result?.posterPath)

        viewModel.getShowDetail().observeForever(observer)
        verify(observer).onChanged(dummyDetailShow)
    }

}