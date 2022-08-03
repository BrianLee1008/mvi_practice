package com.example.feed_domain.di.usecase_module

import com.example.feed_domain.usecase.GetFeedArticleUseCase
import com.example.feed_domain.usecase.GetFeedArticleUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
abstract class FeedUseCaseModule {

    @ViewModelScoped
    @Binds
    abstract fun bindsGetFeedArticleUseCase(impl: GetFeedArticleUseCaseImpl): GetFeedArticleUseCase
}