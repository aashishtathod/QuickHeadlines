package com.aashishtathod.dev.quickheadlines.di

import com.aashishtathod.dev.quickheadlines.domain.repository.NewsRepository
import com.aashishtathod.dev.quickheadlines.domain.usecase.GetTopHeadlinesUseCase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    fun provideGetTopHeadlinesUseCase(repository: NewsRepository): GetTopHeadlinesUseCase {
        return GetTopHeadlinesUseCase(repository)
    }
}