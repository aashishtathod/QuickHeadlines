package com.aashishtathod.dev.quickheadlines.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.impl.Migration_1_2
import com.aashishtathod.dev.quickheadlines.data.source.local.dao.NewsDao
import com.aashishtathod.dev.quickheadlines.data.source.local.entity.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 2)
abstract class NewsDataBase : RoomDatabase() {

    abstract val newsDao: NewsDao

    /*companion object {
        val Migration_1_2 = object: Migration(1,2){
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE user ")
            }

        }
    }*/
}