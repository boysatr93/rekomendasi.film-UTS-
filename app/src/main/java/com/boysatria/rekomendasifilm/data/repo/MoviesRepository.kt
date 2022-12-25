package com.boysatria.rekomendasifilm.data.repo

import android.util.Log
import com.boysatria.rekomendasifilm.data.apiservice.ApiService
import com.boysatria.rekomendasifilm.data.model.DetailMovieResponse
import com.boysatria.rekomendasifilm.data.model.DetailTvSeriesResponse
import com.boysatria.rekomendasifilm.data.model.MovieResponse
import com.boysatria.rekomendasifilm.data.model.TvSeriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MoviesRepository {

     private val api: ApiService

     init {
         val retrofit = Retrofit.Builder()
             .baseUrl("https://api.themoviedb.org/3/")
             .addConverterFactory(GsonConverterFactory.create())
             .build()

         api = retrofit.create(ApiService::class.java)
     }

    fun getPopularMovies(
        page: Int = 1,
        onSuccess: (movies: List<MovieResponse.Movie>) -> Unit,
        onError: () -> Unit
    ) {
        api.getPopularMovies(page = page)
            .enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.movies)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

    fun getDetailPopularMovies(
        id: Int = 0,
        onSuccess: (movies: DetailMovieResponse) -> Unit,
        onError: () -> Unit
    ) {
        api.getDetailPopularMovies(id = id)
            .enqueue(object : Callback<DetailMovieResponse> {
                override fun onResponse(
                    call: Call<DetailMovieResponse>,
                    response: Response<DetailMovieResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

    fun getPopularTvSeries(
        page: Int = 1,
        onSuccess: (movies: List<TvSeriesResponse.Movie>) -> Unit,
        onError: () -> Unit
    ) {
        api.getPopularTvSeries(page = page)
            .enqueue(object : Callback<TvSeriesResponse> {
                override fun onResponse(
                    call: Call<TvSeriesResponse>,
                    response: Response<TvSeriesResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.movies)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<TvSeriesResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

    fun getDetailPopularTvSeries(
        id: Int = 0,
        onSuccess: (movies: DetailTvSeriesResponse) -> Unit,
        onError: () -> Unit
    ) {
        api.getDetailPopularTvSeries(id = id)
            .enqueue(object : Callback<DetailTvSeriesResponse> {
                override fun onResponse(
                    call: Call<DetailTvSeriesResponse>,
                    response: Response<DetailTvSeriesResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<DetailTvSeriesResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }
 }