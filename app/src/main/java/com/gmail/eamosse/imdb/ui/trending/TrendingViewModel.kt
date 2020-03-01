package com.gmail.eamosse.imdb.ui.trending

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmail.eamosse.idbdata.data.Category
import com.gmail.eamosse.idbdata.data.TrendingPerson
import com.gmail.eamosse.idbdata.data.Trending
import com.gmail.eamosse.idbdata.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.gmail.eamosse.idbdata.utils.Result


class TrendingViewModel(private val repository: MovieRepository) : ViewModel() {
    private val _categories: MutableLiveData<List<Category>> = MutableLiveData()
    val categories: LiveData<List<Category>>
        get() = _categories

    private val _trending: MutableLiveData<List<Trending>> = MutableLiveData()
    val trending: LiveData<List<Trending>>
        get() = _trending

    private val _people: MutableLiveData<List<TrendingPerson>> = MutableLiveData()
    val people: LiveData<List<TrendingPerson>>
        get() = _people


    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String>
        get() = _error


    fun loadTrendingMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getTrendingMovies()) {
                is Result.Success -> {
                    _trending.postValue(result.data)
                }
                is Result.Error -> {
                    _error.postValue(result.message)
                }
            }
        }
    }

    fun loadTrendingPeople() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getTrendingPeople()) {
                is Result.Success -> {
                    _people.postValue(result.data)
                }
                is Result.Error -> {
                    _error.postValue(result.message)
                }
            }
        }
    }

    fun loadTrendingCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getTrendingCategories()) {
                is Result.Success -> {
                    _categories.postValue(result.data)
                }
                is Result.Error -> {
                    _error.postValue(result.message)
                }
            }
        }
    }
}