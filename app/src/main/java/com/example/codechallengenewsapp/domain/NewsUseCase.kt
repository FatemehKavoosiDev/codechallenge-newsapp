package com.example.codechallengenewsapp.domain

import com.example.codechallengenewsapp.data.model.News
import com.example.codechallengenewsapp.data.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class NewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {
    operator fun invoke(): Flow<List<News>> = flow {
        emitAll(newsRepository.getAllNews())
    }
}