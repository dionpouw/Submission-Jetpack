package com.aldion.moviecatalog.ui.fragment.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aldion.moviecatalog.data.source.ShowsRepository
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvViewModelTest {
    private lateinit var viewModel: TvViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var showsRepository: ShowsRepository

    @Mock
    private lateinit var observer: Observer<List<ShowEntity>>

    @Before
    fun setUp() {
        viewModel = TvViewModel(showsRepository)
    }

    @Test
    fun getTvShows() {
        val dummyShows = DataDummy.generateDummyTvShows()
        val data = MutableLiveData<List<ShowEntity>>()
        data.value = dummyShows

        `when`(showsRepository.getAllShows()).thenReturn(data)
        val showsEntities = viewModel.getTvShows().value
        verify(showsRepository).getAllShows()
        assertNotNull(showsEntities)
        assertEquals(10, showsEntities?.size)

        viewModel.getTvShows().observeForever(observer)
        verify(observer).onChanged(dummyShows)
    }
}