package com.lizardoreyes.rickmortykmp.domain

import com.lizardoreyes.rickmortykmp.domain.model.CharacterModel

class GetRandomCharacterCaseUse(private val repository: Repository) {
    suspend operator fun invoke(): CharacterModel {
        val random = (1..826).random().toString()
        return repository.getSingleCharacter(random)
    }
}