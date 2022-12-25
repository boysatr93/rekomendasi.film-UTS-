package com.boysatria.rekomendasifilm.ui.tv_series

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.boysatria.rekomendasifilm.data.model.MovieResponse
import com.boysatria.rekomendasifilm.data.model.TvSeriesResponse
import com.boysatria.rekomendasifilm.data.repo.MoviesRepository
import com.boysatria.rekomendasifilm.databinding.FragmentTvSeriesBinding
import com.boysatria.rekomendasifilm.ui.movies.MoviesAdapter

class TvSeriesFragment : Fragment() {

    private lateinit var binding : FragmentTvSeriesBinding
    private lateinit var tvSeriesAdapter: TvSeriesAdapter
    private lateinit var lyManager: GridLayoutManager

    private var popularMoviesPage = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvSeriesBinding.inflate(inflater, container, false)
        lyManager = GridLayoutManager(requireContext(), 2)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareRecyclerView()
        getPopularMovies()
    }

    private fun prepareRecyclerView() {
        tvSeriesAdapter = TvSeriesAdapter(requireContext())
        binding.rvTvSeries.apply {
            layoutManager = lyManager
            adapter = tvSeriesAdapter
        }
    }

    private fun getPopularMovies() {
        MoviesRepository.getPopularTvSeries(
            popularMoviesPage,
            ::onPopularMoviesFetched,
            ::onError
        )
    }

    private fun onPopularMoviesFetched(movies: List<TvSeriesResponse.Movie>) {
        binding.progressbar.visibility = View.GONE
        tvSeriesAdapter.appendMovies(movies)
        attachPopularMoviesOnScrollListener()
    }

    private fun attachPopularMoviesOnScrollListener() {
        binding.rvTvSeries.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = lyManager.itemCount
                val visibleItemCount = lyManager.childCount
                val firstVisibleItem = lyManager.findFirstVisibleItemPosition()

                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    binding.rvTvSeries.removeOnScrollListener(this)
                    popularMoviesPage++
                    getPopularMovies()
                }
            }
        })
    }

    private fun onError() {
        binding.progressbar.visibility = View.GONE
        Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
    }
}