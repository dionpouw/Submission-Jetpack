package com.aldion.moviecatalog.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "movieShowEntities")
@Parcelize
data class ShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieShowId")
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "category")
    var category: String,

    @ColumnInfo(name = "releaseDate")
    val releaseDate: String,

    @ColumnInfo(name = "voteAverage")
    val voteAverage: Double,

    @ColumnInfo(name = "overview")
    val overview: String,

    @Nullable
    @ColumnInfo(name = "bookmarked")
    var bookmarked: Boolean = false,

    @ColumnInfo(name = "posterPath")
    val posterPath: String,
) : Parcelable