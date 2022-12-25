package com.boysatria.rekomendasifilm.ui.tv_series

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.boysatria.rekomendasifilm.R
import com.boysatria.rekomendasifilm.data.repo.MoviesRepository
import com.boysatria.rekomendasifilm.databinding.ActivityDetailTvSeriesBinding
import com.boysatria.rekomendasifilm.ui.movies.DetailMovieActivity
import com.bumptech.glide.Glide

class DetailTvSeriesActivity : AppCompatActivity() {

    companion object {
        const val ID_MOVIE = "id_movie"
        const val TITLE_MOVIE = "title_movie"
    }

    private lateinit var binding: ActivityDetailTvSeriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvSeriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idMovie = intent.getIntExtra(ID_MOVIE, 0)
        val titleMovie = intent.getStringExtra(TITLE_MOVIE)?:""

        binding.toolbar.apply {
            setSupportActionBar(this)
            title = titleMovie
            setNavigationOnClickListener { finish() }
        }

        MoviesRepository.getDetailPopularTvSeries(
            idMovie, {
                binding.progressbar.visibility = View.GONE

                Glide.with(binding.ivMovie.rootView)
                    .load("https://image.tmdb.org/t/p/w342${it.posterPath}")
                    .into(binding.ivMovie)

                binding.tvName.text = it.name
                binding.tvSeasons.text = it.numberOfSeasons.toString()
                binding.tvEpisode.text = it.numberOfEpisodes.toString()
                binding.tvTagline.text = it.tagline
                binding.tvStatus.text = it.status
                binding.tvDesc.text = it.overview
                binding.rbMovie.rating = it.voteAverage!!.toFloat()/2
            }, {
                binding.progressbar.visibility = View.GONE
                Toast.makeText(this@DetailTvSeriesActivity, "Error", Toast.LENGTH_SHORT).show()
            }
        )
    }
}