package com.gmail.eamosse.idbdata.api.response

import com.gmail.eamosse.idbdata.data.*
import com.google.gson.annotations.SerializedName

internal data class MovieResponse(
    val page: Int,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("results")
    val movies: List<Movie>
) {
    data class Movie(
        val adult: Boolean,
        @SerializedName("backdrop_path")
        val backdropPath: String?,
        val id: Int,
        @SerializedName("genre_ids")
        val genresId: List<Int>,
        @SerializedName("original_language")
        val originalLanguage: String,
        @SerializedName("original_title")
        val originalTitle: String,
        val overview: String,
        val popularity: Double,
        @SerializedName("poster_path")
        val posterPath: String?,
        @SerializedName("release_date")
        val releaseDate: String,
        val title: String,
        val video: Boolean,
        @SerializedName("vote_average")
        val voteAverage: Double,
        @SerializedName("vote_count")
        val voteCount: Int
    )
}

internal fun MovieResponse.Movie.toMovie() = Movie(
    id = id,
    adult = adult,
    backdropPath = backdropPath,
    genres = genresId,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)