package com.maciejweglarz.rickandmortyapp.list.presentation

import androidx.compose.runtime.Immutable
import com.maciejweglarz.rickandmortyapp.core.utils.ViewState
import com.maciejweglarz.rickandmortyapp.list.domain.model.CharacterInfo


@Immutable
data class CharacterListViewState(
    val charactersListViewState: ViewState<List<CharacterInfo>> = ViewState.Loading()
)