package com.example.wallpapersapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.wallpapersapp.paging.PopularPagingSource
import com.example.wallpapersapp.repository.MainRepository

class PopularViewModel:ViewModel() {

    private val repository=MainRepository()
    val popularPage= Pager(config = PagingConfig(pageSize = 40),
        pagingSourceFactory = {
            PopularPagingSource(repository.retroService())
        }).flow.cachedIn(viewModelScope)
}