package com.example.codechallengenewsapp.data.model

import com.example.codechallengenewsapp.data.datasource.network.models.NewsNetwork

internal fun NewsNetwork.mapToNews() = News(
    source = this.source,
    author = this.author,
    title = this.title,
    description = this.description,
    url = this.url,
    urlToImage = this.urlToImage,
    publishedAt = this.publishedAt,
    content = this.content,
)