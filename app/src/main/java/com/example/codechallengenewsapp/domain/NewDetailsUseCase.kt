package com.example.codechallengenewsapp.domain

import com.example.codechallengenewsapp.data.model.NewsDetails
import com.example.codechallengenewsapp.data.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class NewDetailsUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    operator fun invoke(id: Int): Flow<NewsDetails> = flow {
        emitAll(newsRepository.getNewsDetails(id))
    }
}