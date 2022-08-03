package com.example.shared_foundation.usecase

import com.example.shared_foundation.uistate.ScreenUiState
import kotlinx.coroutines.flow.Flow

interface ViewModelUseCase<Action : UseCaseAction, State : ScreenUiState> {
    suspend operator fun invoke(action: Action)

    fun observe() : Flow<State>

    fun onCleared()
}