package com.aldion.jetpackprosubmission1.ui.movieshows

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class MoviesShowsViewModelTest {
    private lateinit var viewModel: MoviesShowsViewModel
    @Before
    fun setUp() {
        viewModel = MoviesShowsViewModel()
    }

    @Test
    fun getMovie() {
        val movieEntities = viewModel.getMovie()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.size)
    }

    @Test
    fun getTvShows() {
        val showEntities = viewModel.getTvShows()
        assertNotNull(showEntities)
        assertEquals(10, showEntities.size)
    }
}