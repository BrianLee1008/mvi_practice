package com.example.feed_feature.preview.fakedata

import com.example.feed_feature.view.feed.FeedUiStateHolder
import com.example.shared_common_ui.preview.dummyCommonArticleContentUiStateList

val dummyFeedUiStateHolder = FeedUiStateHolder(
    hasCommonArticle = true,
    uiStateList = dummyCommonArticleContentUiStateList,
    nextButtonEnabled = true,
    nextButtonClickListener = {}
)