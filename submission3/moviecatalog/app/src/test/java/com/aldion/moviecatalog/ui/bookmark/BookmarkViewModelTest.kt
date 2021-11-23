package com.aldion.moviecatalog.ui.bookmark

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.aldion.moviecatalog.data.source.ShowsRepository
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
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
class BookmarkViewModelTest {
    private lateinit var viewModel: BookmarkViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieShowsRepository: ShowsRepository

    @Mock
    private lateinit var pagedList: PagedList<ShowEntity>

    @Mock
    private lateinit var observer: Observer<PagedList<ShowEntity>>

    @Before
    fun setUp() {
        viewModel = BookmarkViewModel(movieShowsRepository)
    }

    @Test
    fun getBookmarkMovie() {
        val dummyMovie = pagedList
        `when`(dummyMovie.size).thenReturn(10)
        val movie = MutableLiveData<PagedList<ShowEntity>>()
        movie.value = dummyMovie

        `when`(movieShowsRepository.getBookmarkedMoviesShows()).thenReturn(movie)
        val movieEntities = viewModel.getBookmarked().value
        verify(movieShowsRepository).getBookmarkedMoviesShows()
        assertNotNull (movieEntities)
        assertEquals(10, movieEntities?.size)

        viewModel.getBookmarked().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}
