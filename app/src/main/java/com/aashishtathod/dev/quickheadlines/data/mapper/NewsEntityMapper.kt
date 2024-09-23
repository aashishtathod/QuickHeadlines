package com.aashishtathod.dev.quickheadlines.data.mapper

import com.aashishtathod.dev.quickheadlines.data.source.local.entity.ArticleEntity
import com.aashishtathod.dev.quickheadlines.data.source.remote.dto.ArticleDto


fun List<ArticleDto>.toArticleEntityList(): List<ArticleEntity> {
    return this.map { newsDto ->
        ArticleEntity(
            title = newsDto.title,
            description = newsDto.description,
            imageUrl = newsDto.imageUrl
        )
    }
}