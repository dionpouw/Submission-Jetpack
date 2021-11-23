package com.aldion.moviecatalog.ui.fragment.tv

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldion.moviecatalog.databinding.TvFragmentBinding
import com.aldion.moviecatalog.viewmodel.ViewModelFactory
import com.aldion.moviecatalog.vo.Status

class TvFragment : Fragment() {
    private var _binding: TvFragmentBinding? =null
    private val binding get() = _binding!!
    private var listAdapter = TvAdapter()
    private var contextThis: Context? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = TvFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(requireActivity(), factory)[TvViewModel::class.java]

        viewModel.getTvShows().observe(this, { shows ->
            if (shows != null) {
                when (shows.status) {
                    Status.LOADING -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.rvMoviesShows.visibility = View.GONE
                    }
                    Status.SUCCESS -> {
                        binding.progressBar.visibility = View.GONE
                        binding.rvMoviesShows.visibility = View.VISIBLE
                        listAdapter.submitList(shows.data)
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

