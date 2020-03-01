package com.gmail.eamosse.idbdata.api.response

import com.gmail.eamosse.idbdata.data.*
import com.google.gson.annotations.SerializedName

internal data class DetailMovieResponse(
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    val budget: Int,
    val genres: List<Category>,
    val homepage: String,
    val id: Int,
    @SerializedName("genre_ids")
    val genresId: List<Int>,
    @SerializedName("imdb_id")
    val imdbId: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry>,
    @SerializedName("release_date")
    val releaseDate: String,
    val revenue: Int,
    val runTime: Int,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    @SerializedName("tagline")
    val tagLine: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
) {
    data class ProductionCompany(
        val id: Int,
        @SerializedName("logo_path")
        val logoPath: String,
        val name: String,
        @SerializedName("origin_country")
        val originCountry: String
    )

    data class ProductionCountry(
        @SerializedName("iso_3166_1")
        val iso: String,
        val name: String
    )

    data class SpokenLanguage(
        @SerializedName("iso_639_1")
        val iso: String,
        val name: String
    )
}

internal fun DetailMovieResponse.ProductionCountry.toCountry() = ProductionCountry(
    iso = iso,
    name = name
)

internal fun DetailMovieResponse.ProductionCompany.toCompany() = ProductionCompany(
    id = id, logoPath = logoPath, name = name, originCountry = originCountry
)

internal fun DetailMovieResponse.SpokenLanguage.toSpokenLanguage() =
    SpokenLanguage(iso = iso, name = name)

internal fun DetailMovieResponse.toDetailMovie() = MovieDetail(
    id = id,
    adult = adult,
    backdropPath = backdropPath,
    budget = budget,
    genres = genres,
    homepage = homepage,
    imdbId = imdbId,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    productionCompanies = productionCompanies.map { it.toCompany() },
    productionCountries = productionCountries.map { it.toCountry() },
    releaseDate = releaseDate,
    revenue = revenue,
    runTime = runTime,
    spokenLanguages = spokenLanguages.map { it.toSpokenLanguage() },
    status = status,
    tagLine = tagLine,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)