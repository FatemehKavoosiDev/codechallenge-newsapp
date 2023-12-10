package com.example.codechallengenewsapp.data.model

internal data class News(
    val source: Source,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?,
)
internal data class Source(
    val id: String?,
    val name: String,
)