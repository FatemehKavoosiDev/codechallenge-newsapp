package com.example.codechallengenewsapp.di

import android.content.Context
import androidx.room.Room
import com.example.codechallengenewsapp.data.datasource.local.NewsDatabase
import com.example.codechallengenewsapp.data.datasource.local.dao.NewsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): NewsDatabase {
        return Room.databaseBuilder(
            appContext,
            NewsDatabase::class.java,
            "news.db"
        ).build()
    }

    @Provides
    fun provideChannelDao(newsDatabase: NewsDatabase): NewsDao {
        return newsDatabase.newsDao()
    }
}