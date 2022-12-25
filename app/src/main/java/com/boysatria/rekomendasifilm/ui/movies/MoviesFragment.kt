package com.boysatria.rekomendasifilm.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.boysatria.rekomendasifilm.data.model.MovieResponse
import com.boysatria.rekomendasifilm.data.repo.MoviesRepository
import com.boysatria.rekomendasifilm.databinding.FragmentMoviesBinding

class MoviesFragment : Fragment() {

    private lateinit var binding : FragmentMoviesBinding
    private lateinit var moviesAdapter : MoviesAdapter
    private lateinit var lyManager: GridLayoutManager
    private var popularMoviesPage = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        lyManager = GridLayoutManager(requireContext(), 2)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareRecyclerView()
        getPopularMovies()
    }

    private fun prepareRecyclerView() {
        moviesAdapter = MoviesAdapter(requireContext())
        binding.rvMovies.apply {
            layoutManager = lyManager
            adapter = moviesAdapter
        }
    }

    private fun getPopularMovies() {
        MoviesRepository.getPopularMovies(
            popularMoviesPage,
            ::onPopularMoviesFetched,
            ::onError
        )
    }

    private fun onPopularMoviesFetched(movies: List<MovieResponse.Movie>) {
        binding.progressbar.visibility = View.GONE
        moviesAdapter.appendMovies(movies)
        attachPopularMoviesOnScrollListener()
    }

    private fun attachPopularMoviesOnScrollListener() {
        binding.rvMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = lyManager.itemCount
                val visibleItemCount = lyManager.childCount
                val firstVisibleItem = lyManager.findFirstVisibleItemPosition()

                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    binding.rvMovies.removeOnScrollListener(this)
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