package com.maciejweglarz.rickandmortyapp.details.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterDetailsResponseData(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "image") val image: String,
    @Json(name = "status") val status: String,
    @Json(name = "type") val type: String,
    @Json(name = "gender") val sex: String,
    @Json(name = "origin") val origin: Origin,
    @Json(name = "created") val created: String,
    @Json(name = "episode") val episode: List<String>
)

@JsonClass(generateAdapter = true)
data class Origin(
    @Json(name = "name") val name: String
)