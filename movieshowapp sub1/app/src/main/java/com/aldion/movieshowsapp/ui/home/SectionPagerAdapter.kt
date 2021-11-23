import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aldion.movieshowsapp.ui.movieshows.MoviesShowsFragment
import com.aldion.movieshowsapp.ui.home.HomeActivity

class SectionsPagerAdapter(
    activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        return MoviesShowsFragment.newInstance(position)
    }

    override fun getItemCount(): Int = HomeActivity.TAB_TITLES.size
}