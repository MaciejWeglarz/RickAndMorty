package com.maciejweglarz.rickandmortyapp.details.domain.repository

import arrow.core.Either
import com.maciejweglarz.rickandmortyapp.core.network.adapter.ApiError
import com.maciejweglarz.rickandmortyapp.details.domain.model.CharacterDetailsInfo

interface CharacterDetailsRepository {

    suspend fun getCharacterDetails(characterId: Int): Either<ApiError, CharacterDetailsInfo>
}