package com.aldion.jetpackprosubmission1.ui.movieshows

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldion.jetpackprosubmission1.databinding.MoviesShowsFragmentBinding

class MoviesShowsFragment : Fragment() {

    private lateinit var binding: MoviesShowsFragmentBinding
    private var listAdapter = MoviesShowsAdapter()
    private val movieShowFragmentViewModel by viewModels<MoviesShowsViewModel>()
    private var contextThis: Context? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MoviesShowsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments?.getInt(ARG_SECTION_NUMBER, 0) == 0) {
            val movieTvShows = movieShowFragmentViewModel.getMovie()
            listAdapter.setMovieShow(movieTvShows)
        } else {
            val movieTvShows = movieShowFragmentViewModel.getTvShows()
            listAdapter.setMovieShow(movieTvShows)
        }

        binding.rvMoviesShows.apply {
            layoutManager = LinearLayoutManager(contextThis)
            setHasFixedSize(true)
            adapter = listAdapter
        }
        listAdapter.notifyDataSetChanged()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contextThis = context
    }

    override fun onDetach() {
        super.onDetach()
        this.contextThis = null
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    companion object {
        private const val ARG_SECTION_NUMBER =
            "com.aldion.jetpackprosubmission1.ui.movieshows.fragment"

        @JvmStatic
        fun newInstance(index: Int) =
            MoviesShowsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, index)
                }
            }
    }


}