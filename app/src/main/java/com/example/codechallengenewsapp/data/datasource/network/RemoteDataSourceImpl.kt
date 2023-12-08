package com.example.codechallengenewsapp.data.datasource.network

import com.example.codechallengenewsapp.data.datasource.network.models.BaseResponse
import com.example.codechallengenewsapp.data.datasource.network.models.NewsNetwork
import retrofit2.Response

internal class RemoteDataSourceImpl : RemoteDataSource {
    override suspend fun getAllNews(): Response<BaseResponse<NewsNetwork>> {
        TODO("Not yet implemented")
    }

}