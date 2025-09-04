package com.maciejweglarz.rickandmortyapp.list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maciejweglarz.rickandmortyapp.core.network.adapter.ApiError
import com.maciejweglarz.rickandmortyapp.core.utils.ViewState
import com.maciejweglarz.rickandmortyapp.list.domain.repository.CharacterListRepository
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
class CharacterListViewModel @Inject constructor(
    private val characterListRepository: CharacterListRepository
) : ViewModel() {

    private val _state = MutableStateFlow(CharacterListViewState())
    val state: StateFlow<CharacterListViewState> = _state.asStateFlow()

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(charactersListViewState = ViewState.Loading())
            }
            withContext(Dispatchers.IO) {
                characterListRepository.getCharacters()
                    .onRight { characters ->
                        val sortedCharacters = characters.sortedBy { character ->
                            character.name
                        }
                        _state.update { state ->
                            state.copy(
                                charactersListViewState = ViewState.Content(sortedCharacters)
                            )
                        }
                    }
                    .onLeft { error ->
                        when (error) {
                            is ApiError.HttpError -> _state.update { state ->
                                state.copy(
                                    charactersListViewState = ViewState.Error(error.message)
                                )
                            }

                            is ApiError.NetworkError -> _state.update { state ->
                                state.copy(
                                    charactersListViewState = ViewState.Error(error.message)
                                )
                            }

                            is ApiError.UnknownError -> _state.update { state ->
                                state.copy(
                                    charactersListViewState = ViewState.Error(error.message)
                                )
                            }
                        }
                    }
            }
        }
    }
}