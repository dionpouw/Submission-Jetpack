package com.aldion.movieshowsapp

import com.aldion.movieshowsapp.ui.detail.DetailShowViewModel
import com.aldion.movieshowsapp.utils.DataDummy
import junit.framework.Assert.*

import org.junit.Before
import org.junit.Test

class DetailShowViewModelTest {

    private lateinit var viewModel: DetailShowViewModel
    private val dummyFilm = DataDummy.generateDummyFilms()[0]
    private val dummyShows = DataDummy.generateDummyTvShows()[0]

    @Before
    fun setUp() {
        viewModel = DetailShowViewModel()
    }

    @Test
    fun setMovieShows() {
        viewModel.setMovieShows(dummyFilm.id, dummyFilm.category)
        val movieShow = viewModel.movieShow
        assertNotNull(movieShow)
        assertEquals(dummyFilm.id, movieShow.id)
        assertEquals(dummyFilm.title, movieShow.title)
        assertEquals(dummyFilm.imagePath, movieShow.imagePath)
        assertEquals(dummyFilm.year, movieShow.year)
        assertEquals(dummyFilm.genre, movieShow.genre)
        assertEquals(dummyFilm.userRating, movieShow.userRating)
        assertEquals(dummyFilm.actor, movieShow.actor)
        assertEquals(dummyFilm.description, movieShow.description)
    }

    @Test
    fun setTVShows() {
        viewModel.setMovieShows(dummyShows.id, dummyShows.category)
        val tvShow = viewModel.movieShow
        assertNotNull(tvShow)
        assertEquals(dummyShows.id, tvShow.id)
        assertEquals(dummyShows.title, tvShow.title)
        assertEquals(dummyShows.imagePath, tvShow.imagePath)
        assertEquals(dummyShows.year, tvShow.year)
        assertEquals(dummyShows.genre, tvShow.genre)
        assertEquals(dummyShows.userRating, tvShow.userRating)
        assertEquals(dummyShows.actor, tvShow.actor)
        assertEquals(dummyShows.description, tvShow.description)
    }
}