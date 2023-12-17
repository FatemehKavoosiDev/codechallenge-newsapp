package com.example.codechallengenewsapp

import com.example.codechallengenewsapp.domain.model.News

internal object NewsFake {

    val newsList = listOf<News>(
        News(
            id = 0,
            author = "Fatemeh",
            title = "title news0",
            description = "description0",
            urlToImage = "https:/img0.jpg"
        ),
        News(
            id = 1,
            author = "Fatemeh",
            title = "title news1",
            description = "description1",
            urlToImage = "https:/img1.jpg"
        ),
        News(
            id = 2,
            author = "Fatemeh",
            title = "title news2",
            description = "description2",
            urlToImage = "https:/img2.jpg"
        ),
        News(
            id = 3,
            author = "Fatemeh",
            title = "title news3",
            description = "description3",
            urlToImage = "https:/img3.jpg"
        ),
    )


}