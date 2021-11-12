package com.aldion.moviecatalog.ui.home

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aldion.moviecatalog.ui.fragment.MoviesShowsFragment

class SectionsPagerAdapter(
    activity: AppCompatActivity
) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        return MoviesShowsFragment.newInstance(position)
    }

    override fun getItemCount(): Int = HomeActivity.TAB_TITLES.size
}
