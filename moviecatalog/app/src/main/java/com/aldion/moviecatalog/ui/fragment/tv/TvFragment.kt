package com.aldion.moviecatalog.ui.fragment.tv

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldion.moviecatalog.databinding.TvFragmentBinding
import com.aldion.moviecatalog.viewmodel.ViewModelFactory

class TvFragment : Fragment() {
    private lateinit var binding: TvFragmentBinding
    private var listAdapter = TvAdapter()
    private var contextThis: Context? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = TvFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel =
            ViewModelProvider(requireActivity(), factory)[TvViewModel::class.java]

        binding.progressBar.visibility = View.VISIBLE
        viewModel.getTvShows().observe(viewLifecycleOwner, { tvShows ->
            binding.progressBar.visibility = View.GONE
            listAdapter.setShow(tvShows)
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

