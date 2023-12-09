package com.example.codechallengenewsapp.data.datasource.network

import com.example.codechallengenewsapp.data.datasource.network.models.BaseResponse
import com.example.codechallengenewsapp.data.datasource.network.models.NewsNetwork
import com.example.codechallengenewsapp.utils.Const
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface NewsApiService {
    @GET("top-headlines")
    suspend fun getAllNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String = Const.API_KEY,
    ): Response<BaseResponse<NewsNetwork>>
}