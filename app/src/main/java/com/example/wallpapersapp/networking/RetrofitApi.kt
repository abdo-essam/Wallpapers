package com.example.wallpapersapp.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {

    private const val BASE_URL = "https://api.pexels.com/v1/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiServices: RetrofitServices = retrofit.create(RetrofitServices::class.java)
}