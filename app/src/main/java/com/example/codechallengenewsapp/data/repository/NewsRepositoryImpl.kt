package com.example.codechallengenewsapp.data.repository

import com.example.codechallengenewsapp.data.datasource.network.RemoteDataSource
import com.example.codechallengenewsapp.data.model.News
import com.example.codechallengenewsapp.data.model.mapToNews
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class NewsRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    NewsRepository {
    override fun getAllNews(): Flow<Result<List<News>>> = flow {
        try {

            val response = remoteDataSource.getAllNews()
            if (response.isSuccessful)
                emit(Result.success(response.body()!!.data.map { it.mapToNews() }))
            else emit(Result.failure(Exception("exception in data layer")))

        } catch (e: Exception) {
            emit(Result.failure(Exception("exception in data layer $e")))
        }
    }

    override fun getNewsDetails(): Flow<News> {
        TODO("Not yet implemented")
    }

}