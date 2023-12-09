package com.example.codechallengenewsapp.data.model

import com.example.codechallengenewsapp.data.datasource.network.models.Source

internal data class NewsDetails(
    val source: Source,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?,
)