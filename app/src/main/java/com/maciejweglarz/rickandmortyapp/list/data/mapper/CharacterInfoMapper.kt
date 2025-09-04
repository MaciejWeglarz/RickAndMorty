package com.maciejweglarz.rickandmortyapp.list.data.mapper

import com.maciejweglarz.rickandmortyapp.list.data.model.CharactersResponseData
import com.maciejweglarz.rickandmortyapp.list.domain.model.CharacterInfo
import javax.inject.Inject

interface CharacterInfoMapper {
    fun mapCharacterData(characterData: CharactersResponseData): List<CharacterInfo>
}

class CharacterInfoMapperImpl @Inject constructor() : CharacterInfoMapper {
    override fun mapCharacterData(characterData: CharactersResponseData): List<CharacterInfo> {
        return characterData.results.map { characterData ->
            CharacterInfo(
                id = characterData.id,
                name = characterData.name,
                image = characterData.image,
                numberOfEpisodes = characterData.episode.size
            )
        }
    }
}