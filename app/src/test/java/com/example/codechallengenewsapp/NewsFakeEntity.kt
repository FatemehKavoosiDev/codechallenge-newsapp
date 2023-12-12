package com.example.codechallengenewsapp

import com.example.codechallengenewsapp.data.datasource.local.entity.NewsEntity

internal object NewsFakeEntity {

    val list = listOf<NewsEntity>(
        NewsEntity(
            sourceId = "sourceId1", sourceName = "sourceName0",
            id = 0,
            author = "Fatemeh",
            title = "title news0",
            description = "description0",
            urlToImage = "https:/img0.jpg",
            url = "https:/img0.jpg",
            publishedAt = "2023-20-1",
            content = "content0",
        ),
        NewsEntity(
            sourceId = "sourceId1", sourceName = "sourceName0",
            id = 1,
            author = "Fatemeh",
            title = "title news1",
            description = "description1",
            urlToImage = "https:/img1.jpg",
            url = "https:/img0.jpg",
            publishedAt = "2023-20-1",
            content = "content0",
        ),
        NewsEntity(
            sourceId = "sourceId1", sourceName = "sourceName0",
            id = 2,
            author = "Fatemeh",
            title = "title news2",
            description = "description2",
            urlToImage = "https:/img2.jpg",
            url = "https:/img0.jpg",
            publishedAt = "2023-20-1",
            content = "content0",
        ),
        NewsEntity(
            sourceId = "sourceId1", sourceName = "sourceName0",
            id = 3,
            author = "Fatemeh",
            title = "title news3",
            description = "description3",
            urlToImage = "https:/img3.jpg",
            url = "https:/img0.jpg",
            publishedAt = "2023-20-1",
            content = "content0",
        ),
    )


}