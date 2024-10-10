package com.aashishtathod.dev.quickheadlines.domain.mapper

import com.aashishtathod.dev.quickheadlines.data.source.local.entity.ArticleEntity
import com.aashishtathod.dev.quickheadlines.data.source.remote.dto.ArticleDto
import com.aashishtathod.dev.quickheadlines.domain.model.NewsModel

fun List<ArticleDto>.articleDtoListToNewsModelList(): List<NewsModel> {
    return this.map { newsDto ->
        NewsModel(
            title = newsDto.title,
            description = newsDto.description,
            imageUrl = newsDto.imageUrl
        )
    }
}

fun List<ArticleEntity>.articleEntityListToNewsModelList(): List<NewsModel> {
    return this.map { newsEntity ->
        NewsModel(
            title = newsEntity.title,
            description = newsEntity.description,
            imageUrl = newsEntity.imageUrl
        )
    }
}