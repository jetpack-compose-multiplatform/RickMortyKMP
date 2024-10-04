package com.lizardoreyes.rickmortykmp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.lizardoreyes.rickmortykmp.data.database.RickMortyDatabase
import com.lizardoreyes.rickmortykmp.data.remote.ApiService
import com.lizardoreyes.rickmortykmp.data.remote.paging.CharactersPagingSource
import com.lizardoreyes.rickmortykmp.domain.Repository
import com.lizardoreyes.rickmortykmp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val api: ApiService,
    private val charactersPagingSource: CharactersPagingSource,
    private val rickMortyDatabase: RickMortyDatabase
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

    override suspend fun getCharacterDatabase() {
        rickMortyDatabase.getPreferencesDao().getCharacterOfTheDayDatabase()
    }
}