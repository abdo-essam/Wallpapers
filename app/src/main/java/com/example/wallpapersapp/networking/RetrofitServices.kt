package com.example.wallpapersapp.networking

import com.example.wallpapersapp.model.WallpapersResponse
import com.example.wallpapersapp.utils.Apikey
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RetrofitServices {
    @Headers("Authorization: " + Apikey.API_KEY)
    @GET("curated")
    suspend fun getHomeResponse(
        @Query("page") page: Int,
    ): WallpapersResponse


    @Headers("Authorization: " + Apikey.API_KEY)
    @GET("popular")
    suspend fun getPopularResponse(
        @Query("page") page: Int,
    ): WallpapersResponse

    @GET("category")
    suspend fun getCategoryResponse(
        @Query("page") page: Int?,
        @Query("category") category: String
    ): WallpapersResponse

//    @GET("search")
//    suspend fun getSearchResults(
//        @Query("query") query: String,
//        @Query("page") page: Int,
//    ): WallpapersResponse
}