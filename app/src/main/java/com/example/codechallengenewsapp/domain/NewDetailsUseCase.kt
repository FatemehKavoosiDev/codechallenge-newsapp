package com.example.codechallengenewsapp.domain

import com.example.codechallengenewsapp.data.model.NewsDetails
import com.example.codechallengenewsapp.data.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class NewDetailsUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    operator fun invoke(id: Int): Flow<NewsDetails> = newsRepository.getNewsDetails(id)

}