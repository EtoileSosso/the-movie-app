package com.gmail.eamosse.idbdata.data

data class Movie(
    val adult: Boolean,
    val backdropPath: String?,
    val genres: List<Int>,
    val id: Int,
    val overview: String,
    val originalLanguage: String,
    val originalTitle: String,
    val popularity: Double,
    val posterPath: String?,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)

data class MovieDetail(
    val adult: Boolean,
    val backdropPath: String,
    val budget: Int,
    val genres: List<Category>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val overview: String,
    val originalLanguage: String,
    val originalTitle: String,
    val popularity: Double,
    val posterPath: String?,
    val productionCompanies: List<ProductionCompany>,
    val productionCountries: List<ProductionCountry>,
    val releaseDate: String,
    val revenue: Int,
    val runTime: Int,
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagLine: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)

data class ProductionCompany(
    val id: Int,
    val logoPath: String,
    val name: String,
    val originCountry: String
)

data class ProductionCountry(
    val iso: String,
    val name: String
)

data class SpokenLanguage(
    val iso: String,
    val name: String
)