package com.example.feed_data.di.repository_module

import com.example.feed_data.repository.FeedArticleRepository
import com.example.feed_data.repository.FeedArticleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
abstract class FeedRepositoryModule {

    @Singleton
    @Binds
    abstract fun bindsFeedArticleRepository(impl: FeedArticleRepositoryImpl): FeedArticleRepository
}