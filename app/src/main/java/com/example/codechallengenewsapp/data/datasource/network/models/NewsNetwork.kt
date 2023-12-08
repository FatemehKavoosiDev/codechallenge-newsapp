package com.example.codechallengenewsapp.data.datasource.network.models

import com.google.gson.annotations.SerializedName

internal data class NewsNetwork(
    @SerializedName("source") val source: Source,
    @SerializedName("author") val author: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("url") val url: String,
    @SerializedName("urlToImage") val urlToImage: String,
    @SerializedName("publishedAt") val publishedAt: String,
    @SerializedName("content") val content: String,
)

internal data class Source(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
)