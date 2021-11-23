package com.aldion.moviecatalog.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aldion.moviecatalog.data.source.ShowsRepository
import com.aldion.moviecatalog.data.source.local.entity.DetailEntity
import com.aldion.moviecatalog.utils.DataDummy
import com.aldion.moviecatalog.vo.Resource
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
    private val dummyDetailShow = DataDummy.generateDummyTvShows()[0]
    private val tvId = dummyDetailShow.id
    private val movieId = dummyDetailMovie.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var showsRepository: ShowsRepository

    @Mock
    private lateinit var observer: Observer<Resource<DetailEntity>>

    @Before
    fun setUp() {
        viewModel = DetailShowViewModel(showsRepository)
    }

    @Test
    fun getMovieDetail() {
        val dummyDetailMovie = Resource.success(DataDummy.generateDataDummyMovie()[0])
        val movie = MutableLiveData<Resource<DetailEntity>>()
        movie.value = dummyDetailMovie

        viewModel.setSelectedShow(movieId)

        `when`(showsRepository.getMovieDetail(movieId)).thenReturn(movie)
        val result = viewModel.getMovieDetail().value?.data

        verify(showsRepository).getMovieDetail(movieId)
        assertNotNull(result)

        assertEquals(dummyDetailMovie.data?.id, result?.id)
        assertEquals(dummyDetailMovie.data?.title, result?.title)
        assertEquals(dummyDetailMovie.data?.releaseDate, result?.releaseDate)
        assertEquals(dummyDetailMovie.data?.voteAverage, result?.voteAverage)
        assertEquals(dummyDetailMovie.data?.overview, result?.overview)
        assertEquals(dummyDetailMovie.data?.posterPath, result?.posterPath)

        viewModel.getMovieDetail().observeForever(observer)
        verify(observer).onChanged(dummyDetailMovie)
    }

    @Test
    fun getShowDetail() {
        val dummyDetailShow = Resource.success(DataDummy.generateDataDummyShow()[0])
        val show = MutableLiveData<Resource<DetailEntity>>()
        show.value = dummyDetailShow

        viewModel.setSelectedShow(tvId)

        `when`(showsRepository.getShowDetail(tvId)).thenReturn(show)
        val result = viewModel.getShowDetail().value?.data

        verify(showsRepository).getShowDetail(tvId)
        assertNotNull(result)

        assertEquals(dummyDetailShow.data?.id, result?.id)
        assertEquals(dummyDetailShow.data?.title, result?.title)
        assertEquals(dummyDetailShow.data?.releaseDate, result?.releaseDate)
        assertEquals(dummyDetailShow.data?.voteAverage, result?.voteAverage)
        assertEquals(dummyDetailShow.data?.overview, result?.overview)
        assertEquals(dummyDetailShow.data?.posterPath, result?.posterPath)

        viewModel.getShowDetail().observeForever(observer)
        verify(observer).onChanged(dummyDetailShow)
    }
}