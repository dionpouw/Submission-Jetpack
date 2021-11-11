package com.aldion.movieshowsapp.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShowEntity(
    var id:String,
    var title: String,
    var year: String,
    var genre: String,
    var actor: String,
    var userRating: String,
    var description: String,
    var imagePath: Int
) : Parcelable
