package com.aldion.moviecatalog.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShowEntity(
    val id: Int,
    val title: String,
    val releaseDate: String,
    val voteAverage: Double,
    val overview: String,
    val posterPath: String,
) : Parcelable