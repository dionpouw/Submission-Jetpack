package com.aldion.movieshowsapp.data.source

import com.aldion.movieshowsapp.data.source.local.entity.ShowEntity
import com.aldion.movieshowsapp.utils.DataDummy

class MovieShowRepository : MovieShowDataSource {
    override fun getAllMovies(): ArrayList<ShowEntity> {
        val movieResponses = DataDummy.generateDummyFilms()
        val movieList = ArrayList<ShowEntity>()
        for (response in movieResponses) {
            val course = ShowEntity(
                response.id,
                response.title,
                response.year,
                response.genre,
                response.actor,
                response.userRating,
                response.description,
                response.imagePath
            )
            movieList.add(course)
        }
        return movieList
    }

    override fun getAllTvShows(): ArrayList<ShowEntity> {
        val showResponses = DataDummy.generateDummyTvShows()
        val showList = ArrayList<ShowEntity>()
        for (response in showResponses) {
            val course = ShowEntity(
                response.id,
                response.title,
                response.year,
                response.genre,
                response.actor,
                response.userRating,
                response.description,
                response.imagePath
            )
            showList.add(course)
        }
        return showList
    }

    override fun getDetailMovies(id: String): ShowEntity {
        val movieResponses = DataDummy.generateDummyFilms()
        lateinit var movie: ShowEntity
        for (response in movieResponses) {
            if (response.id == id) {
                movie = ShowEntity(
                    response.id,
                    response.title,
                    response.year,
                    response.genre,
                    response.actor,
                    response.userRating,
                    response.description,
                    response.imagePath
                )
            }
        }
        return movie
    }

    override fun getDetailShow(id: String): ShowEntity {
        val showResponses = DataDummy.generateDummyTvShows()
        lateinit var show: ShowEntity
        for (response in showResponses) {
            if (response.id == id) {
                show = ShowEntity(
                    response.id,
                    response.title,
                    response.year,
                    response.genre,
                    response.actor,
                    response.userRating,
                    response.description,
                    response.imagePath
                )
            }
        }
        return show
    }
}