package com.aashishtathod.dev.quickheadlines.di

import com.aashishtathod.dev.quickheadlines.data.repositoryImpl.NewsRepositoryImpl
import com.aashishtathod.dev.quickheadlines.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository
}