package com.example.codechallengenewsapp.data.datasource.local

import com.example.codechallengenewsapp.data.datasource.local.entity.NewsEntity
import kotlinx.coroutines.flow.Flow

internal interface LocalDataSource {
    fun getAllNews(): Flow<List<NewsEntity>>
    suspend fun insertNews(newsEntity: NewsEntity)
    suspend fun deleteAllNews()
}