package com.maciejweglarz.rickandmortyapp.details.domain.model

data class CharacterDetailsInfo(
    val id: Int,
    val name: String,
    val image: String,
    val status: String,
    val type: String,
    val sex: String,
    val origin: String,
    val created: String,
    val numberOfEpisodes: List<String>
)
