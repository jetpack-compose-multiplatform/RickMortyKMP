package com.lizardoreyes.rickmortykmp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.lizardoreyes.rickmortykmp.data.database.RickMortyDatabase
import com.lizardoreyes.rickmortykmp.data.database.entity.CharacterOfTheDayEntity
import com.lizardoreyes.rickmortykmp.data.remote.ApiService
import com.lizardoreyes.rickmortykmp.data.remote.paging.CharactersPagingSource
import com.lizardoreyes.rickmortykmp.data.remote.paging.EpisodesPagingSource
import com.lizardoreyes.rickmortykmp.domain.Repository
import com.lizardoreyes.rickmortykmp.domain.model.CharacterModel
import com.lizardoreyes.rickmortykmp.domain.model.CharacterOfTheDayModel
import com.lizardoreyes.rickmortykmp.domain.model.EpisodeModel
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val api: ApiService,
    private val charactersPagingSource: CharactersPagingSource,
    private val rickMortyDatabase: RickMortyDatabase,
    private val episodesPagingSource: EpisodesPagingSource
) : Repository {

    companion object {
        private const val MAX_ITEMS = 20
        private const val PREFETCH_ITEMS = 5
    }

    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return api.getSingleCharacter(id).toDomain()
    }

    override fun getAllCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = { charactersPagingSource }
        ).flow
    }

    override suspend fun getCharacterDatabase(): CharacterOfTheDayModel? {
        return rickMortyDatabase.getPreferencesDao().getCharacterOfTheDayDatabase()?.toDomain()
    }

    override suspend fun saveCharacterOfTheDay(characterOfTheDay: CharacterOfTheDayModel) {
        rickMortyDatabase.getPreferencesDao().saveCharacterOfTheDayDatabase(
            characterOfTheDay.toEntity()
        )
    }

    override fun getAllEpisodes(): Flow<PagingData<EpisodeModel>> {
        return Pager(
            config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = { episodesPagingSource }
        ).flow
    }
}