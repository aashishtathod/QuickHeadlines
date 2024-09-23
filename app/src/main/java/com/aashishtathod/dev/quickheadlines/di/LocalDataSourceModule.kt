package com.aashishtathod.dev.quickheadlines.di

import android.content.Context
import androidx.room.Room
import com.aashishtathod.dev.quickheadlines.data.source.local.dao.NewsDao
import com.aashishtathod.dev.quickheadlines.data.source.local.db.NewsDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): NewsDataBase {
        return Room.databaseBuilder(
            context,
            NewsDataBase::class.java,
            "news_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(dataBase: NewsDataBase): NewsDao {
        return dataBase.newsDao
    }
}