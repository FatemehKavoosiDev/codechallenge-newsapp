package com.example.codechallengenewsapp.data.datasource.local

import com.example.codechallengenewsapp.data.datasource.local.dao.NewsDao
import com.example.codechallengenewsapp.data.datasource.local.entity.NewsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class LocalDataSourceImpl @Inject constructor(private val newsDao: NewsDao) :
    LocalDataSource {
    override fun getAllNews(): Flow<List<NewsEntity>> =
        newsDao.getAllNews()

    override suspend fun insertNews(newsEntity: NewsEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllNews() {
        TODO("Not yet implemented")
    }

}