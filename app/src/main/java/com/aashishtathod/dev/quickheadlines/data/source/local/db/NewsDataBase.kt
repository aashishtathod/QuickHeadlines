package com.aashishtathod.dev.quickheadlines.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aashishtathod.dev.quickheadlines.data.source.local.dao.NewsDao
import com.aashishtathod.dev.quickheadlines.data.source.local.entity.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 1)
abstract class NewsDataBase : RoomDatabase() {

    abstract val newsDao: NewsDao
}