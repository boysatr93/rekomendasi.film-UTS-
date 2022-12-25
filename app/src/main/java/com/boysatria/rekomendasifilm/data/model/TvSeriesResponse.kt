package com.boysatria.rekomendasifilm.data.model

import com.google.gson.annotations.SerializedName

data class TvSeriesResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<Movie>,
    @SerializedName("total_pages") val pages: Int
) {
    data class Movie(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("overview") val overview: String,
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("backdrop_path") val backdropPath: String,
        @SerializedName("vote_average") val rating: Float,
        @SerializedName("release_date") val releaseDate: String
    )
}
