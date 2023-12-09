package com.example.codechallengenewsapp.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.codechallengenewsapp.data.datasource.local.dao.NewsDao
import com.example.codechallengenewsapp.data.datasource.local.entity.NewsEntity

@Database(entities = [NewsEntity::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao

    companion object {
        @Volatile
        private var instance: NewsDatabase? = null

        fun getInstance(context: Context): NewsDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): NewsDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                NewsDatabase::class.java,
                "news.db"
            ).build()
        }
    }
}