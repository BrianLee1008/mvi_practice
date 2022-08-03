package com.example.shared_common_ui.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.shared_common_domain.uistate.CommonArticleContentUiState


class CommonArticleDummyData : PreviewParameterProvider<CommonArticleContentUiState> {
    override val values: Sequence<CommonArticleContentUiState>
        get() = sequenceOf(
            dummyCommonArticleContentUiState1
        )

}

class CommonArticleListDummyData : PreviewParameterProvider<List<CommonArticleContentUiState>> {
    override val values: Sequence<List<CommonArticleContentUiState>>
        get() = sequenceOf(
            dummyCommonArticleContentUiStateList
        )
}