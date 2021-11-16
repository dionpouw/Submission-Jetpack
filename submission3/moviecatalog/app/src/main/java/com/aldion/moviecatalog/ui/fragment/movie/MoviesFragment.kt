package com.aldion.moviecatalog.ui.fragment.movie

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldion.moviecatalog.databinding.MovieShowFragmentBinding
import com.aldion.moviecatalog.viewmodel.ViewModelFactory

class MoviesFragment : Fragment() {

    private lateinit var binding: MovieShowFragmentBinding
    private var listAdapter = MoviesShowsAdapter()
    private var contextThis: Context? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = MovieShowFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel =
            ViewModelProvider(requireActivity(), factory)[MoviesShowsViewModel::class.java]

        binding.progressBar.visibility = View.VISIBLE
        viewModel.getMovie().observe(viewLifecycleOwner, { movieTvShows ->
            binding.progressBar.visibility = View.GONE
            listAdapter.setMovie(movieTvShows)
            listAdapter.notifyDataSetChanged()
        })

        binding.rvMoviesShows.apply {
            layoutManager = LinearLayoutManager(contextThis)
            setHasFixedSize(true)
            adapter = listAdapter
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contextThis = context
    }

    override fun onDetach() {
        super.onDetach()
        this.contextThis = null
    }
}