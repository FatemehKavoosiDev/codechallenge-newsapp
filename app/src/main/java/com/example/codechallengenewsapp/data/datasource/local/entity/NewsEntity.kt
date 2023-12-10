package com.example.codechallengenewsapp.data.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewsEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "source_id") val sourceId: String?,
    @ColumnInfo(name = "source_name") val sourceName: String,
    @ColumnInfo(name = "author") val author: String?,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "url_to_image") val urlToImage: String?,
    @ColumnInfo(name = "published_at") val publishedAt: String,
    @ColumnInfo(name = "content") val content: String?,
)
