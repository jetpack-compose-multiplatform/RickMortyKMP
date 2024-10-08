package com.lizardoreyes.rickmortykmp.domain

import androidx.paging.PagingData
import com.lizardoreyes.rickmortykmp.data.database.entity.CharacterOfTheDayEntity
import com.lizardoreyes.rickmortykmp.domain.model.CharacterModel
import com.lizardoreyes.rickmortykmp.domain.model.CharacterOfTheDayModel
import com.lizardoreyes.rickmortykmp.domain.model.EpisodeModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getSingleCharacter(id: String): CharacterModel
    fun getAllCharacters(): Flow<PagingData<CharacterModel>>
    suspend fun getCharacterDatabase(): CharacterOfTheDayModel?
    suspend fun saveCharacterOfTheDay(characterOfTheDay: CharacterOfTheDayModel)

    fun getAllEpisodes(): Flow<PagingData<EpisodeModel>>
    suspend fun getEpisodesForCharacter(episodes: List<String>): List<EpisodeModel>

}