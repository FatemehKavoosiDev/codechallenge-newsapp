package com.example.codechallengenewsapp.data.model


internal data class NewsDetails(
    val id: Int,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?,
)