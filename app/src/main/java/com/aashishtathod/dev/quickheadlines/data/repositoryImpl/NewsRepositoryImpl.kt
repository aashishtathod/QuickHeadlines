package com.aashishtathod.dev.quickheadlines.data.repositoryImpl

import com.aashishtathod.dev.quickheadlines.data.mapper.toArticleEntityList
import com.aashishtathod.dev.quickheadlines.data.source.local.dao.NewsDao
import com.aashishtathod.dev.quickheadlines.data.source.remote.api.NewsApi
import com.aashishtathod.dev.quickheadlines.domain.mapper.articleDtoListToNewsModelList
import com.aashishtathod.dev.quickheadlines.domain.mapper.articleEntityListToNewsModelList
import com.aashishtathod.dev.quickheadlines.domain.model.NewsModel
import com.aashishtathod.dev.quickheadlines.domain.repository.NewsRepository
import com.aashishtathod.dev.quickheadlines.utils.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi,
    private val newsDao: NewsDao
) : NewsRepository {

    override suspend fun getTopHeadlines(): Flow<ApiResponse<List<NewsModel>>> = flow {
        //emit(ApiResponse.Loading)
        try {
            val apiResponse = newsApi.getTopHeadlines()
            newsDao.updateTopHeadlines(apiResponse.articles.toArticleEntityList())
            emit(ApiResponse.Success(apiResponse.articles.articleDtoListToNewsModelList()))

        } catch (e: Exception) {
            println("Debug -> ${e.localizedMessage}")

            val dbResponse = newsDao.getTopHeadlines()
            if (dbResponse.isNotEmpty()) {
                emit(ApiResponse.Success(dbResponse.articleEntityListToNewsModelList()))
            } else {
                emit(ApiResponse.Failure(e.localizedMessage.orEmpty()))
            }

        }
    }.flowOn(Dispatchers.IO)
}