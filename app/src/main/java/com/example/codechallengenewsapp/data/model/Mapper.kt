package com.example.codechallengenewsapp.data.model

import com.example.codechallengenewsapp.data.datasource.local.entity.NewsEntity
import com.example.codechallengenewsapp.data.datasource.network.models.NewsNetwork

internal fun NewsNetwork.mapToNews() = News(
    source = Source(this.source.id, this.source.name),
    author = this.author,
    title = this.title,
    description = this.description,
    url = this.url,
    urlToImage = this.urlToImage,
    publishedAt = this.publishedAt,
    content = this.content,
)

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
    source = Source(this.sourceId, this.sourceName),
    author = this.author,
    title = this.title,
    description = this.description,
    url = this.url,
    urlToImage = this.urlToImage,
    publishedAt = this.publishedAt,
    content = this.content,
)