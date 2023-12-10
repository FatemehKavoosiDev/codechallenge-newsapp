package com.example.codechallengenewsapp.data.repository

import com.example.codechallengenewsapp.data.datasource.local.LocalDataSource
import com.example.codechallengenewsapp.data.datasource.local.entity.NewsEntity
import com.example.codechallengenewsapp.data.datasource.network.RemoteDataSource
import com.example.codechallengenewsapp.data.model.News
import com.example.codechallengenewsapp.data.model.mapToNews
import com.example.codechallengenewsapp.data.model.mapToNewsEntity
import com.example.codechallengenewsapp.utils.myLog
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class NewsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : NewsRepository {
    override fun getAllNews(): Flow<List<News>> = flow {
        refreshNews()
        emitAll(localDataSource.getAllNews().map { newsEntity ->
            newsEntity.map {
                it.mapToNews()
            }
        })
    }

    private suspend fun refreshNews() {
        try {
            val response = remoteDataSource.getAllNews()
            if (response.isSuccessful) {
                val listNewsEntity = response.body()!!.data.map { newsNetwork ->
                    newsNetwork.mapToNewsEntity()
                }
                updateLocalDataSource(listNewsEntity)
            }
        } catch (e: Exception) {
            myLog("error in refresh news $e")
        }
    }

    private suspend fun updateLocalDataSource(listNewsEntity: List<NewsEntity>) {
        localDataSource.deleteAllNews()
        localDataSource.insertNews(listNewsEntity)
    }

    override fun getNewsDetails(): Flow<News> {
        TODO("Not yet implemented")
    }

}