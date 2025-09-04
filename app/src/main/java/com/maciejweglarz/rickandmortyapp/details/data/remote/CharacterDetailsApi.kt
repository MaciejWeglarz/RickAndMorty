package com.maciejweglarz.rickandmortyapp.details.data.remote

import arrow.core.Either
import com.maciejweglarz.rickandmortyapp.core.network.adapter.ApiError
import com.maciejweglarz.rickandmortyapp.details.data.model.CharacterDetailsResponseData
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterDetailsApi {

    @GET("character/{id}")
    suspend fun getDetailsCharacter(@Path("id") characterId: Int): Either<ApiError, CharacterDetailsResponseData>

}