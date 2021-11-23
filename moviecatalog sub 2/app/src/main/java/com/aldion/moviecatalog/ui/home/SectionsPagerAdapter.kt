package com.aldion.moviecatalog.ui.home

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aldion.moviecatalog.ui.fragment.movie.MoviesFragment
import com.aldion.moviecatalog.ui.fragment.tv.TvFragment

class SectionsPagerAdapter(
    activity: AppCompatActivity,
) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = MoviesFragment()
            1 -> fragment = TvFragment()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int = HomeActivity.TAB_TITLES.size
}
