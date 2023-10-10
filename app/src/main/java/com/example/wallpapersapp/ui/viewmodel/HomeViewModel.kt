package com.example.wallpapersapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.wallpapersapp.paging.HomePagingSource
import com.example.wallpapersapp.repository.MainRepository


class HomeViewModel: ViewModel() {
    private val repository = MainRepository()

    val homePage = Pager(config = PagingConfig(pageSize = 40),
        pagingSourceFactory = {
            HomePagingSource(repository.retroService())
        }).flow.cachedIn(viewModelScope)
}