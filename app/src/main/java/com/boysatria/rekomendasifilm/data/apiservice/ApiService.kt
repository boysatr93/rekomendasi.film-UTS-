package com.boysatria.rekomendasifilm.data.apiservice

import com.boysatria.rekomendasifilm.data.model.DetailMovieResponse
import com.boysatria.rekomendasifilm.data.model.DetailTvSeriesResponse
import com.boysatria.rekomendasifilm.data.model.MovieResponse
import com.boysatria.rekomendasifilm.data.model.TvSeriesResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = "69d66957eebff9666ea46bd464773cf0",
        @Query("page") page: Int
    ): Call<MovieResponse>

    @GET("movie/{id}")
    fun getDetailPopularMovies(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = "69d66957eebff9666ea46bd464773cf0"
    ): Call<DetailMovieResponse>

    @GET("tv/popular")
    fun getPopularTvSeries(
        @Query("api_key") apiKey: String = "69d66957eebff9666ea46bd464773cf0",
        @Query("page") page: Int
    ): Call<TvSeriesResponse>

    @GET("tv/{id}")
    fun getDetailPopularTvSeries(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = "69d66957eebff9666ea46bd464773cf0"
    ): Call<DetailTvSeriesResponse>
}