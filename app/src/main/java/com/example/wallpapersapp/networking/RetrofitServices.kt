package com.example.wallpapersapp.networking

import com.example.wallpapersapp.model.Wallpaper
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {

    @GET("curated")
    suspend fun getHomeResponse(
        @Query("page") page: Int,

        ): Wallpaper

    @GET("popular")
    suspend fun getPopularResponse(
        @Query("page") page: Int,

        ): Wallpaper

    @GET("search?query=nature")
    suspend fun getMiscellaneousResponse(
        @Query("page") page: Int,

        ): Wallpaper

//    @GET("search")
//    suspend fun getSearchResults(
//        @Query("query") query: String,
//        @Query("page") page: Int,
//    ): Wallpaper
}