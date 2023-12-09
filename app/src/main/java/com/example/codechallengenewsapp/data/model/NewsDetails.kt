package com.example.codechallengenewsapp.data.model

import com.example.codechallengenewsapp.data.datasource.network.models.Source

internal data class NewsDetails(
    var source: Source,
    var author: String,
    var title: String,
    var description: String,
    var url: String,
    var urlToImage: String,
    var publishedAt: String,
    var content: String,
)