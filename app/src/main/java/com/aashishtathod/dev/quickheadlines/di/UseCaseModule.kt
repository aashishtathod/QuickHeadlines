package com.aashishtathod.dev.quickheadlines.di

import com.aashishtathod.dev.quickheadlines.domain.repository.NewsRepository
import com.aashishtathod.dev.quickheadlines.domain.usecase.GetTopHeadlinesUseCase
import com.aashishtathod.dev.quickheadlines.domain.usecase.SyncTopHeadlinesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetTopHeadlinesUseCase(repository: NewsRepository): GetTopHeadlinesUseCase {
        return GetTopHeadlinesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideSyncTopHeadlinesUseCase(repository: NewsRepository): SyncTopHeadlinesUseCase{
        return SyncTopHeadlinesUseCase(repository)
    }
}