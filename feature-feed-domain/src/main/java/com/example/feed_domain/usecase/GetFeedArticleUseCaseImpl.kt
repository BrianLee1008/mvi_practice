package com.example.feed_domain.usecase

import com.example.feed_data.model.FeedArticleEntity
import com.example.feed_data.repository.FeedArticleRepository
import com.example.shared_common_domain.uistate.CommonArticleContentUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetFeedArticleUseCaseImpl @Inject constructor(
    private val feedArticleRepository: FeedArticleRepository
) : GetFeedArticleUseCase {

    private val useCaseState = MutableStateFlow(FeedViewModelState(isLoading = true))

    // UseCase Action 을 파라미터로 받고 api 통신으로도 데이터를 받아 useCaseState Flow 에 업데이트 쳐준다.
    override suspend fun invoke(action: GetFeedArticleUseCaseAction) {
        withContext(Dispatchers.IO) {
            val getFeedArticle = feedArticleRepository.getFeedArticleList()
            getFeedArticle.onSuccess { feedList ->
                useCaseState.update {
                    it.copy(
                        isLoading = action.isLoading,
                        feedArticles = entityToUiState(feedList),
                        error = null
                    )
                }
            }.onFailure { error ->
                useCaseState.update {
                    it.copy(
                        isLoading = action.isLoading,
                        error = error
                    )
                }
            }
        }
    }

    private fun entityToUiState(entity: List<FeedArticleEntity>): List<CommonArticleContentUiState> {
        val list = mutableListOf<CommonArticleContentUiState>()
        entity.forEach {
            val i = CommonArticleContentUiState(
                title = it.articleTitle,
                content = it.articleContent
            )
            list.add(i)
        }
        return list
    }

    override fun observe(): Flow<FeedMviUiState> = useCaseState.map { it.toUiState() }

    override fun onCleared() {
        TODO("Not yet implemented")
    }
}

/**
 * UseCase 에서 통신한 결과값대로 State 정의 받아 MVI UiState 로 반환
 * */
private data class FeedViewModelState(
    val isLoading: Boolean = false,
    val feedArticles: List<CommonArticleContentUiState> = emptyList(),
    val error: Throwable? = null
) {
    fun toUiState(): FeedMviUiState = when {

        // 1. 에러 x, 아티클도 있을 경우
        (error == null && feedArticles.isNotEmpty()) ->
            FeedMviUiState.HasArticleList(isLoading = isLoading, articleList = feedArticles)

        // 2. 에러 x, 아티클 없을 경우
        (error == null && feedArticles.isEmpty()) ->
            // 3. 로딩중이거나 로딩중이 아닐 경우
            if (isLoading) FeedMviUiState.Loading else FeedMviUiState.EmptyList(isLoading = isLoading)

        // 4. 그외
        else -> FeedMviUiState.Error(isLoading = isLoading, error = error)

    }
}