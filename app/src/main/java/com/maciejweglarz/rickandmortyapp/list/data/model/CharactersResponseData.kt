package com.maciejweglarz.rickandmortyapp.list.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharactersResponseData(
    @Json(name = "results") val results: List<CharacterData>
)

@JsonClass(generateAdapter = true)
data class CharacterData(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "image") val image: String,
    @Json(name = "episode") val episode: List<String>
)

