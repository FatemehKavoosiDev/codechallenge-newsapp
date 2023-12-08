package com.example.codechallengenewsapp.data.datasource.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface NewsApiService {
    @GET("top-headlines")
    suspend fun getAllNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String,
    ): Response<BaseResponse<NewsNetwork>>
}