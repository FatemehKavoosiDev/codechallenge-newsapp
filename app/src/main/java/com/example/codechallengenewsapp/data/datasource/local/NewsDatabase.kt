package com.example.codechallengenewsapp.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.codechallengenewsapp.data.datasource.local.dao.NewsDao
import com.example.codechallengenewsapp.data.datasource.local.entity.NewsEntity

@Database(entities = [NewsEntity::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}