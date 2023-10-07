package com.example.wallpapersapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.wallpapersapp.repository.MainRepository

class PopularViewModel : ViewModel() {
    private val repository = MainRepository()
}