package com.aldion.moviecatalog.utils

import android.content.Context
import com.aldion.moviecatalog.data.source.remote.response.MovieResponse
import com.aldion.moviecatalog.data.source.remote.response.TvResponse
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("Movie.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getInt("id")
                val overview = movie.getString("overview")
                val posterPath = movie.getString("poster_path")
                val releaseDate = movie.getString("release_date")
                val title = movie.getString("title")
                val voteAverage = movie.getDouble("vote_average")

                val movieResponse = MovieResponse(
                    id,
                    title,
                    releaseDate,
                    voteAverage,
                    overview,
                    posterPath
                )
                list.add(movieResponse)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadTvShows(): List<TvResponse> {
        val list = ArrayList<TvResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("Shows.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val releaseDate = movie.getString("first_air_date")
                val id = movie.getInt("id")
                val title = movie.getString("name")
                val overview = movie.getString("overview")
                val posterPath = movie.getString("poster_path")
                val voteAverage = movie.getDouble("vote_average")

                val tvShowsResponse = TvResponse(
                    id,
                    title,
                    releaseDate,
                    voteAverage,
                    overview,
                    posterPath
                )
                list.add(tvShowsResponse)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadDetailShow(showID: Int): TvResponse {
        var tvDetail: TvResponse? = null
        try {
            val responseObject = JSONObject(parsingFileToString("Shows.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val show = listArray.getJSONObject(i)

                val releaseDate = show.getString("first_air_date")
                val id = show.getInt("id")
                val title = show.getString("name")
                val overview = show.getString("overview")
                val posterPath = show.getString("poster_path")
                val voteAverage = show.getDouble("vote_average")

                if (id == showID) {
                    tvDetail = TvResponse(
                        id,
                        title,
                        releaseDate,
                        voteAverage,
                        overview,
                        posterPath
                    )
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return tvDetail as TvResponse
    }

    fun loadDetailMovie(movieID: Int): MovieResponse {
        var movieDetail: MovieResponse? = null
        try {
            val responseObject = JSONObject(parsingFileToString("Movie.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getInt("id")
                val overview = movie.getString("overview")
                val posterPath = movie.getString("poster_path")
                val releaseDate = movie.getString("release_date")
                val title = movie.getString("title")
                val voteAverage = movie.getDouble("vote_average")

                if (id == movieID) {
                    movieDetail = MovieResponse(
                        id,
                        title,
                        releaseDate,
                        voteAverage,
                        overview,
                        posterPath
                    )
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return movieDetail as MovieResponse
    }

}