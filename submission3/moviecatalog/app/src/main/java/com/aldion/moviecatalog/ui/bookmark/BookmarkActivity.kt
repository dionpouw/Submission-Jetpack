package com.aldion.moviecatalog.ui.bookmark

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aldion.moviecatalog.databinding.ActivityBookmarkBinding
import com.aldion.moviecatalog.viewmodel.ViewModelFactory

class BookmarkActivity : AppCompatActivity() {
    private var _binding: ActivityBookmarkBinding? = null
    private val binding get() = _binding
    private var listAdapter = BookmarkAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityBookmarkBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Bookmarked"
        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[BookmarkViewModel::class.java]

        viewModel.getBookmarked().observe(this, { bookmark ->
            if (bookmark.isNotEmpty()) {
                binding?.emptyData?.visibility = View.GONE
                listAdapter.setBookmark(bookmark)
                listAdapter.notifyDataSetChanged()
            } else {
                binding?.emptyData?.visibility = View.VISIBLE
            }
        })

        binding?.rvBookmarked?.apply {
            layoutManager = LinearLayoutManager(this@BookmarkActivity)
            setHasFixedSize(true)
            adapter = listAdapter
        }

        ItemTouchHelper(
            object : ItemTouchHelper.SimpleCallback(
                0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
            ) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder,
                ): Boolean {
                    return false // true if moved, false otherwise
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position: Int = viewHolder.absoluteAdapterPosition
                    viewModel.setFavorite(listAdapter.getBookmarkAt(position), false)
                    Toast.makeText(this@BookmarkActivity, "unfavorite", Toast.LENGTH_SHORT).show()
                }
            }).attachToRecyclerView(binding?.rvBookmarked)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
