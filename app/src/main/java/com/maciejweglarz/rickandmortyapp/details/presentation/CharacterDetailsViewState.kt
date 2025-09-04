package com.maciejweglarz.rickandmortyapp.details.presentation

import com.maciejweglarz.rickandmortyapp.core.utils.ViewState
import com.maciejweglarz.rickandmortyapp.details.domain.model.CharacterDetailsInfo

data class CharacterDetailsViewState(
    val characterDetailsViewState: ViewState<CharacterDetailsInfo> = ViewState.Loading()
)