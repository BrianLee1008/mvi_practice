package com.example.feed_feature.view.feed

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feed_feature.viewmodel.FeedViewModel

@Composable
fun FeedRoute() {

    val feedViewModel = hiltViewModel<FeedViewModel>()

//    FeedScreen(
//        stateHolder = rememberFeedUiStateHolder(
//            hasCommonArticle =, // 아티클 있는지 없는지
//            uiStateList =, // uiStateList
//            nextButtonClickListener = { /*TODO*/ }, // 다음버튼 클릭리스너
//            nextButtonEnabled =  // 다음버튼 활성화여부
//        )
//    )
}