package com.lizardoreyes.rickmortykmp.domain.model

import com.lizardoreyes.rickmortykmp.data.database.entity.CharacterOfTheDayEntity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

data class CharacterOfTheDayModel(
    val characterModel: CharacterModel,
    val selectedDay: String
) {
    fun toEntity(): CharacterOfTheDayEntity {
        return CharacterOfTheDayEntity(
            id = characterModel.id,
            name = characterModel.name,
            isAlive = characterModel.isAlive,
            species = characterModel.species,
            type = characterModel.type,
            image = characterModel.image,
            selectedDay = selectedDay,
            origin = characterModel.origin,
            gender = characterModel.gender,
            episode = Json.encodeToString(characterModel.episode)
        )
    }
}