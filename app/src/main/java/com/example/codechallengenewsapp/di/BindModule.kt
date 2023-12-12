package com.example.codechallengenewsapp.di

import com.example.codechallengenewsapp.data.datasource.local.LocalDataSource
import com.example.codechallengenewsapp.data.datasource.local.LocalDataSourceImpl
import com.example.codechallengenewsapp.data.datasource.network.RemoteDataSource
import com.example.codechallengenewsapp.data.datasource.network.RemoteDataSourceImpl
import com.example.codechallengenewsapp.data.repository.NewsRepository
import com.example.codechallengenewsapp.data.repository.NewsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class BindModule {

    @Binds
    abstract fun provideRemoteDataSource(remoteDataSource: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    abstract fun provideLocalDataSource(localDataSource: LocalDataSourceImpl): LocalDataSource

    @Singleton
    @Binds
    abstract fun provideRepository(newsRepository: NewsRepositoryImpl): NewsRepository

}