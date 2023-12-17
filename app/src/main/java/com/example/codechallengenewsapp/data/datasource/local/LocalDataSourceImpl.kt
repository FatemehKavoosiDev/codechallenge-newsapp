package com.example.codechallengenewsapp.data.datasource.local

import com.example.codechallengenewsapp.data.datasource.local.dao.NewsDao
import com.example.codechallengenewsapp.data.datasource.local.entity.NewsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class LocalDataSourceImpl @Inject constructor(private val newsDao: NewsDao) :
    LocalDataSource {
    override fun getAllNews(): Flow<List<NewsEntity>> =
        newsDao.getAllNews()

    override fun getNewsDetails(id: Int): Flow<NewsEntity> =
        newsDao.getNewsDetails(id)

    override suspend fun insertNews(newsEntity: List<NewsEntity>) {
        newsDao.insertNews(newsEntity)
    }

    override suspend fun deleteAllNews() {
        newsDao.deleteAllNews()
    }

    override suspend fun deleteAndInsert(listNewsEntity: List<NewsEntity>) {
        newsDao.deleteAndInsertInTransaction(listNewsEntity)
    }

}