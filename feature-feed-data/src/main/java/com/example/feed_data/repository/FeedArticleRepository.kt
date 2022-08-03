package com.example.feed_data.repository

import com.example.feed_data.model.FeedArticleEntity

interface FeedArticleRepository {

    suspend fun getFeedArticle(): Result<FeedArticleEntity>

    suspend fun getFeedArticleList(): Result<List<FeedArticleEntity>>

}