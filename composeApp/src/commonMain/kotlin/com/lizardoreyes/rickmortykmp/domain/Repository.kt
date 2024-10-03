package com.lizardoreyes.rickmortykmp.domain

import androidx.paging.PagingData
import com.lizardoreyes.rickmortykmp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getSingleCharacter(id: String): CharacterModel

    fun getAllCharacters(): Flow<PagingData<CharacterModel>>
}