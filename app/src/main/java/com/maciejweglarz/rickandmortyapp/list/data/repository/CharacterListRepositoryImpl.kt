package com.maciejweglarz.rickandmortyapp.list.data.repository

import arrow.core.Either
import com.maciejweglarz.rickandmortyapp.core.network.adapter.ApiError
import com.maciejweglarz.rickandmortyapp.list.data.mapper.CharacterInfoMapper
import com.maciejweglarz.rickandmortyapp.list.data.remote.CharacterListApi
import com.maciejweglarz.rickandmortyapp.list.domain.model.CharacterInfo
import com.maciejweglarz.rickandmortyapp.list.domain.repository.CharacterListRepository
import javax.inject.Inject

class CharacterListRepositoryImpl @Inject constructor(
    private val characterListApi: CharacterListApi,
    private val characterMapper: CharacterInfoMapper
) : CharacterListRepository {
    override suspend fun getCharacters(): Either<ApiError, List<CharacterInfo>> {
        return characterListApi.getCharacters()
            .fold(
                ifLeft = { error -> Either.Left(error) },
                ifRight = { characterData -> Either.Right(characterMapper.mapCharacterData(characterData)) }
            )
    }
}