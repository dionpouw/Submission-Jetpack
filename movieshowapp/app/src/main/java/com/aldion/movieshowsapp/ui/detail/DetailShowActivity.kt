import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aldion.movieshowsapp.databinding.ActivityDetailShowBinding
import com.bumptech.glide.Glide

class DetailShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDetailShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val movieShow = intent.getParcelableExtra<ShowEntity>(EXTRA_SHOWS)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.apply {
            Glide.with(this@DetailShowActivity).load(movieShow?.imagePath).thumbnail(0.9f)
                .into(imgPoster)
            tvTitle.text = movieShow?.title
            tvGenre.text = movieShow?.genre
            tvYear.text = movieShow?.year
            tvUserReviewNumber.text = movieShow?.userRating
            tvListActor.text = movieShow?.actor
            tvDescriptionContent.text = movieShow?.description
        }

        supportActionBar?.elevation = 0f
    }

    companion object {
        const val EXTRA_SHOWS = "EXTRA_SHOWS"
    }
}