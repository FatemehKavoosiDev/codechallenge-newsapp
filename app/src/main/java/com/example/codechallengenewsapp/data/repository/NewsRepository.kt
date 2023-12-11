package com.example.codechallengenewsapp.data.repository

import com.example.codechallengenewsapp.data.model.News
import com.example.codechallengenewsapp.data.model.NewsDetails
import kotlinx.coroutines.flow.Flow

internal interface NewsRepository {
    fun getAllNews(): Flow<List<News>>
    fun getNewsDetails(id: Int): Flow<NewsDetails>
}