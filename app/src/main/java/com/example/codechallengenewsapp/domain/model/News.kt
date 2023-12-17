package com.example.codechallengenewsapp.domain.model

internal data class News(
    val id: Int ,
    val author: String?,
    val title: String,
    val description: String?,
    val urlToImage: String?,
)