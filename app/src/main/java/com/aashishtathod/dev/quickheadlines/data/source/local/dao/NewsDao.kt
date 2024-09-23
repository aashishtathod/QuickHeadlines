package com.aashishtathod.dev.quickheadlines.data.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.aashishtathod.dev.quickheadlines.data.source.local.entity.ArticleEntity

@Dao
interface NewsDao {

    @Query("SELECT * FROM news")
    suspend fun getTopHeadlines(): List<ArticleEntity>

    @Upsert
    suspend fun updateTopHeadlines(data: List<ArticleEntity>): Unit
}