package com.example.wallpapersapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.wallpapersapp.repository.MainRepository


class HomeViewModel: ViewModel() {
    private val repository = MainRepository()

}