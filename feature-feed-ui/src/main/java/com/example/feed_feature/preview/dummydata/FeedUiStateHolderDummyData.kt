package com.example.feed_feature.preview.dummydata

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.feed_feature.preview.fakedata.dummyFeedUiStateHolder
import com.example.feed_feature.view.feed.FeedUiStateHolder

class FeedUiStateHolderDummyData : PreviewParameterProvider<FeedUiStateHolder>{
    override val values: Sequence<FeedUiStateHolder>
        get() = sequenceOf(
            dummyFeedUiStateHolder
        )
}