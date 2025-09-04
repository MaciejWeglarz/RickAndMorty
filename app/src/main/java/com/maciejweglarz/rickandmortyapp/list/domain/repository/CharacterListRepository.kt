package com.maciejweglarz.rickandmortyapp.list.domain.repository

import arrow.core.Either
import com.maciejweglarz.rickandmortyapp.core.network.adapter.ApiError
import com.maciejweglarz.rickandmortyapp.list.domain.model.CharacterInfo

interface CharacterListRepository {
    suspend fun getCharacters(): Either<ApiError, List<CharacterInfo>>
}