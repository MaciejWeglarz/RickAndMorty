package com.maciejweglarz.rickandmortyapp.details.data.mapper

import com.maciejweglarz.rickandmortyapp.details.data.model.CharacterDetailsResponseData
import com.maciejweglarz.rickandmortyapp.details.domain.model.CharacterDetailsInfo
import javax.inject.Inject

interface CharacterDetailsInfoMapper {
    fun mapCharacterDetailsData(characterDetailsData: CharacterDetailsResponseData): CharacterDetailsInfo
}

class CharacterDetailsInfoMapperImpl @Inject constructor() : CharacterDetailsInfoMapper {
    override fun mapCharacterDetailsData(characterDetailsData: CharacterDetailsResponseData): CharacterDetailsInfo {
        return CharacterDetailsInfo(
            id = characterDetailsData.id,
            name = characterDetailsData.name,
            image = characterDetailsData.image,
            status = characterDetailsData.status,
            type = characterDetailsData.type,
            sex = characterDetailsData.sex,
            origin = characterDetailsData.origin.name,
            created = characterDetailsData.created,
            numberOfEpisodes = characterDetailsData.episode
        )
    }
}
