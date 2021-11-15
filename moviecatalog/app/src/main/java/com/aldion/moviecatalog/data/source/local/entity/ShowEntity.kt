package com.aldion.moviecatalog.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShowEntity(
    val id: Int,
    var title: String,
    val releaseDate: String,
    var voteAverage: Double,
    var overview: String,
    var posterPath: String,
) : Parcelable