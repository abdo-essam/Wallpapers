package com.example.wallpapersapp.viewmodel

import com.example.wallpapersapp.model.Photo
import com.example.wallpapersapp.paging.CategoryPagingSource
import com.example.wallpapersapp.repository.MainRepository

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CategoriesViewModel constructor(private var categoryID: String) : ViewModel() {
    private val repository = MainRepository()

    var data: MutableLiveData<PagingData<Photo>> = MutableLiveData()

    init {
        viewModelScope.launch {
            loadCategoryToRandom(categoryID).collect {
                data.postValue(it)
            }
        }
    }

    private fun loadCategoryToRandom(category: String): Flow<PagingData<Photo>> {

        return Pager(config = PagingConfig(pageSize = 30),
            pagingSourceFactory = { CategoryPagingSource(repository.retroService(), category) }
        ).flow.cachedIn(viewModelScope)
    }

}