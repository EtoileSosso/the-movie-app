package com.gmail.eamosse.idbdata.api.response

import com.gmail.eamosse.idbdata.data.Trending
import com.google.gson.annotations.SerializedName

internal data class TrendingMovieResponse(
    val page: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("results")
    val trendingMovies: List<Trending>
) {
    data class Trending(
        val adult: Boolean,
        val backdrop_path: String,
        val genre_ids: List<Int>,
        val id: Int,
        val media_type: String,
        val original_language: String,
        val original_title: String,
        val overview: String,
        val popularity: Double,
        val poster_path: String,
        val release_date: String,
        val title: String,
        val video: Boolean,
        val vote_average: Double,
        val vote_count: Int
    )
}

internal fun TrendingMovieResponse.Trending.toTrending() = Trending(
    adult = adult,
    backdrop_path = backdrop_path,
    genre_ids = genre_ids,
    id = id,
    media_type = media_type,
    original_language = original_language,
    original_title = original_title,
    overview = overview,
    popularity = popularity,
    poster_path = poster_path,
    release_date = release_date,
    title = title,
    video = video,
    vote_average = vote_average,
    vote_count = vote_count
)