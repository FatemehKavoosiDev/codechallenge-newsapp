package com.example.codechallengenewsapp.domain

import com.example.codechallengenewsapp.domain.model.News
import com.example.codechallengenewsapp.data.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class NewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    operator fun invoke(): Flow<List<News>> = newsRepository.getAllNews()
}