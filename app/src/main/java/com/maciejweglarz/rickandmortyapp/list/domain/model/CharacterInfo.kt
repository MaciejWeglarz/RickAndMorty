package com.maciejweglarz.rickandmortyapp.list.domain.model

data class CharacterInfo(
    val id: Int,
    val name: String,
    val image: String,
    val numberOfEpisodes: Int
)
