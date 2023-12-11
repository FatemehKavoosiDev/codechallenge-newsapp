package com.example.codechallengenewsapp.data.model

import com.example.codechallengenewsapp.data.datasource.local.entity.NewsEntity
import com.example.codechallengenewsapp.data.datasource.network.models.NewsNetwork

internal fun NewsNetwork.mapToNewsEntity() = NewsEntity(
    sourceId = this.source.id,
    sourceName = this.source.name,
    author = this.author,
    title = this.title,
    description = this.description,
    url = this.url,
    urlToImage = this.urlToImage,
    publishedAt = this.publishedAt,
    content = this.content,
)

internal fun NewsEntity.mapToNews() = News(
    id = this.id,
    author = this.author,
    title = this.title,
    description = this.description,
    urlToImage = this.urlToImage,
)

internal fun NewsEntity.mapToNewsDetails() = NewsDetails(
    id = this.id,
    author = this.author,
    title = this.title,
    description = this.description,
    url = this.url,
    urlToImage = this.urlToImage,
    publishedAt = this.publishedAt,
    content = this.content,
)