package com.boysatria.rekomendasifilm.ui.movies

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.boysatria.rekomendasifilm.data.model.MovieResponse
import com.boysatria.rekomendasifilm.databinding.ItemMovieBinding
import com.bumptech.glide.Glide

//adapter rekomendasi Film

class MoviesAdapter(val context: Context) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    private var movieList = ArrayList<MovieResponse.Movie>()
    fun setMovieList(movieList: List<MovieResponse.Movie>) {
        this.movieList = movieList as ArrayList<MovieResponse.Movie>
        notifyDataSetChanged()
    }

    fun appendMovies(movies: List<MovieResponse.Movie>) {
        this.movieList.addAll(movies)
        notifyItemRangeInserted(
            this.movieList.size,
            movies.size - 1
        )
    }

//Class Viewholder

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
        holder.binding.tvName.text = movieList[position].title
        holder.binding.rbMovie.rating = movieList[position].rating/2

//viewholder untuk keterangan judul dan rating

        holder.binding.root.setOnClickListener {
            context.startActivity(Intent(context, DetailMovieActivity::class.java).apply {
                putExtra(DetailMovieActivity.TITLE_MOVIE, movieList[position].title)
                putExtra(DetailMovieActivity.ID_MOVIE, movieList[position].id)
            })
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}