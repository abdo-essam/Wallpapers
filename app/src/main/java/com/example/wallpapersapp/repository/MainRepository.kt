package com.example.wallpapersapp.repository

import com.example.wallpapersapp.networking.RetrofitApi
import com.example.wallpapersapp.networking.RetrofitServices


class MainRepository {
    fun retroService(): RetrofitServices = RetrofitApi.apiServices
}