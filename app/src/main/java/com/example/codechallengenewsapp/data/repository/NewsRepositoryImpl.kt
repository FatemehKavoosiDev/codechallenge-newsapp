package com.example.codechallengenewsapp.data.repository

import com.example.codechallengenewsapp.data.datasource.local.LocalDataSource
import com.example.codechallengenewsapp.data.datasource.local.entity.NewsEntity
import com.example.codechallengenewsapp.data.datasource.network.RemoteDataSource
import com.example.codechallengenewsapp.domain.model.News
import com.example.codechallengenewsapp.domain.model.NewsDetails
import com.example.codechallengenewsapp.data.model.mapToNews
import com.example.codechallengenewsapp.data.model.mapToNewsDetails
import com.example.codechallengenewsapp.data.model.mapToNewsEntity
import com.example.codechallengenewsapp.di.CoroutineModule.CoroutineScopeIo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class NewsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    @CoroutineScopeIo private val externalScope: CoroutineScope,
) : NewsRepository {

    init {
        refreshNews()
    }

    override fun getAllNews(): Flow<List<News>> = localDataSource.getAllNews().map { newsEntity ->
        newsEntity.map {
            it.mapToNews()
        }
    }


    private fun refreshNews() {
        externalScope.launch {
            try {
                val response = remoteDataSource.getAllNews()
                if (response.isSuccessful) {
                    val listNewsEntity = response.body()!!.data.map { newsNetwork ->
                        newsNetwork.mapToNewsEntity()
                    }
                    updateLocalDataSource(listNewsEntity)
                }
            } catch (e: Exception) {
               // myLog("error in refresh news $e")
            }
        }
    }

    private suspend fun updateLocalDataSource(listNewsEntity: List<NewsEntity>) {
        localDataSource.deleteAllNews()
        localDataSource.insertNews(listNewsEntity)
    }

    override fun getNewsDetails(id: Int): Flow<NewsDetails> =
        localDataSource.getNewsDetails(id).map { newsEntity ->
            newsEntity.mapToNewsDetails()
        }

}