package com.lizardoreyes.rickmortykmp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CharacterModel(
    val id: Int,
    val name: String,
    val isAlive: Boolean,
    val species: String,
    val type: String,
    val image: String,
    val gender: String,
    val origin: String,
    val episode: List<String>
)
