package com.aldion.moviecatalog.ui.detail

import androidx.lifecycle.ViewModel
import com.aldion.moviecatalog.data.ShowEntity
import com.aldion.moviecatalog.utils.DataDummy

class DetailShowViewModel:ViewModel() {
    lateinit var movieShow: ShowEntity

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