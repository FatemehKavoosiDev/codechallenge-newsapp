package com.example.codechallengenewsapp.data.model

internal data class News(
    val id: Int ,
    val author: String?,
    val title: String,
    val description: String?,
    val urlToImage: String?,
)