package com.lizardoreyes.rickmortykmp.domain

import com.lizardoreyes.rickmortykmp.domain.model.CharacterModel
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class GetRandomCharacterCaseUse(private val repository: Repository) {
    suspend operator fun invoke(): CharacterModel {

        //val characterDatabase = repository.getSavedCharacter()

        val random = (1..826).random().toString()
        return repository.getSingleCharacter(random)
    }

    private fun getCurrentDayOfTheYear(): String {
        val instant = Clock.System.now()
        val localTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        return "${localTime.dayOfYear}${localTime.year}"
    }
}