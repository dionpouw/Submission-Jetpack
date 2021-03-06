package com.aldion.moviecatalog.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.aldion.moviecatalog.data.source.ShowsRepository
import com.aldion.moviecatalog.data.source.local.entity.ShowEntity

class BookmarkViewModel(private val mShowsRepository: ShowsRepository) : ViewModel() {
    fun getBookmarked(): LiveData<PagedList<ShowEntity>> = mShowsRepository.getBookmarkedMoviesShows()
    fun setFavorite(movieShow: ShowEntity) {
        val newState = !movieShow.bookmarked
        mShowsRepository.setMovieShowBookmark(movieShow,newState)
    }
}