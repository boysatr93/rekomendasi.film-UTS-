package com.boysatria.rekomendasifilm.ui.tv_series

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.boysatria.rekomendasifilm.data.model.MovieResponse
import com.boysatria.rekomendasifilm.data.model.TvSeriesResponse
import com.boysatria.rekomendasifilm.databinding.ItemMovieBinding
import com.boysatria.rekomendasifilm.ui.movies.DetailMovieActivity
import com.bumptech.glide.Glide

class TvSeriesAdapter(val context: Context) : RecyclerView.Adapter<TvSeriesAdapter.ViewHolder>() {
    private var movieList = ArrayList<TvSeriesResponse.Movie>()
    fun setMovieList(movieList: List<TvSeriesResponse.Movie>) {
        this.movieList = movieList as ArrayList<TvSeriesResponse.Movie>
        notifyDataSetChanged()
    }

    fun appendMovies(movies: List<TvSeriesResponse.Movie>) {
        this.movieList.addAll(movies)
        notifyItemRangeInserted(
            this.movieList.size,
            movies.size - 1
        )
    }

    class ViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w342${movieList[position].posterPath}")
            .into(holder.binding.ivMovie)
        holder.binding.tvName.text = movieList[position].name
        holder.binding.rbMovie.rating = movieList[position].rating/2

        holder.binding.root.setOnClickListener {
            context.startActivity(Intent(context, DetailTvSeriesActivity::class.java).apply {
                putExtra(DetailTvSeriesActivity.TITLE_MOVIE, movieList[position].name)
                putExtra(DetailTvSeriesActivity.ID_MOVIE, movieList[position].id)
            })
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}