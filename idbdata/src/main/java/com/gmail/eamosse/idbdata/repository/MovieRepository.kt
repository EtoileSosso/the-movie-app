package com.gmail.eamosse.idbdata.repository

import com.gmail.eamosse.idbdata.api.response.*
import com.gmail.eamosse.idbdata.api.response.toCategory
import com.gmail.eamosse.idbdata.api.response.toEntity
import com.gmail.eamosse.idbdata.api.response.toToken
import com.gmail.eamosse.idbdata.data.*
import com.gmail.eamosse.idbdata.datasources.LocalDataSource
import com.gmail.eamosse.idbdata.datasources.OnlineDataSource
import com.gmail.eamosse.idbdata.utils.Result
import org.koin.core.KoinComponent
import org.koin.core.inject

class MovieRepository : KoinComponent {
    private val local: LocalDataSource by inject()
    private val online: OnlineDataSource by inject()

    suspend fun getToken(): Result<Token> {
        return when (val result = online.getToken()) {
            is Result.Success -> {
                local.saveToken(result.data.toEntity())
                Result.Success(result.data.toToken())
            }
            is Result.Error -> result
        }
    }

    suspend fun getCategories(): Result<List<Category>> {
        return when (val result = online.getCategories()) {
            is Result.Success -> {
                val categories = result.data.map {
                    it.toCategory()
                }
                Result.Success(categories)
            }
            is Result.Error -> result
        }
    }

    suspend fun getMovies(category: Int): Result<List<Movie>> {
        return when (val result = online.getMovies(category)) {
            is Result.Success -> {
                val movies = result.data.map { it.toMovie() }
                Result.Success(movies)
            }
            is Result.Error -> result
        }
    }

    suspend fun getMovie(id: Int): Result<MovieDetail> {
        return when (val result = online.getMovie(id)) {
            is Result.Success -> {
                val movie = result.data.toDetailMovie()
                Result.Success(movie)
            }
            is Result.Error -> result
        }
    }

    suspend fun getTrendingMovies(): Result<List<Trending>> {
        return when (val result = online.getTrendingMovies()) {
            is Result.Success -> {
                val trendingMovies = result.data.map {
                    it.toTrending()
                }
                Result.Success(trendingMovies)
            }
            is Result.Error -> result
        }
    }

    suspend fun getTrendingPeople(): Result<List<TrendingPerson>> {
        return when (val result = online.getTrendingPerson()) {
            is Result.Success -> {
                val trendingPeople = result.data.map {
                    it.toPerson()
                }
                Result.Success(trendingPeople)
            }
            is Result.Error -> result
        }
    }

    suspend fun getTrendingCategories(): Result<List<Category>> {
        return when (val result = online.getCategories()) {
            is Result.Success -> {
                val trendingCategories = result.data.map {
                    it.toCategory()
                }
                Result.Success(trendingCategories)
            }
            is Result.Error -> result
        }
    }

    // TODO
    /* suspend fun getSimilarMovies(id: Int): Result<List<Movie>> {

    } */
}