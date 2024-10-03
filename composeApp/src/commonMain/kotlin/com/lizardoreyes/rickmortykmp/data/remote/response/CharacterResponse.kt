package com.lizardoreyes.rickmortykmp.data.remote.response

import com.lizardoreyes.rickmortykmp.domain.model.CharacterModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("status")
    val status: String,
    @SerialName("species")
    val species: String,
    @SerialName("type")
    val type: String,
    @SerialName("image")
    val image: String
) {
    fun toDomain(): CharacterModel {
        return CharacterModel(
            id = id,
            name = name,
            isAlive = status.lowercase() == "alive",
            species = species,
            type = type,
            image = image
        )
    }
}