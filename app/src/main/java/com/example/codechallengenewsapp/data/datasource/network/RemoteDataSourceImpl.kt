package com.example.codechallengenewsapp.data.datasource.network

import com.example.codechallengenewsapp.data.datasource.network.models.BaseResponse
import com.example.codechallengenewsapp.data.datasource.network.models.NewsNetwork
import retrofit2.Response
import javax.inject.Inject

internal class RemoteDataSourceImpl @Inject constructor(private val apiService: NewsApiService) :
    RemoteDataSource {

    companion object {
        const val COUNTRY: String = "us"
        const val CATEGORY: String = "business"
    }

    override suspend fun getAllNews(): Response<BaseResponse<NewsNetwork>> =
        apiService.getAllNews(country = COUNTRY, category = CATEGORY)
}