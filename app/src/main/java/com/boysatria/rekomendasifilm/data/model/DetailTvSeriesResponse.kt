package com.boysatria.rekomendasifilm.data.model


import com.google.gson.annotations.SerializedName

data class DetailTvSeriesResponse(
    @SerializedName("backdrop_path")
    var backdropPath: String?,
    @SerializedName("created_by")
    var createdBy: List<CreatedBy?>?,
    @SerializedName("episode_run_time")
    var episodeRunTime: List<Int?>?,
    @SerializedName("first_air_date")
    var firstAirDate: String?,
    @SerializedName("genres")
    var genres: List<Genre?>?,
    @SerializedName("homepage")
    var homepage: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("in_production")
    var inProduction: Boolean?,
    @SerializedName("languages")
    var languages: List<String?>?,
    @SerializedName("last_air_date")
    var lastAirDate: String?,
    @SerializedName("last_episode_to_air")
    var lastEpisodeToAir: LastEpisodeToAir?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("networks")
    var networks: List<Network?>?,
    @SerializedName("next_episode_to_air")
    var nextEpisodeToAir: Any?,
    @SerializedName("number_of_episodes")
    var numberOfEpisodes: Int?,
    @SerializedName("number_of_seasons")
    var numberOfSeasons: Int?,
    @SerializedName("origin_country")
    var originCountry: List<String?>?,
    @SerializedName("original_language")
    var originalLanguage: String?,
    @SerializedName("original_name")
    var originalName: String?,
    @SerializedName("overview")
    var overview: String?,
    @SerializedName("popularity")
    var popularity: Double?,
    @SerializedName("poster_path")
    var posterPath: String?,
    @SerializedName("production_companies")
    var productionCompanies: List<ProductionCompany?>?,
    @SerializedName("production_countries")
    var productionCountries: List<ProductionCountry?>?,
    @SerializedName("seasons")
    var seasons: List<Season?>?,
    @SerializedName("spoken_languages")
    var spokenLanguages: List<SpokenLanguage?>?,
    @SerializedName("status")
    var status: String?,
    @SerializedName("tagline")
    var tagline: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("vote_average")
    var voteAverage: Double?,
    @SerializedName("vote_count")
    var voteCount: Int?
) {
    data class CreatedBy(
        @SerializedName("credit_id")
        var creditId: String?,
        @SerializedName("gender")
        var gender: Int?,
        @SerializedName("id")
        var id: Int?,
        @SerializedName("name")
        var name: String?,
        @SerializedName("profile_path")
        var profilePath: String?
    )

    data class Genre(
        @SerializedName("id")
        var id: Int?,
        @SerializedName("name")
        var name: String?
    )

    data class LastEpisodeToAir(
        @SerializedName("air_date")
        var airDate: String?,
        @SerializedName("episode_number")
        var episodeNumber: Int?,
        @SerializedName("id")
        var id: Int?,
        @SerializedName("name")
        var name: String?,
        @SerializedName("overview")
        var overview: String?,
        @SerializedName("production_code")
        var productionCode: String?,
        @SerializedName("season_number")
        var seasonNumber: Int?,
        @SerializedName("still_path")
        var stillPath: String?,
        @SerializedName("vote_average")
        var voteAverage: Double?,
        @SerializedName("vote_count")
        var voteCount: Int?
    )

    data class Network(
        @SerializedName("id")
        var id: Int?,
        @SerializedName("logo_path")
        var logoPath: String?,
        @SerializedName("name")
        var name: String?,
        @SerializedName("origin_country")
        var originCountry: String?
    )

    data class ProductionCompany(
        @SerializedName("id")
        var id: Int?,
        @SerializedName("logo_path")
        var logoPath: String?,
        @SerializedName("name")
        var name: String?,
        @SerializedName("origin_country")
        var originCountry: String?
    )

    data class ProductionCountry(
        @SerializedName("iso_3166_1")
        var iso31661: String?,
        @SerializedName("name")
        var name: String?
    )

    data class Season(
        @SerializedName("air_date")
        var airDate: String?,
        @SerializedName("episode_count")
        var episodeCount: Int?,
        @SerializedName("id")
        var id: Int?,
        @SerializedName("name")
        var name: String?,
        @SerializedName("overview")
        var overview: String?,
        @SerializedName("poster_path")
        var posterPath: String?,
        @SerializedName("season_number")
        var seasonNumber: Int?
    )

    data class SpokenLanguage(
        @SerializedName("english_name")
        var englishName: String?,
        @SerializedName("iso_639_1")
        var iso6391: String?,
        @SerializedName("name")
        var name: String?
    )
}