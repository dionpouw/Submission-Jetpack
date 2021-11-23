package com.aldion.moviecatalog.ui.fragment.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.aldion.moviecatalog.data.source.ShowsRepository
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.vo.Resource
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
    private lateinit var pagedList: PagedList<ShowEntity>

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<ShowEntity>>>

    @Before
    fun setUp() {
        viewModel = TvViewModel(showsRepository)
    }

    @Test
    fun getTvShows() {
        val dummyShow = Resource.success(pagedList)
        `when`(dummyShow.data?.size).thenReturn(10)
        val data = MutableLiveData<Resource<PagedList<ShowEntity>>>()
        data.value = dummyShow

        `when`(showsRepository.getAllShows()).thenReturn(data)
        val showEntities = viewModel.getTvShows().value?.data
        verify(showsRepository).getAllShows()
        assertNotNull(showEntities)
        assertEquals(10, showEntities?.size)

        viewModel.getTvShows().observeForever(observer)
        verify(observer).onChanged(dummyShow)
    }
}