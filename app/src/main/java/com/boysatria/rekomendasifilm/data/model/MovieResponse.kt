package com.boysatria.rekomendasifilm.data.model
//data model Response Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<Movie>,
    @SerializedName("total_pages") val pages: Int
) {
    data class Movie(
        @SerializedName("id") val id: Int,
        @SerializedName("title") val title: String,
        @SerializedName("overview") val overview: String,
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("backdrop_path") val backdropPath: String,
        @SerializedName("vote_average") val rating: Float,
        @SerializedName("release_date") val releaseDate: String
    )
}
