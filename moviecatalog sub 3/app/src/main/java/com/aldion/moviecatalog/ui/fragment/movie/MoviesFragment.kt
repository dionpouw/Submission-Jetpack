package com.aldion.moviecatalog.ui.fragment.movie

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldion.moviecatalog.databinding.MovieShowFragmentBinding
import com.aldion.moviecatalog.viewmodel.ViewModelFactory
import com.aldion.moviecatalog.vo.Status

class MoviesFragment : Fragment() {

    private var _binding: MovieShowFragmentBinding? = null
    private val binding get() = _binding!!
    private var listAdapter = MoviesShowsAdapter()
    private var contextThis: Context? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = MovieShowFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel =
            ViewModelProvider(requireActivity(), factory)[MoviesShowsViewModel::class.java]

        viewModel.getMovie().observe(this, { movies ->
            if (movies != null) {
                when (movies.status) {
                    Status.LOADING -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.rvMoviesShows.visibility = View.GONE
                    }
                    Status.SUCCESS -> {
                        binding.progressBar.visibility = View.GONE
                        binding.rvMoviesShows.visibility = View.VISIBLE
                        listAdapter.submitList(movies.data)
                        listAdapter.notifyDataSetChanged()
                    }
                    Status.ERROR -> {
                        binding.progressBar.visibility = View.GONE
                        binding.rvMoviesShows.visibility = View.GONE
                        Toast.makeText(context, "There's an error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        binding.rvMoviesShows.apply {
            layoutManager = LinearLayoutManager(contextThis)
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

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}