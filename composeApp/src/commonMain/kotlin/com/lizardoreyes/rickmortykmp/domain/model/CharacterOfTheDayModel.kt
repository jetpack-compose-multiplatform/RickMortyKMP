package com.lizardoreyes.rickmortykmp.domain.model

import com.lizardoreyes.rickmortykmp.data.database.entity.CharacterOfTheDayEntity

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
            selectedDay = selectedDay
        )
    }
}