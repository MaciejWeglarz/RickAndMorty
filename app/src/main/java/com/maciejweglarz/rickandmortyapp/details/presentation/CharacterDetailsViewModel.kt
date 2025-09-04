package com.maciejweglarz.rickandmortyapp.details.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.util.copy
import com.maciejweglarz.rickandmortyapp.core.network.adapter.ApiError
import com.maciejweglarz.rickandmortyapp.core.utils.ViewState
import com.maciejweglarz.rickandmortyapp.details.domain.repository.CharacterDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val characterDetailsRepository: CharacterDetailsRepository
) : ViewModel() {

    private val id = checkNotNull(savedStateHandle.get<Int>("characterId"))
    private val _state = MutableStateFlow(CharacterDetailsViewState())
    val state: StateFlow<CharacterDetailsViewState> = _state.asStateFlow()

    init {
        getCharacterDetails()
    }

    private fun getCharacterDetails() {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(characterDetailsViewState = ViewState.Loading())
            }
            withContext(Dispatchers.IO) {
                characterDetailsRepository.getCharacterDetails(id)
                    .onRight { characterDetails ->
                        _state.update { state ->
                            state.copy(
                                characterDetailsViewState = ViewState.Content(characterDetails)
                            )
                        }
                    }
                    .onLeft { error ->
                        when (error) {
                            is ApiError.HttpError -> _state.update { state ->
                                state.copy(
                                    characterDetailsViewState = ViewState.Error(error.message)
                                )
                            }

                            is ApiError.NetworkError -> _state.update { state ->
                                state.copy(
                                    characterDetailsViewState = ViewState.Error(error.message)
                                )
                            }

                            is ApiError.UnknownError -> _state.update { state ->
                                state.copy(
                                    characterDetailsViewState = ViewState.Error(error.message)
                                )
                            }

                        }
                    }
            }
        }
    }
}
