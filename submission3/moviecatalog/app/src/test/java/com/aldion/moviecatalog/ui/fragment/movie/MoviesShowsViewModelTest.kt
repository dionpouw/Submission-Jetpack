package com.aldion.moviecatalog.ui.fragment.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aldion.moviecatalog.data.source.ShowsRepository
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.utils.DataDummy
import com.aldion.moviecatalog.vo.Resource
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesShowsViewModelTest {
    private lateinit var viewModel: MoviesShowsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var showsRepository: ShowsRepository

    @Mock
    private lateinit var observer: Observer<Resource<List<ShowEntity>>>

    @Before
    fun setUp() {
        viewModel = MoviesShowsViewModel(showsRepository)
    }

    @Test
    fun getMovie() {
        val dummyMovie = Resource.success(DataDummy.generateDummyFilms())
        val data = MutableLiveData<Resource<List<ShowEntity>>>()
        data.value = dummyMovie

        `when`(showsRepository.getAllMovies()).thenReturn(data)
        val moviesEntities = viewModel.getMovie().value?.data
        verify(showsRepository).getAllMovies()
        assertNotNull(moviesEntities)
        assertEquals(10, moviesEntities?.size)

        viewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}