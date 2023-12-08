package com.example.codechallengenewsapp.data.repository

import com.example.codechallengenewsapp.data.datasource.network.RemoteDataSource
import com.example.codechallengenewsapp.data.model.News
import kotlinx.coroutines.flow.Flow

internal class NewsRepositoryImpl(private val remoteDataSource: RemoteDataSource) : NewsRepository {
    override fun getAllNews(): Flow<News> {
        TODO("Not yet implemented")
    }

    override fun getNewsDetails(): Flow<News> {
        TODO("Not yet implemented")
    }

}