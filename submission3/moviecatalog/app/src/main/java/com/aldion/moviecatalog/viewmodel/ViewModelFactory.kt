package com.aldion.moviecatalog.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aldion.moviecatalog.data.source.ShowsRepository
import com.aldion.moviecatalog.di.Injection
import com.aldion.moviecatalog.ui.detail.DetailShowViewModel
import com.aldion.moviecatalog.ui.fragment.movie.MoviesShowsViewModel
import com.aldion.moviecatalog.ui.fragment.tv.TvViewModel

class ViewModelFactory private constructor(private val mShowsRepository: ShowsRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory = instance ?: synchronized(this) {
            instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                instance = this
            }
        }
    }
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(DetailShowViewModel::class.java) -> {
                DetailShowViewModel(mShowsRepository) as T
            }
            modelClass.isAssignableFrom(MoviesShowsViewModel::class.java) -> {
                MoviesShowsViewModel(mShowsRepository) as T
            }
            modelClass.isAssignableFrom(TvViewModel::class.java) -> {
                TvViewModel(mShowsRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}