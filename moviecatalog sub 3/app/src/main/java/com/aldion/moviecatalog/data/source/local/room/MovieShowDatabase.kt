package com.aldion.moviecatalog.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aldion.moviecatalog.data.source.local.entity.DetailEntity
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity

@Database(entities = [ShowEntity::class, DetailEntity::class],
    version = 1, exportSchema = false)
abstract class MovieShowDatabase : RoomDatabase() {
    abstract fun movieShowDao(): MovieShowDao

    companion object {
        @Volatile
        private var INSTANCE: MovieShowDatabase? = null

        fun getInstance(context: Context): MovieShowDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    MovieShowDatabase::class.java,
                    "MovieShow.db"
                ).build().apply { INSTANCE = this }
            }
    }
}