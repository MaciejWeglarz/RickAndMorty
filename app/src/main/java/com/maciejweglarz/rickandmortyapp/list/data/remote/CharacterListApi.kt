package com.maciejweglarz.rickandmortyapp.list.data.remote

import arrow.core.Either
import com.maciejweglarz.rickandmortyapp.core.network.adapter.ApiError
import com.maciejweglarz.rickandmortyapp.list.data.model.CharactersResponseData
import retrofit2.http.GET

interface CharacterListApi {

    @GET("character")
    suspend fun getCharacters(): Either<ApiError, CharactersResponseData>
}