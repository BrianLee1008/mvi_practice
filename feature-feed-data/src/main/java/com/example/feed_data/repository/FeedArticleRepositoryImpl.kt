package com.example.feed_data.repository

import com.example.feed_data.model.FeedArticleEntity
import javax.inject.Inject

class FeedArticleRepositoryImpl @Inject constructor(): FeedArticleRepository {

    override suspend fun getFeedArticle(): Result<FeedArticleEntity> {
        return runCatching {
            FeedArticleEntity(
                articleTitle = "title 1",
                articleContent = "content 1"
            )
        }
    }

    private val articleList = listOf(
        FeedArticleEntity(articleTitle = "title 1", articleContent = "content 1"),
        FeedArticleEntity(articleTitle = "title 2", articleContent = "content 2"),
        FeedArticleEntity(articleTitle = "title 3", articleContent = "content 3"),
        FeedArticleEntity(articleTitle = "title 4", articleContent = "content 4"),
        FeedArticleEntity(articleTitle = "title 5", articleContent = "content 5"),
        FeedArticleEntity(articleTitle = "title 6", articleContent = "content 6"),
        FeedArticleEntity(articleTitle = "title 7", articleContent = "content 7")
    )

    override suspend fun getFeedArticleList(): Result<List<FeedArticleEntity>> {
        return runCatching { articleList }
    }

}