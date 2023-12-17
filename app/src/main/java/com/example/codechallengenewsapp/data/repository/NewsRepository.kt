package com.example.codechallengenewsapp.data.repository

import com.example.codechallengenewsapp.domain.model.News
import com.example.codechallengenewsapp.domain.model.NewsDetails
import kotlinx.coroutines.flow.Flow

internal interface NewsRepository {
    fun getAllNews(): Flow<List<News>>
    fun getNewsDetails(id: Int): Flow<NewsDetails>
}