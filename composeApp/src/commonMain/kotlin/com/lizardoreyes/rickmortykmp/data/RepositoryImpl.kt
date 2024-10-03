package com.lizardoreyes.rickmortykmp.data

import com.lizardoreyes.rickmortykmp.data.remote.ApiService
import com.lizardoreyes.rickmortykmp.domain.Repository
import com.lizardoreyes.rickmortykmp.domain.model.CharacterModel

class RepositoryImpl(private val api: ApiService): Repository {
    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return api.getSingleCharacter(id).toDomain()
    }
}