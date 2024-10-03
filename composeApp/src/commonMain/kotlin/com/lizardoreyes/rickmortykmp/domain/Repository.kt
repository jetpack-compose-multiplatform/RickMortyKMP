package com.lizardoreyes.rickmortykmp.domain

import com.lizardoreyes.rickmortykmp.domain.model.CharacterModel

interface Repository {
    suspend fun getSingleCharacter(id: String): CharacterModel
}