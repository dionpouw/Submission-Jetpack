package com.aldion.movieshowsapp.ui.detail

import ShowEntity
import androidx.lifecycle.ViewModel
import com.aldion.movieshowsapp.utils.DataDummy

class DetailShowViewModel : ViewModel() {

    private lateinit var movieShow: ShowEntity

    fun setMovieShows(id: String,category: String): ShowEntity {
        when(category){
            TV_SHOW -> {
                for(tvShow in DataDummy.generateDummyTvShows()){
                    if(tvShow.id == id)
                        movieShow = tvShow
                }
            }
            MOVIE -> {
                for(movie in DataDummy.generateDummyFilms()){
                    if(movie.id == id)
                        movieShow = movie
                }
            }
        }
        return movieShow
    }

    companion object {
        const val TV_SHOW = "Shows"
        const val MOVIE = "Movie"
    }
}
