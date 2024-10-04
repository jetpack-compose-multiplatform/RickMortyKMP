package com.lizardoreyes.rickmortykmp.domain

import com.lizardoreyes.rickmortykmp.domain.model.CharacterModel
import com.lizardoreyes.rickmortykmp.domain.model.CharacterOfTheDayModel
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class GetRandomCharacterCaseUse(private val repository: Repository) {

    suspend operator fun invoke(): CharacterModel {
        val characterOfTheDay = repository.getCharacterDatabase()
        val selectedDay = getCurrentDayOfTheYear()

        return if(characterOfTheDay != null && characterOfTheDay.selectedDay == selectedDay) {
            characterOfTheDay.characterModel
        } else {
            val result = generateRandomCharacter()
            repository.saveCharacterOfTheDay(CharacterOfTheDayModel(result, selectedDay))
            result
        }
    }

    private suspend fun generateRandomCharacter(): CharacterModel {
        val random = (1..826).random().toString()
        return repository.getSingleCharacter(random)
    }

    private fun getCurrentDayOfTheYear(): String {
        val instant = Clock.System.now()
        val localTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        return "${localTime.dayOfYear}${localTime.year}"
    }
}