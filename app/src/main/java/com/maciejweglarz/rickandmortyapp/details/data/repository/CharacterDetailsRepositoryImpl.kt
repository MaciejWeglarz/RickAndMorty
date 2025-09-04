package com.maciejweglarz.rickandmortyapp.details.data.repository

import arrow.core.Either
import com.maciejweglarz.rickandmortyapp.core.network.adapter.ApiError
import com.maciejweglarz.rickandmortyapp.details.data.mapper.CharacterDetailsInfoMapper
import com.maciejweglarz.rickandmortyapp.details.data.remote.CharacterDetailsApi
import com.maciejweglarz.rickandmortyapp.details.domain.model.CharacterDetailsInfo
import com.maciejweglarz.rickandmortyapp.details.domain.repository.CharacterDetailsRepository
import javax.inject.Inject

class CharacterDetailsRepositoryImpl @Inject constructor(
    private val characterDetailsApi: CharacterDetailsApi,
    private val characterDetailsMapper: CharacterDetailsInfoMapper
) : CharacterDetailsRepository {
    override suspend fun getCharacterDetails(characterId: Int): Either<ApiError, CharacterDetailsInfo> {
        return characterDetailsApi.getDetailsCharacter(characterId)
            .fold(
                ifLeft = { error -> Either.Left(error) },
                ifRight = { characterData -> Either.Right(characterDetailsMapper.mapCharacterDetailsData(characterData)) }
            )
    }
}